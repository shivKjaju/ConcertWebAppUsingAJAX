package javabean.classes;

public class Venue {
	public int id;
	public String name;
	public String address;
	public int ownerId;
	public String city;
	public int totalSeats;
	public int classOfSeats;
	public int typeOneSeats;
	public int typeTwoSeats;
	public String state;
	public String postalCode;
	
	public Venue() {
		super();
	}
	
	public Venue(int id, String name, String address, int ownerId, String city, int totalSeats, int classOfSeats,
			int typeOneSeats, int typeTwoSeats, String state, String postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.ownerId = ownerId;
		this.city = city;
		this.totalSeats = totalSeats;
		this.classOfSeats = classOfSeats;
		this.typeOneSeats = typeOneSeats;
		this.typeTwoSeats = typeTwoSeats;
		this.state = state;
		this.postalCode = postalCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getClassOfSeats() {
		return classOfSeats;
	}

	public void setClassOfSeats(int classOfSeats) {
		this.classOfSeats = classOfSeats;
	}

	public int getTypeOneSeats() {
		return typeOneSeats;
	}

	public void setTypeOneSeats(int typeOneSeats) {
		this.typeOneSeats = typeOneSeats;
	}

	public int getTypeTwoSeats() {
		return typeTwoSeats;
	}

	public void setTypeTwoSeats(int typeTwoSeats) {
		this.typeTwoSeats = typeTwoSeats;
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
	
	
	
	
}
