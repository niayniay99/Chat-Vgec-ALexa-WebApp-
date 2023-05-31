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

public class HosteltypeIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("HosteltypeIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Hostel Type Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot hosteltypeSlot = slots.get("hosteltype");
		String hosteltype = hosteltypeSlot.getValue();

		System.out.println("Information about : " + hosteltype);

		Database1 database1 = new Database1();
		String speechText = "", repromptText = "";

		if (hosteltype != null && !hosteltype.isEmpty()) {
			List ls3 = database1.searchHosteldescription(hosteltype);

			speechText = String.format(
					" It's Great our College offer's the Best facility on " + hosteltype + " Hostel. Details of it is "
							+ ls3.get(0) + ". Okay, If you want to know other information then Continue by Saying, "
							+ "I want information about Student Affairs / Scholarship /Hostel / Exam Section");
			repromptText = " It's Great our College offer's the Best facility on " + hosteltype + " Hostel. Details of it is "
					+ ls3.get(0) + ". Okay, If you want to know other information then Continue by Saying, "
					+ "I want information about Student Affairs / Scholarship /Hostel Information/ Exam Section";
		} else {

			List ls2 = database1.searchHosteltype();
			String speech2 = "";
			for (int i = 0; i < ls2.size(); i++) {
				speech2 = speech2 + " Hostel, " + (String) ls2.get(i);
			}

			speechText = "Sorry we don't have these type of Hostel , Currently Operational" + " hostels are " + speech2
					+ ", " + "You can ask me by saying,'Details About " + ls2.get(0) + "' Information.";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
