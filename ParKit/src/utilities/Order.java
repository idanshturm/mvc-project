package utilities;

public class Order {
	
	private String orderId;
	private String parkId;
	private String clientName;
	private String clientPhoneNumber;
	private int regularTicketAmount;
	private int kidTicketAmount;
	private int soldierTicketAmount;
	private int seniorTicketAmount;
	private int totalPrice;
	
	public Order(String orderId, String parkId,  String clientName, String clientPhoneNumber, int regularTicketAmount,
			int kidTicketAmount, int soldierTicketAmount, int seniorTicketAmount) {
		super();
		this.orderId = orderId;
		this.parkId = parkId;
		this.clientName = clientName;
		this.clientPhoneNumber = clientPhoneNumber;
		this.regularTicketAmount = regularTicketAmount;
		this.kidTicketAmount = kidTicketAmount;
		this.soldierTicketAmount = soldierTicketAmount;
		this.seniorTicketAmount = seniorTicketAmount;
		calcTotalPrice();
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getClientName() {
		return clientName;
	}
	public String getParkId() {
		return parkId;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}
	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}
	public int getRegularTicketAmount() {
		return regularTicketAmount;
	}
	public void setRegularTicketAmount(int regularTicketAmount) {
		this.regularTicketAmount = regularTicketAmount;
	}
	public int getKidTicketAmount() {
		return kidTicketAmount;
	}
	public void setKidTicketAmount(int kidTicketAmount) {
		this.kidTicketAmount = kidTicketAmount;
	}
	public int getSoldierTicketAmount() {
		return soldierTicketAmount;
	}
	public void setSoldierTicketAmount(int soldierTicketAmount) {
		this.soldierTicketAmount = soldierTicketAmount;
	}
	public int getSeniorTicketAmount() {
		return seniorTicketAmount;
	}
	public void setSeniorTicketAmount(int seniorTicketAmount) {
		this.seniorTicketAmount = seniorTicketAmount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void calcTotalPrice() {
		this.totalPrice = (this.kidTicketAmount * 15)+
				(this.regularTicketAmount * 20)+
				(this.seniorTicketAmount * 10)+
				(this.soldierTicketAmount * 10);
	}
}
