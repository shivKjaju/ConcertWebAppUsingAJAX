package classes;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.classes.Concert;
import javabean.classes.SearchResults;

public class ConcertsDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public Concert getDetails(String query) {
		Concert sr = new Concert();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try{
			System.out.println("CONNECTED");
			String sql = "SELECT * from concert where `Movie name` = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String movieName = rs.getString(2);
				String desc = rs.getString(3);
				Blob i = rs.getBlob(4);
				String rating = rs.getString(5);
				sr.setDescription(desc);
				sr.setId(id);
				sr.setMovieName(movieName);
				sr.setThumbnail(i);
				sr.setRating(rating);
			}
			db.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sr;
	}
	
	public Concert getConcert(int concertId) {
		Concert sr = new Concert();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try{
			String sql = "SELECT * from concert where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, concertId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String movieName = rs.getString(2);
				String desc = rs.getString(3);
				Blob i = rs.getBlob(4);
				String rating = rs.getString(5);
				sr.setDescription(desc);
				sr.setId(id);
				sr.setMovieName(movieName);
				sr.setThumbnail(i);
				sr.setRating(rating);
			}
			db.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sr;
	}
	
	public Concert updateInfo(Concert concert) {
		Concert sr = null;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try{
			System.out.println("CONNECTED");
			String sql = "UPDATE concert" + "Description = ?, Thumbnail=?, Rating=? " + "WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, concert.getDescription());
			ps.setBlob(2, concert.getThumbnail());
			ps.setString(3, concert.getRating());
			ps.setString(4, concert.getMovieName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		db.closeConnection();
		return sr;
	}
}