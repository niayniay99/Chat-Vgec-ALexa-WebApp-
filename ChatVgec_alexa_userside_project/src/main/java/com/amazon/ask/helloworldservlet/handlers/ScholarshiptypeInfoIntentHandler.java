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

public class ScholarshiptypeInfoIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("ScholarshiptypeInfoIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Scholarship Type Information Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot scholarshiptypeinfoSlot = slots.get("scholarshiptypeinfo");
		String scholarshiptypeinfo = scholarshiptypeinfoSlot.getValue();

		System.out.println("Information about : " + scholarshiptypeinfo);

		Database1 database1 = new Database1();
		String speechText = "", repromptText = "";

		if (scholarshiptypeinfo != null && !scholarshiptypeinfo.isEmpty()) {
			List ls3 = database1.searchScholarshipdescription(scholarshiptypeinfo);

			speechText = String.format(
					" It's Great our Scholarship has the Best facility on " + scholarshiptypeinfo + " Scholarship. Details of it is "
							+ ls3.get(0) + ". Okay, If you want to know other information then Continue by Saying, "
							+ "I want information about Student Affairs / Scholarship /Hostel Information / Exam Section ");
			repromptText = " It's Great our Scholarship has the Best facility on " + scholarshiptypeinfo + " Scholarship. Details of it is "
					+ ls3.get(0) + ". Okay, If you want to know other information then Continue bye Saying, "
					+ "Student Affairs / Scholarship /Hostel Information / Exam Section ";
		} else {

			List ls2 = database1.searchScholarshiptype();
			String speech2 = "";
			for (int i = 0; i < ls2.size(); i++) {
				speech2 = speech2 + " Account, " + (String) ls2.get(i);
			}

			speechText = "Sorry we don't have these type of Scholarship , Currently Operational" + " scholarships are " + speech2
					+ ", " + "You can ask me by saying,'Details About " + ls2.get(0) + "'.";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
