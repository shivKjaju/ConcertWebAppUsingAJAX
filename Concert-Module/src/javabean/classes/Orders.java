package javabean.classes;

public class Orders {
	private int id;
	public int customerId;
	public int totalCost;
	public String OrderDate;
	public String BillingAddress;
	public String CreditCardNumber;
	
	public Orders() {
		super();
	}
	
	public Orders(int id, int customerId, int totalCost, String orderDate, String billingAddress,
			String creditCardNumber) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.totalCost = totalCost;
		OrderDate = orderDate;
		BillingAddress = billingAddress;
		CreditCardNumber = creditCardNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getBillingAddress() {
		return BillingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		BillingAddress = billingAddress;
	}

	public String getCreditCardNumber() {
		return CreditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	
	
}
