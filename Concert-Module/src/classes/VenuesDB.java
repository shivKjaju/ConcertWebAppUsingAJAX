package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javabean.classes.Concert;
import javabean.classes.Venue;

public class VenuesDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public int getTotalSeats(int id) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		int totalSeats = 0;
		try {
			String sql;
			sql = "SELECT totalSeats from venue join performance on venue.Id = performance.venueId where performance.concertID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				totalSeats = rs.getInt(1);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return totalSeats;
	}
	
	public ArrayList<Venue> getMultipleVenueBuildings(String city) {
		ArrayList <Venue> venues = new ArrayList<>();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql;
			sql = "SELECT * FROM venue where City =?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Venue get_venue = new Venue();
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String address =rs.getString("Address");
				int ownerId = rs.getInt("ownerID");
				String state = rs.getString("State");
				String postalCode = rs.getString("PostalCode");
				get_venue.setId(id);
				get_venue.setName(name);
				get_venue.setAddress(address);
				get_venue.setOwnerId(ownerId);
				get_venue.setState(state);
				get_venue.setPostalCode(postalCode);
				venues.add(get_venue);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return venues;
	}
	
	public Venue getVenueBuildingBasedOnConcert(int concertID) {
		Venue output = new Venue();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql;
			sql = "SELECT * from venue join performance on venue.Id = performance.venueId where performance.concertID =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, concertID);
			ResultSet rs = ps.executeQuery();
			String addre = null;
			while(rs.next()){
				addre = rs.getString(3);
			}
			Venue get_venue = new Venue();
			sql = "SELECT * from venue where Address=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, addre );
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address =rs.getString(3);
				int ownerId = rs.getInt(4);
				String state = rs.getString(5);
				String postalCode = rs.getString(6);
				int totalSeats = rs.getInt(8);
				get_venue.setId(id);
				get_venue.setName(name);
				get_venue.setAddress(address);
				get_venue.setOwnerId(ownerId);
				get_venue.setState(state);
				get_venue.setPostalCode(postalCode);
				get_venue.setTotalSeats(totalSeats);
				output = get_venue;
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public Venue getIndividualVenueBuilding(Venue venue) {
		Venue output = null;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql;
			sql = "SELECT * FROM venue where Name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, venue.getName());
			ResultSet rs = ps.executeQuery();
			Venue get_venue = new Venue();
			while(rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String address =rs.getString(3);
			int ownerId = rs.getInt(4);
			String state = rs.getString(5);
			String postalCode = rs.getString(6);
			get_venue.setId(id);
			get_venue.setName(name);
			get_venue.setAddress(address);
			get_venue.setOwnerId(ownerId);
			get_venue.setState(state);
			get_venue.setPostalCode(postalCode);
			output = get_venue;
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}
}
