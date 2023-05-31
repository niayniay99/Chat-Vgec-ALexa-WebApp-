package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "createeventtype_table")

public class EventtypeVO {

	@Id
	@Column(name = "eventtype_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventtypeid;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_description")
	private String eventDescription;

	@Column(name = "status")
	private boolean status = true;

	public int getEventtypeid() {
		return eventtypeid;
	}

	public void setEventtypeid(int eventtypeid) {
		this.eventtypeid = eventtypeid;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
