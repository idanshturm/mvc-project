package model;

import java.sql.ResultSet;

import database.Database;
import frame_controller.FrameController;
import utilities.Park;
import utilities.ParkAdmin;

public class MainPageModel {
	
	private Database db = Database.getInstance();
	private FrameController frameController = FrameController.getInstance();
	
	public void moveToLogInPage() {
		frameController.moveToLogInPage();	
	}
	
	public void moveToParkPage(String parkId, String parkName) {
		this.frameController.setParkId(parkId);
		this.frameController.setParkName(parkName);
		this.frameController.moveToParkPage();
	}

	public boolean isUserAdmin() {
		return this.frameController.isAdmin();
	}
	
	public boolean isAdminExist(String id) {
		return db.isAdminExist(id);
	}
	
	public ResultSet getParkList() {
		return db.getParkList();
	}
	
	public void addNewParkAdmin(ParkAdmin admin) {
		db.addParkAdmin(admin);
	}
	
	public String getAdminPassById(String id) {
		return db.getParkAdminPass(id);
	}
	
	public void addNewPark(Park park) {
		db.addPark(park);
	}
	
	public boolean isParkExist(String id) {
		return db.isParkExist(id);
	}
	
	

}
