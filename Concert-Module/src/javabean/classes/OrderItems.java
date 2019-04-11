package javabean.classes;

public class OrderItems {
	private int id;
	private int orderId;
	private int performanceId;
	private int quantity;
	private Orders order = new Orders();
	private Concert conc = new Concert();
	private TicketType ticketType = new TicketType();
	private TicketVenuePrices tvp = new TicketVenuePrices();
	private Performance perf = new Performance();
	private Venue ven = new Venue();
	
	public OrderItems() {
		super();
	}

	public OrderItems(int id, int orderId, int performanceId, int quantity, Orders order, Concert conc,
			TicketType ticketType, TicketVenuePrices tvp, Performance perf, Venue ven) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.performanceId = performanceId;
		this.quantity = quantity;
		this.order = order;
		this.conc = conc;
		this.ticketType = ticketType;
		this.tvp = tvp;
		this.perf = perf;
		this.ven = ven;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(int performanceId) {
		this.performanceId = performanceId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Concert getConc() {
		return conc;
	}

	public void setConc(Concert conc) {
		this.conc = conc;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public TicketVenuePrices getTvp() {
		return tvp;
	}

	public void setTvp(TicketVenuePrices tvp) {
		this.tvp = tvp;
	}

	public Performance getPerf() {
		return perf;
	}

	public void setPerf(Performance perf) {
		this.perf = perf;
	}

	public Venue getVen() {
		return ven;
	}

	public void setVen(Venue ven) {
		this.ven = ven;
	}
	
	
	
}
