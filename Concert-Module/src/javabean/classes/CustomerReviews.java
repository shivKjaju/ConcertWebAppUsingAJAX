package javabean.classes;

public class CustomerReviews {
	public int id;
	public int concertID;
	public int userID;
	public String ReviewDate;
	private int rating;
	private String review;
	
	public CustomerReviews() {
		super();
	}
	
	public CustomerReviews(int id, int concertID, int userID, String reviewDate, int rating, String review) {
		super();
		this.id = id;
		this.concertID = concertID;
		this.userID = userID;
		ReviewDate = reviewDate;
		this.rating = rating;
		this.review = review;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConcertID() {
		return concertID;
	}
	public void setConcertID(int concertID) {
		this.concertID = concertID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getReviewDate() {
		return ReviewDate;
	}
	public void setReviewDate(String reviewDate) {
		ReviewDate = reviewDate;
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
	
	
	
}
