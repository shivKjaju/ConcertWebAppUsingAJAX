package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.CreditCardsDB;
import classes.OrdersDB;
import javabean.classes.OrderItems;
import javabean.classes.Orders;

/**
 * Servlet implementation class CancelOrderTransaction
 */
@WebServlet("/CancelOrderTransaction")
public class CancelOrderTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check to see if this is right or not
		String orderID = request.getParameter("OrderItemId");
		OrdersDB odb = new OrdersDB();
		OrderItems curr = odb.getCompleteOrderItemDetails(Integer.parseInt(orderID));
		int quantity = curr.getQuantity();
		int totalPrice =  quantity * Integer.parseInt(request.getParameter("TicketPrice"));
		CreditCardsDB cdb = new CreditCardsDB();
		double currBalance = cdb.getBalance(curr.getOrder().CreditCardNumber);
		double newBalance = ((double)totalPrice) + currBalance;
		cdb.setNewBalance(curr.getOrder().CreditCardNumber, newBalance);
		//Updates the seats
		odb.updateSeats(curr.getQuantity(), curr.getVen().name);
		HttpSession session = request.getSession();
		OrderItems newCurr = (OrderItems)session.getAttribute("cancelOrderTransaction");
		if (newCurr == null) {	
			newCurr = curr;
			session.setAttribute("cancelOrderTransaction", newCurr);
		}
		else {
			newCurr = curr;
		}
		RequestDispatcher rd = request.getRequestDispatcher("CancellationConfirmation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
