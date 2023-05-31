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

public class EventtypeinfoIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("EventtypeinfoIntent"));	
		
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Event Type Info Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot eventtypeinfoSlot = slots.get("eventtypeinfo");
		String eventtypeinfo = eventtypeinfoSlot.getValue();
			
		System.out.println("Information about : " + eventtypeinfo);

		Database1 database1 = new Database1();
		String speechText = "", repromptText = "";
		
		if (eventtypeinfo != null && !eventtypeinfo.isEmpty()) {
			List eventtypeinfols = database1.searchEventtypeid(eventtypeinfo);
			int eventtypeinfoid = (int) eventtypeinfols.get(0);

			System.out.println("eventtypeinfoid: "+eventtypeinfoid);
			List ls6 = database1.searchEventtypedescription(eventtypeinfoid);
			
			speechText = String.format(
					" It's Great, our college has many cherishing events on " + eventtypeinfo + ". Details of it is "
							+ ls6.get(0)); 
							//+ ". Okay, If you want to know other information then Continue by Saying, "
						//	+ "I want information about Account / Area /Forms / Loan");
			repromptText = " It's Great our college has many cherishing events on " + eventtypeinfo + " Details of it is "
					+ ls6.get(0) + ". Okay, If you want to know other information then Continue bye Saying, "
					+ "I want information about Student Affairs / Scholarship / Hostel / Exam Section";

		}
		
		else {

			List ls5 = database1.searchEventtype();
			String speech5 = "";
			for (int i = 0; i < ls5.size(); i++) {
				speech5 = speech5 + " Event, " + (String) ls5.get(i);
			}

			speechText = "Sorry we don't have these type of Event , Currently Operational" + " Events are " + speech5
					+ " Event, " + "You can ask me by saying,'Details About " + ls5.get(0) + "'.";
		}

		return arg0.getResponseBuilder().withSpeech(speechText).withReprompt(repromptText)
				.withSimpleCard("AIBB", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
