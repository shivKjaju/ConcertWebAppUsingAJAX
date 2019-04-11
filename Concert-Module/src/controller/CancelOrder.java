package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.OrdersDB;
import javabean.classes.OrderItems;
import javabean.classes.Orders;

/**
 * Servlet implementation class CancelOrder
 */
@WebServlet("/CancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderItemId = request.getParameter("orderItemId");
		OrdersDB odb = new OrdersDB();
		OrderItems item = odb.getCompleteOrderItemDetails(Integer.parseInt(orderItemId));
		System.out.println("Ticket Price : " + item.getTvp().getTicketPrice());
		HttpSession session = request.getSession();
		OrderItems newCurr = (OrderItems)session.getAttribute("cancelOrder");
		if (newCurr == null) {
			session.setAttribute("cancelOrder", item);
		}
		session.setAttribute("cancelOrder", item);
		RequestDispatcher rd = request.getRequestDispatcher("CancelOrder.jsp");
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
