package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javabean.classes.Concert;
import javabean.classes.CustomerReviews;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.ConcertsDB;
import classes.ReviewDB;

/**
 * Servlet implementation class CustomerReview
 */
@WebServlet("/CustomerReview")
public class CustomerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String concertName = request.getParameter("bandName");
		String rating = request.getParameter("rating1");
		System.out.println("Rating : " + rating);
		String texterea = request.getParameter("textarea1");
		System.out.println("Texterea : " + texterea);
		ReviewDB rdb = new ReviewDB();
		ConcertsDB cdb = new ConcertsDB();
		Concert conc = cdb.getDetails(concertName);
		
		CustomerReviews cr = new CustomerReviews();
		cr.setRating(Integer.parseInt(rating));
		System.out.println("Rating : " + Integer.parseInt(rating));
		boolean valid = rdb.checkReviewContents(texterea);
		HttpSession sess = request.getSession();
		int added = 0;
		if(valid == true) {
			//TODO: get values from the CustomerReview JSp page
			cr.setConcertID(conc.getId());
			cr.setId(rdb.getLastID());
			cr.setRating(Integer.parseInt(rating));
			cr.setReview(texterea);
			cr.setReviewDate(null);
			cr.setUserID(2); // TODO: Add a user
			rdb.addNewReview(cr);
			String message = "Review Successfully added";
			sess.setAttribute("crBean", message);
			PrintWriter writer = response.getWriter();
			added = 1;
			writer.println(added);
		}
		else {
			String message = "Failed to add review due to Invalid texterea";
			sess.setAttribute("crBean", message);
			PrintWriter writer = response.getWriter();
			added = 0;
			writer.println(added);
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
