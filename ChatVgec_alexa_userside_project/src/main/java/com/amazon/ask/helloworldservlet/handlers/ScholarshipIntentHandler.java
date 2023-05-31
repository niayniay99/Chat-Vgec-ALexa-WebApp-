package com.amazon.ask.helloworldservlet.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.helloworld_dao.Database1;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

public class ScholarshipIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("ScholarshipIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::ScholarshipIntent start::::::::::::");
		Database1 database1 = new Database1();

		List ls2 = database1.searchScholarshiptype();
		
		String speech2 = "";
		String speechText = "", repromptText = "";
		if (ls2.size() > 0) {
			for (int i = 0; i < ls2.size(); i++) {
				speech2 = speech2 + " Scholarship, " + (String) ls2.get(i);
			}
			speechText = String.format("There Are Various scholarships available such as " + speech2 + " Scholarship. "
					+ "You can ask me by saying," + "'Details About " + ls2.get(0) + "' Scholarship.");

			repromptText = "You can ask me by saying,' Get me Details About " + ls2.get(0) + "Scholarship.'.";
		} else {
			speechText = "Sorry,You can ask me by saying," + "I want information about Student Affairs / Scholarships /Hostel Information / Exam Section ";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
