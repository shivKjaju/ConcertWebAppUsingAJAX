package javabean.classes;

public class TicketType {
	public int idTicketTypes;
	public String seatName;
	public String ticketTypescol;
	
	public TicketType() {
		super();
	}
	
	public TicketType(int idTicketTypes, String seatName, String ticketTypescol) {
		super();
		this.idTicketTypes = idTicketTypes;
		this.seatName = seatName;
		this.ticketTypescol = ticketTypescol;
	}
	
	public int getIdTicketTypes() {
		return idTicketTypes;
	}
	public void setIdTicketTypes(int idTicketTypes) {
		this.idTicketTypes = idTicketTypes;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public String getTicketTypescol() {
		return ticketTypescol;
	}
	public void setTicketTypescol(String ticketTypescol) {
		this.ticketTypescol = ticketTypescol;
	}
	
	
}
