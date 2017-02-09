package com.accenture.timeline;

import java.util.Date;

public class Event {

	public Event() {
		super();
	}

	public Event(String eventName, Date startDate, Date endDate) {
		super();
		this.eventName = eventName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private Date	startDate;
	private Date	endDate;
	private String	eventName;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
