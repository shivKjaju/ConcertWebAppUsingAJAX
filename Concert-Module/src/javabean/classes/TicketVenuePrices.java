package javabean.classes;

public class TicketVenuePrices {
	private int idTicketVenuePrices;
	private int TicketPrice;
	private int venueId;
	private int ticketTypeID;
	private int performanceID;
	
	public TicketVenuePrices() {
		super();
	}
	
	public TicketVenuePrices(int idTicketVenuePrices, int TicketPrice, int venueId, int ticketTypeID,
			int performanceID) {
		super();
		this.idTicketVenuePrices = idTicketVenuePrices;
		this.TicketPrice = TicketPrice;
		this.venueId = venueId;
		this.ticketTypeID = ticketTypeID;
		this.performanceID = performanceID;
	}
	
	public int getIdTicketVenuePrices() {
		return idTicketVenuePrices;
	}
	public void setIdTicketVenuePrices(int idTicketVenuePrices) {
		this.idTicketVenuePrices = idTicketVenuePrices;
	}
	public int getTicketPrice() {
		return TicketPrice;
	}
	public void setTicketPrice(int TicketPrice) {
		this.TicketPrice = TicketPrice;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public int getTicketTypeID() {
		return ticketTypeID;
	}
	public void setTicketTypeID(int ticketTypeID) {
		this.ticketTypeID = ticketTypeID;
	}
	public int getPerformanceID() {
		return performanceID;
	}
	public void setPerformanceID(int performanceID) {
		this.performanceID = performanceID;
	}

	
}
