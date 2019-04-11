package javabean.classes;

import java.sql.Timestamp;

public class Performance {
	private int id;
	private Timestamp StartTime;
	private Timestamp EndTime;
	private int concertID;
	private int venueId;
	private Concert conc = new Concert();
	private Venue ven = new Venue();
	
	
	public Performance() {
		super();
	}


	public Performance(int id, Timestamp StartTime, Timestamp EndTime, int concertID, int venueId, Concert conc,
			Venue ven) {
		super();
		this.id = id;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.concertID = concertID;
		this.venueId = venueId;
		this.conc = conc;
		this.ven = ven;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Timestamp getStartTime() {
		return StartTime;
	}


	public void setStartTime(Timestamp startTime) {
		StartTime = startTime;
	}


	public Timestamp getEndTime() {
		return EndTime;
	}


	public void setEndTime(Timestamp endTime) {
		EndTime = endTime;
	}


	public int getConcertID() {
		return concertID;
	}


	public void setConcertID(int concertID) {
		this.concertID = concertID;
	}


	public int getVenueId() {
		return venueId;
	}


	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}


	public Concert getConc() {
		return conc;
	}


	public void setConc(Concert conc) {
		this.conc = conc;
	}


	public Venue getVen() {
		return ven;
	}


	public void setVen(Venue ven) {
		this.ven = ven;
	}
	
	
	
}
