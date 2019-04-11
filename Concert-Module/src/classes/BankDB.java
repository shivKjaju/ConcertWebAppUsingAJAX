package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javabean.classes.Bank;

public class BankDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public Bank getBalanceWithCreditCard(String creditCard) {
		Bank details = new Bank();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			System.out.println("CONNECTED");
			String sql = "SELECT * FROM Bank INNER JOIN creditcards on creditcards.CreditCardNumber where Bank.CreditCardNumber = ?";
			ps = conn.prepareStatement(sql);
			System.out.println("DAsdaDA : " + creditCard);
			ps.setString(1, creditCard);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				double balance = rs.getDouble("Balance");
				String cardName = rs.getString("CardHolderName");
				details.setBalance(balance);
				details.setCreditCard(creditCard);
				details.setUser(cardName);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return details;
	}
	
	public void updateBalance(String creditCard, double balance) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			System.out.println("CONNECTED");
			String sql = "UPDATE Bank SET Balance= ? where CreditCardNumber = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, creditCard);
			ps.executeUpdate();
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
