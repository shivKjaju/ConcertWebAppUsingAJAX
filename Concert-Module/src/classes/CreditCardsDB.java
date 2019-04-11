package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javabean.classes.CreditCard;

public class CreditCardsDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public CreditCard fetchCreditCardInfo(CreditCard cc) {
		CreditCard getCC = null;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "SELECT * FROM creditcards where CreditCardNumber =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cc.getCreditCardNumber());
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				int id = rs.getInt("Id");
				String cardHolderName = rs.getString("CardHolderName");
				String cardNumber = rs.getString("CreditCardNumber");
				double balance = rs.getDouble("Balance");
				String cardType = rs.getString("CardType");
				int userId = rs.getInt("UserId");
				String cvv = rs.getString("CVV");
				Date expDate = rs.getDate("ExpirationDate");
				getCC = new CreditCard(id, cardHolderName, cardNumber, balance, cardType, userId, cvv, expDate);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return getCC;
	}
	
	public void addCreditCardInfo(CreditCard cc) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO creditcards (Id, CardHolderName, CreditCardNumber, Balance, CardType, UserId, CVV, ExpirationDate)"
						 + "VALUES('" + cc.getId() + "' , '" + cc.getCardHolderName() + "' , '" + cc.getCreditCardNumber() + "' , '" + cc.getBalance()
						 + "' , '" + cc.getCardType() + "' , '" + cc.getUserId() + "' , '" + cc.getCvv() + "' , '" + cc.getExpirationDate() +  "' )" ;
			stmt.executeUpdate(sql);
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setNewBalance(String creditCardNumber, double balance) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "UPDATE creditcards" + "SET Balance=? where CreditCardNumber = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, creditCardNumber);
			ps.executeUpdate();
			db.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public double getBalance(String creditCardNumber) {
		double balance = 0;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "SELECT Balance from Bank where CreditCardNumber = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, creditCardNumber);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				balance = rs.getDouble(1);
			}
			db.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	public boolean verifyCard(String cardHolderName, String cardNumber, String cvv, String month, String day){
		boolean valid = false;
		if(cardHolderName != null && cardHolderName.matches("[A-Za-z0-9]+")){
			valid = true;
		}
		else{
			valid = false;
		}
		if(cardNumber != null && !cardNumber.matches("[A-Za-z0-9]+")){
			valid = true;
		}
		else{
			valid = false;
		}
		if(cvv != null && !cvv.matches("[A-Za-z0-9]+") && (cvv.length() == 3 || cvv.length() == 4)){
			valid= true;
		}
		else{
			valid = false;
		}
		if(month != null && month.matches("[A-Za-z0-9]+")){
			valid = true;
		}else{
			valid = false;
		}
		if(day != null && !day.matches("[A-Za-z0-9]+")){
			valid = true;
		}else{
			valid = false;
		}
		return valid;
	}
	public boolean validateCreditCard(CreditCard cc) {
		boolean valid = false;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "SELECT * from creditcards where CreditCardNumber = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cc.getCreditCardNumber());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(cc.getCreditCardNumber().equals(rs.getString("CreditCardNumber"))) {
					valid = true;
				}
			}
			db.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
}
