package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javabean.classes.Concert;
import javabean.classes.Performance;
import javabean.classes.Venue;

public class PerformanceDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public Performance fetchPerformanceInformation(int concertID) {
		DBAccessClass db = new DBAccessClass();
		Performance perf = new Performance();
		db.connectMeIn();
		conn = db.getConn();
		try {
			ConcertsDB cdb = new ConcertsDB();
			Concert conc = cdb.getConcert(concertID);
			VenuesDB vdb = new VenuesDB();
			Venue ven = vdb.getVenueBuildingBasedOnConcert(concertID);
			String sql = "SELECT * FROM performance where concertID =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, concertID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				Timestamp startTime = rs.getTimestamp(2);
				Timestamp endTime = rs.getTimestamp(3);
				int concertId = rs.getInt(4);
				int venueId =  rs.getInt(5);
				perf.setConcertID(concertID);
				perf.setId(id);
				perf.setStartTime(startTime);
				perf.setEndTime(endTime);
				perf.setConcertID(concertId);
				perf.setVenueId(venueId);
				perf.setConc(conc);
				perf.setVen(ven);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return perf;
	}
	
	public Date getStartTime(int concertID){
		Date output = new Date(System.currentTimeMillis());
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "SELECT StartTime from performance join concert on performance.concertId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, concertID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			output = rs.getDate("StartTime");
			System.out.println(output);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public Performance getPerformanceBasedOnVenueID(int id) {
		Performance get_perf = new Performance();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			int venueID = id;
			String sql = "SELECT * FROM performance where venueID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, venueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				get_perf.setId(rs.getInt(1));
				get_perf.setStartTime(rs.getTimestamp(2));
				get_perf.setEndTime(rs.getTimestamp(3));
				get_perf.setConcertID(rs.getInt(4));
				get_perf.setVenueId(rs.getInt(5));
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return get_perf;
	}

	public ArrayList<Performance> getDetailsOfPerformance(String query){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		ArrayList<Performance> pl = new ArrayList<Performance>();
		try{
			String sql;
			sql="SELECT * from performance Inner Join concert on performance.concertID = concert.id Inner join venue on performance.venueID = venue.Id Inner join TicketVenuePrices on venue.Id = TicketVenuePrices.venueID  where (`Movie name` like ? )  ";
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + query + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Concert conc = new Concert(rs.getInt("concertID"), rs.getString("Movie name"), rs.getString("Description"), rs.getBlob("Thumbnail"),rs.getString("Rating"));
				Venue ven = new Venue(rs.getInt("venueID"),rs.getString("Name"),rs.getString("Address"),rs.getInt("ownerID"),rs.getString("City"),rs.getInt("totalSeats"),rs.getInt("classOfSeats"),rs.getInt("typeOneTotalSeats"),rs.getInt("typeTwoTotalSeats"),rs.getString("state"),rs.getString("PostalCode"));
				Performance perf = new Performance(rs.getInt("performanceID"),rs.getTimestamp("StartTime"),rs.getTimestamp("EndTime"),rs.getInt("concertID"),rs.getInt("venueID"), conc, ven);
				pl.add(perf);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return pl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

