package controller;

import java.io.IOException;

import javabean.classes.Concert;
import javabean.classes.ConcertSearchResultsBean;
import javabean.classes.CustomerReviews;
import javabean.classes.Venue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.ConcertsDB;
import classes.ReviewDB;
import classes.UsersDB;
import classes.VenuesDB;

/**
 * Servlet implementation class ConcertSearchResults
 */
@WebServlet("/ConcertSearchResults")
public class ConcertSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcertSearchResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("concertname");
		ConcertsDB cdb = new ConcertsDB();
		Concert conc = cdb.getDetails(name);
		VenuesDB vdb = new VenuesDB();
		Venue ven = vdb.getVenueBuildingBasedOnConcert(conc.getId());
		UsersDB udb = new UsersDB();
	    int price = udb.getTicketPrice(ven.getId());
	    int ticketID = udb.getTicketTypeId(ven.getId());
	    String ticketType = udb.getTicketType(ticketID, price);
	    String seatType = udb.getSeatType(ticketID, price);
		int totalSeat = vdb.getTotalSeats(conc.getId());
		System.out.println("Total seats" + totalSeat);
		HttpSession sess = request.getSession();
		ReviewDB rdb = new ReviewDB();
		CustomerReviews cus = rdb.fetchReviewInformation(conc.getId());
		ConcertSearchResultsBean concBean = new ConcertSearchResultsBean();
		concBean.setBandName(conc.getMovieName());
		concBean.setAvailableSeats(totalSeat);
		concBean.setDesc(conc.getDescription());
		concBean.setReview(cus.getReview());
		concBean.setRating(cus.getRating());
		concBean.setVenueName(ven.getName());
		concBean.setTypeOfSeats(seatType);
		concBean.setPrice(price);
		
		if(concBean != null){
		sess.setAttribute("csrBean", concBean);
		}
		RequestDispatcher rd = request.getRequestDispatcher("ConcertDetailsSelection.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}