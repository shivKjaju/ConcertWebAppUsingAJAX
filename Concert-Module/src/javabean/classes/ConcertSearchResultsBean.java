package javabean.classes;

public class ConcertSearchResultsBean {

	private String bandName;
	private String desc;
	private String venueName;
	private int availableSeats;
	private int rating;
	private String review;
	private String typeOfSeats;
	private int price;
	
	public ConcertSearchResultsBean() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	public ConcertSearchResultsBean(String bandName, String desc,
			String venueName, int pricePerSeat, int availableSeats, int rating,
			String review, String typeOfSeats, int price) {
		super();
		this.bandName = bandName;
		this.desc = desc;
		this.venueName = venueName;
		this.availableSeats = availableSeats;
		this.rating = rating;
		this.review = review;
		this.typeOfSeats = typeOfSeats;
		this.price = price;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getBandName() {
		return bandName;
	}


	public void setBandName(String bandName) {
		this.bandName = bandName;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getVenueName() {
		return venueName;
	}


	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}



	public String getTypeOfSeats() {
		return typeOfSeats;
	}



	public void setTypeOfSeats(String typeOfSeats) {
		this.typeOfSeats = typeOfSeats;
	}

}