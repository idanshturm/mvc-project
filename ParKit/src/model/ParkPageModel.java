package model;

import java.sql.ResultSet;
import java.util.HashMap;

import database.Database;
import frame_controller.FrameController;
import utilities.Attraction;

public class ParkPageModel {
	
	private Database db = Database.getInstance();
	private FrameController frameController = FrameController.getInstance();
	
	public void moveToMainPage() {
		frameController.moveToMainPage();	
	}

	public boolean isUserAdmin() {
		return this.frameController.isAdmin();
	}
	
	public boolean isUserParkAdmin(String id, String password) {
		return db.isParkAdmin(frameController.getParkId(), id, password);
	}
	
	public ResultSet getAttractionList() {
		return db.getAttractionsList(this.frameController.getParkId());
	}
	
	public ResultSet getAttractionsFiltered(HashMap<String, Boolean> tags) {
		return db.getAttractionsListFilterd(this.frameController.getParkId(), tags);
	}
	
	public void moveToGetTicketsPage() {
		frameController.moveToGetTicketsPage();
	}
	
	public void moveToViewTicketsPage() {
		frameController.moveToViewTicketsPage();
	}
	
	public void deleteAttraction(String id) {
		db.deleteAttraction(id, frameController.getParkId());
	}
	
	public void addAttraction(Attraction attraction) {
		db.addAttraction(attraction);
	}
	
	public boolean isAttractionExists(String id) {
		return db.isAttractionExist(id, frameController.getParkId());
	}
	
	public String getParkId() {
		return frameController.getParkId();
	}

}
