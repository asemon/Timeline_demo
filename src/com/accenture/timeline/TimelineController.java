package com.accenture.timeline;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

@ManagedBean(name = "timelineController")
@ViewScoped
public class TimelineController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private TimelineModel		model				= new TimelineModel();;

	private boolean				selectable			= true;
	private boolean				zoomable			= true;
	private boolean				moveable			= true;
	private boolean				stackEvents			= true;
	private String				eventStyle			= "box";
	private boolean				axisOnTop;
	private boolean				showCurrentTime		= true;
	private boolean				showNavigation		= false;
	private String				styleClass			= "timeline-styles";
	private boolean				editable			= false;
	private Date				startDate;
	private Date				endDate;
	private String				eventName;
	private static final Date	ENDDATE				= createEndlessDate();
	private Date				currentDate			= setCurrentDate();
	private long				zoomMin				= 100;

	protected static DateFormat	dateFormatter		= new SimpleDateFormat("dd.MM.yy hh:mm");

	@PostConstruct
	public void initialize() {

		try {

			List<Event> eventList = new ArrayList<>();
			List<TimelineEvent> timelineEventList = new ArrayList<>();

			Event eventOne = new Event("Event 1", dateFormatter.parse("01.01.2001 00:00"),
					dateFormatter.parse("01.11.2011 00:00"));
			Event eventTwo = new Event("Event 2", dateFormatter.parse("01.07.2002 00:00"),
					dateFormatter.parse("01.01.2003 00:00"));
			Event eventThree = new Event("Event 3", dateFormatter.parse("01.01.2005 00:00"), null);
			eventList.add(eventOne);
			eventList.add(eventTwo);
			eventList.add(eventThree);
			for (Event ev : eventList) {
				if (ev.getEndDate() == null) {
					timelineEventList.add(new TimelineEvent("Timeline of " + ev.getEventName(), ev.getStartDate(),
							ENDDATE, editable, ev.getEventName(), styleClass));
				} else {
					timelineEventList.add(new TimelineEvent("Timeline of " + ev.getEventName(), ev.getStartDate(),
							ev.getEndDate(), editable, ev.getEventName(), styleClass));
				}

			}
			model.addAll(timelineEventList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TimelineModel getModel() {
		return model;
	}

	public void setModel(TimelineModel model) {
		this.model = model;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isZoomable() {
		return zoomable;
	}

	public void setZoomable(boolean zoomable) {
		this.zoomable = zoomable;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}

	public boolean isStackEvents() {
		return stackEvents;
	}

	public void setStackEvents(boolean stackEvents) {
		this.stackEvents = stackEvents;
	}

	public String getEventStyle() {
		return eventStyle;
	}

	public void setEventStyle(String eventStyle) {
		this.eventStyle = eventStyle;
	}

	public boolean isAxisOnTop() {
		return axisOnTop;
	}

	public void setAxisOnTop(boolean axisOnTop) {
		this.axisOnTop = axisOnTop;
	}

	public boolean isShowCurrentTime() {
		return showCurrentTime;
	}

	public void setShowCurrentTime(boolean showCurrentTime) {
		this.showCurrentTime = showCurrentTime;
	}

	public boolean isShowNavigation() {
		return showNavigation;
	}

	public void setShowNavigation(boolean showNavigation) {
		this.showNavigation = showNavigation;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void createEvent() {
		TimelineEvent newEvent = new TimelineEvent("Timeline of " + eventName, startDate, endDate, editable, eventName,
				styleClass);
		model.add(newEvent);
		this.setStartDate(null);
		this.setEndDate(null);

	}

	public static Date createEndlessDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2999, 1, 1, 0, 0);
		Date date = cal.getTime();
		return date;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Date setCurrentDate() {
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		currentDate = cal.getTime();
		return currentDate;
	}

	public long getZoomMin() {
		return zoomMin;
	}

	public void setZoomMin(long zoomMin) {
		this.zoomMin = zoomMin;
	}

}
