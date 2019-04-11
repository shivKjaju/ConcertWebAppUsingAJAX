package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javabean.classes.Concert;
import javabean.classes.CreditCard;
import javabean.classes.OrderItems;
import javabean.classes.Orders;
import javabean.classes.Performance;
import javabean.classes.TicketType;
import javabean.classes.TicketVenuePrices;
import javabean.classes.Users;
import javabean.classes.Venue;

public class OrdersDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public ArrayList<Orders> readExistingOrder(int customerId) {
		Orders order = new Orders();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		ArrayList<Orders> orders = new ArrayList<>();
		try {
			String sql = "SELECT * FROM orders where CustomerId= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int customerID = rs.getInt(2);
				int totalCost = rs.getInt(3);
				String orderDate = rs.getString(4);
				String billingAddress = rs.getString(5);
				String cardNumber = rs.getString(6);
				order = new Orders(id, customerID, totalCost, orderDate, billingAddress, cardNumber);
				orders.add(order);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public ArrayList<OrderItems> getOrderItems(int orderId) {
		OrderItems orderItem = new OrderItems();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		int id = 0;
		int orderID = 0;
		int performanceId = 0 ;
		int quantity = 0;
		Orders order = new Orders();
		Concert conc = new Concert();
		Performance perf = new Performance();
		TicketType ticketType = new TicketType();
		TicketVenuePrices tvp = new TicketVenuePrices();
		ArrayList<OrderItems> ordersItem = new ArrayList<>();
		try {
			//Get order item
			String sql = "SELECT * FROM orderitems where OrderId= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1);
				orderID = rs.getInt(2);
				performanceId = rs.getInt(3);
				quantity = rs.getInt(4);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ordersItem;
	}
	
	public OrderItems getCompleteOrderItemDetails(int orderItemId) {
		System.out.println("Order Item ID : " + orderItemId);
		OrderItems orderItem = new OrderItems();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "SELECT * FROM orderitems inner join performance on performance.Id = orderitems.PerformanceID inner join concert on concert.id = performance.concertID inner join TicketVenuePrices on TicketVenuePrices.performanceID = performance.Id inner join venue on venue.Id = performance.venueID where orderitems.Id = ?"; //inner join `Ticket Types` on `Ticket Types`.`idTicket Types` = TicketVenuePrices.ticketTypeID inner join orders on orders.id = orderitems.OrderId where orderitems.OrderId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderItemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Concert conc = new Concert(rs.getInt("id"), rs.getString("Movie Name"), rs.getString("Description"), rs.getBlob("Thumbnail"), rs.getString("rating"));
				Venue ven = new Venue (rs.getInt("Id"), rs.getString("Name"), rs.getString("Address"), rs.getInt("ownerID"), rs.getString("City"), rs.getInt("totalSeats"), 
						               rs.getInt("classOfSeats"), rs.getInt("typeOneTotalSeats"), rs.getInt("typeTwoTotalSeats"), rs.getString("State"), rs.getString("PostalCode"));
				Performance perf = new Performance(rs.getInt("Id"), rs.getTimestamp("StartTime"), rs.getTimestamp("EndTime"), rs.getInt("concertID"), rs.getInt("venueID"), conc, ven);
				TicketVenuePrices tvp = new TicketVenuePrices(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
				TicketType ticketType = new TicketType(rs.getInt(1), rs.getString(2), rs.getString(3));
				Orders order = new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
				orderItem = new OrderItems(rs.getInt("Id"), rs.getInt("OrderId"), rs.getInt("PerformanceID"), rs.getInt("Quantity"), order, conc, ticketType, tvp, perf, ven);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderItem;
	}
	
	//TODO: get all order complete details
	public Orders getOrderDetails(int orderId) {
		Orders order = new Orders();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "SELECT * FROM orders where Id= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int customerID = rs.getInt(2);
				int totalCost = rs.getInt(3);
				String orderDate = rs.getString(4);
				String billingAddress = rs.getString(5);
				String cardNumber = rs.getString(6);
				order = new Orders(id, customerID, totalCost, orderDate, billingAddress, cardNumber);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public Orders getOrderDetailsBasedOnCustomerId(int customerId) {
		Orders order = new Orders();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql = "SELECT * FROM orders where CustomerId= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int customerID = rs.getInt(2);
				int totalCost = rs.getInt(3);
				String orderDate = rs.getString(4);
				String billingAddress = rs.getString(5);
				String cardNumber = rs.getString(6);
				order = new Orders(id, customerID, totalCost, orderDate, billingAddress, cardNumber);
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	
	
	public void addOrder(Users u, CreditCard cc, int totalCost) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		UsersDB udb = new UsersDB();
		int id = udb.getLastId();
		String pattern = "MM/dd/yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		Date orderDate = new Date();
		String dateOrder = df.format(orderDate);
		try {
			String sql = "INSERT INTO orders (Id, CustomerId, TotalCost, OrderDate, BillingAddress, CreditCardNumber)"
						+ "VALUES(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id+1);
			ps.setInt(2, u.getId());
			ps.setInt(3, totalCost);
			ps.setString(4, dateOrder);
			ps.setString(5, u.getAddress());
			ps.setString(6, cc.getCreditCardNumber());
			ps.executeUpdate();
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeOrder(Orders order){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try{
			String sql = "Delete from orders where CustomerId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getCustomerId());
			ps.executeUpdate();
			db.closeConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void removeOrderItems(Performance perf){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try{
			String sql = "Delete from orderitems where PerformanceID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, perf.getId());
			ps.executeUpdate();
			db.closeConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public boolean placeOrder(int orderPerformanceID, int quantity,Venue ven,Orders order) {
		boolean success = false;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		UsersDB udb = new UsersDB();
		int orderid = order.getId();
		int id = udb.getLastId();
		int remaining = ven.getTotalSeats();
		int qty = 0;
		try {
			String sql = "SELECT * from orderitems where performanceID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderPerformanceID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			qty = rs.getInt("Quantity");
			}
			sql = "Insert into orderitems (Id,OrderId,PerformanceID,Quantity) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2,orderid);
			ps.setInt(3,orderPerformanceID);
			ps.setInt(4,ven.getTotalSeats());
			ps.executeUpdate();
			remaining = remaining - quantity; 
			if (remaining >= 0) {
				//Update Statement
				sql = "UPDATE orderitems set quantity = ?  where performanceID = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1,remaining);
				ps.setInt(2,orderPerformanceID);
				ps.executeUpdate();
				success = true;
				ps.close();
			}
			else {
				//TODO: Send an error
				success = false;
			}
			db.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public int getItemID (int orderID) {
		int id = 0;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try {
			String sql; 
			sql = "SELECT Id from orderitems where orderitems.OrderId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1);
			}
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return id;
	}
	
	public boolean updateSeats(int seats, String venueName){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		conn = db.getConn();
		try{
			String sql;
			sql = "Update venue set totalSeats = ?  where Name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,seats);
			ps.setString(2,venueName);
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		db.closeConnection();
		return true;
	}
	
}