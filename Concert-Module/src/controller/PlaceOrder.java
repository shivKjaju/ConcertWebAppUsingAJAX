package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.ConcertsDB;
import classes.CreditCardsDB;
import classes.OrdersDB;
import classes.PerformanceDB;
import classes.UsersDB;
import classes.VenuesDB;
import javabean.classes.Concert;
import javabean.classes.CreditCard;
import javabean.classes.Orders;
import javabean.classes.Performance;
import javabean.classes.ShoppingCart;
import javabean.classes.Users;
import javabean.classes.Venue;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String cardHolderName = request.getParameter("cardName");
		String cardNumber = request.getParameter("cardNumber");
		System.out.println("Card holder name " + cardHolderName);
		System.out.println("Card Number is " + cardNumber);
		ShoppingCart b = (ShoppingCart)sess.getAttribute("scBean");
		String bandName = b.getBandName();
		int qty = b.getTicketQuantity();
		int totalCost = b.getTotalPrice();
		System.out.println("band name is " + bandName);
		System.out.println("qty is " + qty);
		ConcertsDB cb = new ConcertsDB();
		Concert conc = cb.getDetails(bandName);
		PerformanceDB pdb = new PerformanceDB();
		Performance perf = pdb.fetchPerformanceInformation(conc.getId());
		VenuesDB vdb = new VenuesDB();
		Venue ven  = vdb.getVenueBuildingBasedOnConcert(conc.getId());
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM d", Locale.ENGLISH);
//		LocalDate localdate = LocalDate.parse(expDate, formatter);
//		Date date = Date.valueOf(localdate);
		String userName = (String) sess.getAttribute("user");
		System.out.println("The user name is :" + userName);
		UsersDB udb = new UsersDB();
		int userId = udb.getUserID(userName);
		Users u = udb.readUserDetails(userName);
		CreditCard cc = new CreditCard();
		cc.setCreditCardNumber(cardNumber);
		cc.setCardHolderName(cardHolderName);
		cc.setUserId(userId);
		CreditCardsDB cdb = new CreditCardsDB();
		boolean valid = cdb.validateCreditCard(cc);
		OrdersDB odb = new OrdersDB();
		Orders order = new Orders();
		double remainingBalance = cdb.getBalance(cardNumber);
		System.out.println("Balance : " + remainingBalance);
		if (valid == true && remainingBalance > 0) {
			odb.addOrder(u,cc,totalCost);
			order = odb.getOrderDetailsBasedOnCustomerId(u.getId());
			boolean success = odb.placeOrder(perf.getId(),qty,ven,order);
			if (success == true) {
				//odb.addOrder(order);
				PrintWriter out = response.getWriter(); 
				out.println(1);
			}
					}
		else{
			odb.removeOrderItems(perf);
			odb.removeOrder(order);
			PrintWriter out = response.getWriter(); 
			out.println("Not enough Balance");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
