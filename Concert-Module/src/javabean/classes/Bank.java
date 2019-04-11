package javabean.classes;

public class Bank {
	
	private String user;
	private String concertName;
	private double balance;
	private String creditCard;
	private int ticketQuantity;
	private String venue;
	private double price;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(String user, String concertName, double balance, String creditCard, int ticketQuantity, String venue,
			double price) {
		super();
		this.user = user;
		this.concertName = concertName;
		this.balance = balance;
		this.creditCard = creditCard;
		this.ticketQuantity = ticketQuantity;
		this.venue = venue;
		this.price = price;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getConcertName() {
		return concertName;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public int getTicketQuantity() {
		return ticketQuantity;
	}

	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
