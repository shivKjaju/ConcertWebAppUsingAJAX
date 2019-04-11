package javabean.classes;

public class Users {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String postalCode;
	private String emailAddress;
	private String phoneNumber;
	private String birthday;
	private int type;
	private int status;
	private int numOfVisits;
	private String username;
	private String password;
	
	public Users() {
		super();
	}

	public Users(int id, String firstName, String lastName, String address, String city, String state,
			String postalCode, String emailAddress, String phoneNumber, String birthday, int type, int status,
			int numOfVisits, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.type = type;
		this.status = status;
		this.numOfVisits = numOfVisits;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNumOfVisits() {
		return numOfVisits;
	}

	public void setNumOfVisits(int numOfVisits) {
		this.numOfVisits = numOfVisits;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
