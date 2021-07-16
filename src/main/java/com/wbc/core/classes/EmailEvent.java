package main.java.com.wbc.core.classes;

import java.util.Date;
import java.util.UUID;

public class EmailEvent {
	
	private UUID uuid;
	private Date dateBegin;
	private Date dateEnd;
	private String organizer;
	private String description;
	private String location;
	private String summary;
	private String attendees;


	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAttendees() {
		return attendees;
	}

	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}

	public EmailEvent() {
		super();
	}

	public EmailEvent(Date dateBegin, Date dateEnd, String organizer, String description, String location,
			String summary, String attendees) {
		super();
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.organizer = organizer;
		this.description = description;
		this.location = location;
		this.summary = summary;
		this.attendees = attendees;
	}

	

}
