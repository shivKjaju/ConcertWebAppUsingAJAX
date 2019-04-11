package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.crypto.provider.RSACipher;

import classes.OrdersDB;
import classes.UsersDB;
import javabean.classes.Orders;
import javabean.classes.Users;

/**
 * Servlet implementation class ViewOrders
 */
@WebServlet("/ViewOrders")
public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("ViewOrder");
		System.out.println(username);
		UsersDB udb = new UsersDB();
		Users currUser = udb.readUserDetails(username);
		OrdersDB odb = new OrdersDB();
		ArrayList <Orders> order = odb.readExistingOrder(currUser.getId());
		HttpSession ss = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList <Orders> orders = (ArrayList<Orders>) ss.getAttribute("ViewOrder");
		if(orders == null) {
			ss.setAttribute("ViewOrder", order);
			RequestDispatcher rd = request.getRequestDispatcher("ViewOrders.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("ViewOrders.jsp");
			rd.forward(request, response);
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
