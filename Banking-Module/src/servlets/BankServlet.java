package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.BankDB;
import models.Bank;

/**
 * Servlet implementation class Bank
 */
@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Bank or Credit Card Details from Confirm Order jsp
		System.out.println("In Bank Servlet");
		String creditCardNumber = request.getParameter("cardNumber");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		//Get Balance from Bank DB
		BankDB bdb = new BankDB();
		Bank currUserDetails = bdb.getBalanceWithCreditCard(creditCardNumber);
		System.out.println(currUserDetails.getUser());
		System.out.println("CreditCard : " + currUserDetails.getCreditCard());
		int status = 0;
		System.out.println(currUserDetails.getBalance());
		System.out.println(totalPrice);
		HttpSession sess = request.getSession();
		if (currUserDetails.getBalance() >= totalPrice) {
			bdb.updateBalance(creditCardNumber, (currUserDetails.getBalance() - totalPrice));
			status = 1;
		}
		sess.setAttribute("bankBean", currUserDetails);
		//TODO: Return the status
		PrintWriter writer = response.getWriter();
		writer.println(status);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
