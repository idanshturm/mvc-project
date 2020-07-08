package model;

import database.Database;
import frame_controller.FrameController;

public class LogInPageModel {
	
	private Database db = Database.getInstance();
	private FrameController frameController = FrameController.getInstance();
	
	public void moveToMainPage() {
		frameController.moveToMainPage();
	}
	
	public boolean logIn(String id, String password) {
		if(db.isManager(id, password)) {
			frameController.setAdmin(true);
			return true;
		}else
			return false;
		
	}

}
