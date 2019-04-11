package classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javabean.classes.Users;

public class UsersDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Users readUserDetails(String username) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		Users person = new Users();
		try {
			String sql;
			sql = "SELECT * FROM users where Username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String address = rs.getString(4);
				String city = rs.getString(5);
				String state = rs.getString(6);
				String postalCode = rs.getString(7);
				String birthday = rs.getString(8);
				int type = rs.getInt(9);
				int status = rs.getInt(10);
				int numOfVisits = rs.getInt(11);
				String userName = rs.getString(12);
				String password = rs.getString(13);
				person.setId(id);
				person.setFirstName(fname);
				person.setLastName(lname);
				person.setAddress(address);
				person.setCity(city);
				person.setState(state);
				person.setBirthday(birthday);
				person.setPostalCode(postalCode);
				person.setType(type);
				person.setStatus(status);
				person.setNumOfVisits(numOfVisits);
				person.setUsername(userName);
				person.setPassword(password);
		}
		rs.close();
		ps.close();
		db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	public boolean checkUserExists(Users aUser) {
		boolean exist = false;
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql;
			String email = aUser.getEmailAddress();
			sql = "SELECT Username FROM users where EmailAddress = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			System.out.println(ps);
			rs = ps.executeQuery();
			while(rs.next()) {
				if (aUser.getUsername().equals(rs.getString("userName"))){
					exist = true;
				}
				else {
					exist = false;
				}
			}
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return exist;
	}
	
	public boolean checkUserNameExists(String userName) {
		boolean exist = false;
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		Statement stmt;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql;
			sql = "SELECT Username FROM users where Username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			
			if (rs.next()){
				System.out.println("VALIDAO");
				exist = true;
			}
			else {
				System.out.println("FAILED");
				exist = false;
			}
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return exist;
	}
	
	public String getPassword(String userName) {
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		String password = "";
		Statement stmt;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		try{
			String sql;
			sql = "SELECT Password FROM users where Username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()){
			password = rs.getString("Password");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return password;
	}	
	
	
	
	
	
	public int getUserID(String userName){
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		Statement stmt;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		int id = 0;
		try{
			String sql;
			sql = "Select Id from users where Username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
			ps.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		db.closeConnection();
		return id;
	}
	
	public int getLastId(){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		int id =0;
		try{
			String sql;
			stmt= conn.createStatement();
			sql = "Select MAX(Id) from users";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				id = rs.getInt(1);
			}
			stmt.close();
			db.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	
	public int getTicketPrice(int id){
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		Statement stmt;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		int ticketPrice = 0;
		try{
			String sql;
			sql = "SELECT TicketPrice from TicketVenuePrices join venue on venue.Id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				ticketPrice = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		db.closeConnection();
		return ticketPrice;
	}
	
	public String getTicketType(int id, int price){
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		Statement stmt;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		String typescol = null;
		String seatName = null;
		try{
			String sql;
			sql = "SELECT `Ticket Typescol`,SeatName from `Ticket Types` join TicketVenuePrices on TicketVenuePrices.ticketTypeId = ? where TicketPrice = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2,price);
			rs = ps.executeQuery();
			while(rs.next()){
				typescol = rs.getString(1);
				seatName = rs.getString(2);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		db.closeConnection();
		return typescol;
	}
	
	public int getTicketTypeId(int id){
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		Statement stmt;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		int ticketId = 0;
		try{
			String sql;
			sql = "Select ticketTypeID from TicketVenuePrices where venueID = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()){
				ticketId = rs.getInt(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			}
		return ticketId;
	}
	
	public String hashPasswords(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte[] mdArray = md.digest();
		StringBuilder sb = new StringBuilder(mdArray.length * 2);
		for(byte b : mdArray){
			int v = b & 0xff;
			if(v < 16){
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString();
	}
	public String getSeatType(int id, int price){
		DBAccessClass db = new DBAccessClass();
		PreparedStatement ps = null;
		Statement stmt;
		ResultSet rs = null;
		db.connectMeIn();
		conn = db.getConn();
		String typescol = null;
		String seatName = null;
		try{
			String sql;
			sql = "SELECT `Ticket Typescol`,SeatName from `Ticket Types` join TicketVenuePrices on TicketVenuePrices.ticketTypeId = ? where TicketPrice = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2,price);
			rs = ps.executeQuery();
			while(rs.next()){
				typescol = rs.getString(1);
				seatName = rs.getString(2);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		db.closeConnection();
		return seatName;
	}
	
	public void addUser(Users aUser) {
		PreparedStatement ps = null;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql;
			int id = aUser.getId();
			String firstName = aUser.getFirstName();
			String lastName = aUser.getLastName();
			String address = aUser.getAddress();
			String city = aUser.getCity();
			String state = aUser.getState();
			String postalCode = aUser.getPostalCode();
			String emailAddress = aUser.getEmailAddress();
			String phoneNumber = aUser.getPhoneNumber();
			String bDay = aUser.getBirthday();
			int type = aUser.getType();
			int status = aUser.getStatus();
			int numOfVisits = aUser.getNumOfVisits();
			String userName = aUser.getUsername();
			String password = aUser.getPassword();
			sql = "INSERT INTO users (Id, FirstName, LastName, Address, City, State, PostalCode,"
					+ " EmailAddress, PhoneNumber, Birthday, Type, Status, NumOfVisits, Username, Password)"
					+ "VALUES ('" + id + "' , '" + firstName  + "' , '" +  lastName  + "' , '"
					+ address  + "' , '" +  city  + "' , '" + state  + "' , '" +  postalCode  + "' , '"
					+ emailAddress  + "' , '" + phoneNumber + "' , '" + bDay + "' , '" + type + "' , '" + status + "' , '" 
					+ numOfVisits + "' , '" + userName + "' , '" + password + "' )" ;

			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
	}
}