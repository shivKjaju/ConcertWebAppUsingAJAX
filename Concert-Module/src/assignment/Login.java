package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.UsersDB;
import javabean.classes.Users;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public long timeInit;
    public int count = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(){
    	timeInit = System.currentTimeMillis();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Reading the userName and Password from the HTML form (Login.jsp)
		count++;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UsersDB udb = new UsersDB();
		String hashPassword = "";
		try {
			hashPassword = udb.hashPasswords(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The hash password is:" + hashPassword);
		String referer = request.getHeader("referer");
		Users user = new Users();
		user.setUsername(userName);
		user.setPassword(hashPassword);
		HttpSession sess = request.getSession();
		if(sess != null){
		sess.setAttribute("userBean", user);
		}
		
		
		/*To obtain the absolute path of the users.properties file
		 from its relative path.
		*/
		
		//Validate the user using the validate method in Users class
		String validation = udb.getPassword(userName);
		
		if(udb.checkUserNameExists(request.getParameter("userName")) == true && validation.equals(hashPassword)) {
			RequestDispatcher rd = request.getRequestDispatcher("CustomerHomePage.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("Registration.jsp");
		}
	}
	
	public long getLastModified(HttpServletRequest request){
		return timeInit;
	}
	
	public void destroy(){
		try {
			FileWriter fWriter = new FileWriter("lastLoginState.txt");
    		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 
    		Date date = new Date();
    		fWriter.write("\nTime " + dateFormat.format(date));
    		fWriter.write("\n Number of users: " + count);
    		fWriter.close();
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
