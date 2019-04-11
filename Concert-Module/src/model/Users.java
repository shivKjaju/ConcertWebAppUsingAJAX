package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;





public class Users {
	//This class will help in validating login and registration
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	//Register the user
	
public void registerUser(Users user, String propFilePath) {
		
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(user.getUserName(), user.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	//Validate the user
	
	public String validateUser(Users user, String propFilePath){
		Properties p = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			if(!p.containsKey(userName)){
				return "yes";
			}
			else{
				String pwd = p.getProperty(user.getUserName());
				if(!pwd.equals(password)) {
					return "yes";
				}
				else{
					return"no";
				}
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return "no";	
			
		
	}
	

}
