package model;

import database.Database;
import frame_controller.FrameController;
import utilities.Order;

public class GetTicketsPageModel {
	
	private Database db = Database.getInstance();
	private FrameController frameController = FrameController.getInstance();

	
	public void moveToParkPage() {
		frameController.moveToParkPage();
	}
	
	public String getLastOrderId() {
		return db.getLastOrderId();
	}
	
	public String getParkId() {
		return this.frameController.getParkId();
	}
	
	public void addOrder(Order order) {
		db.addOrder(order);
	}
	
}
