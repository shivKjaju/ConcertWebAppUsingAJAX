package javabean.classes;

import java.sql.Blob;
import java.sql.Date;

public class SearchResults {
    private String cName;
	private Blob image;
	private String address;
	private int tSeats;
	private Date date;
	
	public SearchResults() {
		super();
	}

	public SearchResults(String cName, Blob image, String address, int tSeats,
			Date date) {
		super();
		this.cName = cName;
		this.image = image;
		this.address = address;
		this.tSeats = tSeats;
		this.date = date;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int gettSeats() {
		return tSeats;
	}

	public void settSeats(int tSeats) {
		this.tSeats = tSeats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
