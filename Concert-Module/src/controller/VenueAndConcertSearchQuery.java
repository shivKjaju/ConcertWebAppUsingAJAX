package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javabean.classes.Concert;
import javabean.classes.Performance;
import javabean.classes.SearchResults;
import javabean.classes.Venue;
import javabean.classes.VenueAndSearchQuery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.ConcertsDB;
import classes.PerformanceDB;
import classes.VenuesDB;

/**
 * Servlet implementation class VenueAndConcertSearchQuery
 */
@WebServlet("/VenueAndConcertSearchQuery")
public class VenueAndConcertSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenueAndConcertSearchQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = request.getParameter("query");

		System.out.println("HIT1");
		System.out.println(query);
		HttpSession sess = request.getSession();
		PerformanceDB pdb = new PerformanceDB();
		ArrayList<Performance> perf = pdb.getDetailsOfPerformance(query);
		sess.setAttribute("SearchResultList", perf);
	  response.sendRedirect("ConcertSearchResults.jsp");	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
