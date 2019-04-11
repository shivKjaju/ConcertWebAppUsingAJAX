package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import controller.CustomerReview;
import javabean.classes.CustomerReviews;

public class ReviewDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public CustomerReviews fetchReviewInformation(int concertId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		CustomerReviews cr = new CustomerReviews();
		try {
			String sql = "SELECT * FROM customerreviews where concertID =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, concertId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int cId = rs.getInt(2);
				int userId = rs.getInt(3);
				String reviewDate = rs.getString(4);
				int rating = rs.getInt(5);
				String review = rs.getString(6);
				cr.setId(id);
				cr.setConcertID(cId);
				cr.setUserID(userId);
				cr.setReviewDate(reviewDate);
				cr.setRating(rating);
				cr.setReview(review);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cr;
	}
	
	public void addNewReview(CustomerReviews cr) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			int id = cr.getId();
			int concertId = cr.getConcertID();
			int userId = cr.getUserID();
			String reviewDate = cr.getReviewDate();
			int rating = cr.getRating();
			String review = cr.getReview();
			String sql = "INSERT INTO customerreviews VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, concertId);
			ps.setInt(3, userId);
			ps.setString(4, reviewDate);
			ps.setInt(5, rating);
			ps.setString(6, review);
			ps.executeUpdate();
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getLastID(){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		ResultSet rs = null;
		int id = 0;
		try{
			String sql;
			stmt= conn.createStatement();
			sql = "Select MAX(Id) from customerreviews";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				id = rs.getInt(1);
			}
		db.closeConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	
	public boolean checkReviewContents(String textarea) {
		boolean valid = false;
		char [] car = textarea.toCharArray();
		if (car.length > 255) {
			valid = false;
		}
		else {
			valid = true;
		}
		return valid;
	}
}
