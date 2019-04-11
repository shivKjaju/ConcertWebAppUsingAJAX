package javabean.classes;

import java.sql.Blob;

public class Concert {
	public int id;
	public String movieName;
	public String description;
	public Blob thumbnail;
	public String rating;
	
	public Concert() {
		super();
	}

	public Concert(int id, String movieName, String description, Blob thumbnail, String rating) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.description = description;
		this.thumbnail = thumbnail;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
}
