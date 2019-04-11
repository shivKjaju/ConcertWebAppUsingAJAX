package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.ConcertsDB;
import classes.OrdersDB;
import javabean.classes.Concert;
import javabean.classes.ShoppingCart;

/**
 * Servlet implementation class UpdateShoppingCart
 */
@WebServlet("/UpdateShoppingCart")
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		String bandName = request.getParameter("concertName");
		System.out.println("Band name is  :::::" + bandName);
		ConcertsDB cdb = new ConcertsDB();
		Concert conc = cdb.getDetails(bandName);
		int concertId = conc.getId();
		int ticketQuantity;
		if(request.getParameter("qty") == "" || request.getParameter("qty") == null ) {
			ticketQuantity = 0;
		}else {
			ticketQuantity = Integer.parseInt(request.getParameter("qty"));
		}
		System.out.println("Quantity is :::::" + ticketQuantity);
		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println("Price is :::::" + price);
		String venueName = request.getParameter("venueName");
		System.out.println("Venue is :::::" + venueName);
		int totalPrice = ticketQuantity * price;
		int totalSeats = Integer.parseInt(request.getParameter("availableSeats"));
		String delete = request.getParameter("delete");
		System.out.println("The delete value is "+ delete);
		String delete1 = request.getParameter("delete1");
		System.out.println("The delete1 value is "+ delete1);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
		OrdersDB odb = new OrdersDB();
		ShoppingCart scBean = new ShoppingCart();
		scBean.setConcertId(concertId);
		scBean.setBandName(bandName);
		scBean.setTicketQuantity(ticketQuantity);
		scBean.setVenueName(venueName);
		scBean.setTotalPrice(price);
		scBean.setAvailableSeats(totalSeats);
		scBean.setStatus(Integer.parseInt(delete));
		int updateTransaction = 0;
		//How do you delete the session
		if(Integer.parseInt(delete) == 1 && delete1 != null){
			scBean.setStatus(0);
			//Handle ticket updates : TODO
			sess.invalidate();
			System.out.println("ALways hist 2");
			int updatedSeats = totalSeats+ticketQuantity;
			if(odb.updateSeats(updatedSeats, venueName)){
				updateTransaction = 2;
				PrintWriter out = response.getWriter();
			    out.println(updateTransaction);
			}
		}
		else if(scBean != null && Integer.parseInt(delete) == 0 && delete1 == null){
			scBean.setStatus(1);
			sess.setAttribute("scBean", scBean);
			//Handle ticket updates : TODO
			System.out.println("ALways hist 1");
			int updatedSeats = totalSeats-ticketQuantity;
			if(odb.updateSeats(updatedSeats, venueName)){
				updateTransaction = 1;
				System.out.println("Updated seats");
				PrintWriter out = response.getWriter();
			    out.println(updateTransaction);
			}
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
