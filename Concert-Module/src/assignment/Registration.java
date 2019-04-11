package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public long timeInit;
    public int count = 0;
    public String userName;
    public String emailid;
    public int visits = 0;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		//Reading the userName and password from the Registration.jsp page
		UsersDB udb = new UsersDB();
		int id = udb.getLastId();
		id++;
		count++;
		visits++;
		HttpSession session = request.getSession();
		
		 String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 emailid = request.getParameter("emailId");
		 String address = request.getParameter("address");
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 String pcode = request.getParameter("pCode");
		 String pnum = request.getParameter("pNumber");
		 String bday = request.getParameter("bDay");
		 int type = Integer.parseInt(request.getParameter("type"));
		 int status = Integer.parseInt(request.getParameter("status"));
		 userName = request.getParameter("userName");
		 String password = request.getParameter("password");
		 String hashedPassword = "";
		 UsersDB db = new UsersDB();
		 try {
			hashedPassword = db.hashPasswords(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		 Users aUser = new Users();
		 aUser.setId(id);
		 aUser.setFirstName(firstName);
		 aUser.setLastName(lastName);
		 aUser.setEmailAddress(emailid);
		 aUser.setAddress(address);
		 aUser.setCity(city);
		 aUser.setState(state);
		 aUser.setPostalCode(pcode);
		 aUser.setPhoneNumber(pnum);
		 aUser.setBirthday(bday);
		 aUser.setType(type);
		 aUser.setStatus(status);
		 aUser.setNumOfVisits(visits);
		 aUser.setUsername(userName);
		 aUser.setPassword(hashedPassword);
		 
		 if(db.checkUserExists(aUser)){
			 response.sendRedirect("Registration.jsp");
		 }
		 else{
		 db.addUser(aUser);
		 response.sendRedirect("Login.jsp");
		 }
		//To Obtain the absolute path from the relative path
		/*
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("WEB-INF/users.properties");
		
		//Use Users class to register the user and store the user in users.properties file
		
		Users user = new Users(userName, password);
		
		//Check if the user already exists
		
		String answer = user.validateUser(user, propFilePath);
		if(answer == "yes"){
			user.registerUser(user,propFilePath);
		}
		
		response.sendRedirect("Login.jsp");
		*/
	}
	
	
	public void destroy(){
		try {
			FileWriter fWriter = new FileWriter("lastRegistrationState.txt");
    		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 
    		Date date = new Date();
    		fWriter.write("\nTime " + dateFormat.format(date));
    		fWriter.write("\n Number of registers: " + count);
    		fWriter.write("\n User Name: " + userName);
    		fWriter.write("\n Email Id: " + emailid);
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