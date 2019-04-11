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
 * Servlet implementation class ManageOrder
 */
@WebServlet("/ManageOrder")
public class ManageOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderNum = request.getParameter("orderId");
		OrdersDB oDB = new OrdersDB();
		Orders order = oDB.getOrderDetails(Integer.parseInt(orderNum));
		int itemID = oDB.getItemID(Integer.parseInt(orderNum));
		System.out.println("Item Id ; " + itemID);
		OrderItems item = oDB.getCompleteOrderItemDetails(itemID);
		System.out.println("Item : " + item.getId());
		HttpSession sess = request.getSession();
		OrderItems newOrder = (OrderItems) sess.getAttribute("manageOrder");
		if (newOrder == null) {
			sess.setAttribute("manageOrder", item);
		}
		sess.setAttribute("manageOrder", item);
		response.sendRedirect("ManageOrder.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
