package javabean.classes;

import java.util.Date;

public class CreditCard {
	public int id;
	public String cardHolderName;
	public String creditCardNumber;
	public double balance;
	public String cardType;
	public int userId;
	public String cvv;
	public Date expirationDate;
	
	
	public CreditCard() {
		super();
	}


	public CreditCard(int id, String cardHolderName, String creditCardNumber, double balance, String cardType,
			int userId, String cvv, Date expirationDate) {
		super();
		this.id = id;
		this.cardHolderName = cardHolderName;
		this.creditCardNumber = creditCardNumber;
		this.balance = balance;
		this.cardType = cardType;
		this.userId = userId;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCardHolderName() {
		return cardHolderName;
	}


	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}


	public String getCreditCardNumber() {
		return creditCardNumber;
	}


	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
