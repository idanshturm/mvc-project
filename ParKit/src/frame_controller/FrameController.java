package frame_controller;

import controller.GetTicketsPageController;
import controller.LogInPageController;
import controller.MainPageController;
import controller.ParkPageController;
import controller.ViewTicketsPageController;
import model.GetTicketsPageModel;
import model.LogInPageModel;
import model.MainPageModel;
import model.ParkPageModel;
import model.ViewTicketsPageModel;
import view.GetTicketsPageView;
import view.LogInPageView;
import view.MainPageView;
import view.ParkPageView;
import view.ViewTicketsPageView;

public class FrameController {
	private static FrameController fc = null;
	private boolean admin = false;
	private String parkId = "";
	private String parkName = "";
	private String attractionId = "";
	
	private FrameController() {}
	
	public static FrameController getInstance() {
		if (fc == null)
			fc = new FrameController();
		return fc;
	
	}
	
	//get and set:
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(String attractionId) {
		this.attractionId = attractionId;
	}
	
	//moving between pages:
	
	public void moveToMainPage() {
	    MainPageView mainPageView = new MainPageView();
	    MainPageModel mainPageModel = new MainPageModel();
	    mainPageView.setVisible(true);
	    @SuppressWarnings("unused")
		MainPageController mainPageController = new MainPageController(mainPageView, mainPageModel);
	}

	public void moveToLogInPage() {
	    LogInPageView logInPageView = new LogInPageView();
	    LogInPageModel logInPageModel = new LogInPageModel();
	    logInPageView.setVisible(true);
	    @SuppressWarnings("unused")
		LogInPageController logInPageController = new LogInPageController(logInPageView, logInPageModel);
	}
	
	public void moveToParkPage() {
		ParkPageView parkPageView = new ParkPageView();
		parkPageView.setParkName(this.parkName);
		ParkPageModel parkPageModel = new ParkPageModel();
		parkPageView.setVisible(true);
		@SuppressWarnings("unused")
		ParkPageController parkPageController = new ParkPageController(parkPageView, parkPageModel);
	}
	
	public void moveToGetTicketsPage() {
		GetTicketsPageView getTicketsPageView = new GetTicketsPageView();
		GetTicketsPageModel getTicketsPageModel = new GetTicketsPageModel();
		getTicketsPageView.setVisible(true);
		@SuppressWarnings("unused")
		GetTicketsPageController getTicketsPageController = new GetTicketsPageController(getTicketsPageView, getTicketsPageModel);
	}
	
	public void moveToViewTicketsPage() {
		ViewTicketsPageView viewTicketsPageView = new ViewTicketsPageView();
		ViewTicketsPageModel viewTicketsPageModel = new ViewTicketsPageModel();
		viewTicketsPageView.setVisible(true);
		@SuppressWarnings("unused")
		ViewTicketsPageController viewTicketsPageController = new ViewTicketsPageController(viewTicketsPageView, viewTicketsPageModel);
	}
	
}
