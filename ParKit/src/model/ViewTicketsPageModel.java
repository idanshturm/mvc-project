package model;

import java.sql.ResultSet;

import database.Database;
import frame_controller.FrameController;

public class ViewTicketsPageModel {
	
	private Database db = Database.getInstance();
	private FrameController frameController = FrameController.getInstance();
	
	public ResultSet getOrdersList() {
		return db.getOrdersList(frameController.getParkId());
	}
	
	public void moveToParkPage() {
		frameController.moveToParkPage();
	}
	
	
}
