package com.amazon.ask.helloworldservlet.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.helloworld_dao.Database1;
import com.amazon.ask.model.Response;

public class EventtypeIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("EventtypeIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::EventtypeIntent start::::::::::::");
		Database1 database = new Database1();
		
		List ls4 = database.searchEventtype();
		
		String speech4 = "";
		String speechText = "", repromptText = "";
		if (ls4.size() > 0) {
			for (int i = 0; i < ls4.size(); i++) {
				speech4 = speech4 + " Event, " + (String) ls4.get(i);
			}
			speechText = String.format("There Are Various Event available such as " + speech4 + " Event. "
					+ "You can ask me by saying," + "' Get me Details About " + ls4.get(0) + "' Event.");

			repromptText = "You can ask me by saying,' Get me Details About " + ls4.get(0) + "' Event.";
		} else {
			speechText = "Sorry,You can ask me by saying," + "I want information about Student Affairs / Scholarship / Hostel / Exam Section ";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("AIBB", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
