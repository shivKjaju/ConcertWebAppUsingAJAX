package javabean.classes;

public class VenueAndSearchQuery {

	private String concertName;
	private String address;
	private int seats;
	
	public VenueAndSearchQuery() {
		// TODO Auto-generated constructor stub
		super();
	}
	public VenueAndSearchQuery(String concertName, String address, int seats) {
		super();
		this.concertName = concertName;
		this.address = address;
		this.seats = seats;
	}
	public String getConcertName() {
		return concertName;
	}
	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	
}
