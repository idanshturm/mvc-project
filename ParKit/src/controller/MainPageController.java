package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import model.MainPageModel;
import utilities.Park;
import utilities.ParkAdmin;
import view.MainPageView;

public class MainPageController {
	
	private MainPageView view;
	private MainPageModel model;

	public MainPageController(MainPageView view, MainPageModel model) {
		this.view = view;
		this.model = model;
		view.setActionListenerForBtns(new BtnListener());
		if(model.isUserAdmin()) {
			view.setFieldsEnabled();
		}
		view.setParkListToTable(model.getParkList());
	}
	
	public class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnAddPark()) {
				
				String adminId = view.getAdminId();
				String parkId = view.getParkId();
				String parkName = view.getParkName();
				
				
				if(adminId.equals("") || adminId.equals("") || parkName.equals("")) {
					view.displayMessage("Fields can not be empty!!");
					return;
				}
				else if(!(adminId.matches("[0-9]+")) || !(parkId.matches("[0-9]+"))) {
					view.displayMessage("Id can only contain numbers!");
					return;
				}else if(!model.isAdminExist(adminId)) {
					view.displayMessage("Admin does not exist, please add new admin first.");
					return;
				}else if(model.isParkExist(parkId)) {
					view.displayMessage("Park id aready in use! choose different id.");
					return;
				}else{
	
					String adminPass = model.getAdminPassById(adminId);
					
					Park park = new Park(parkId, parkName, adminId, adminPass);
					
					model.addNewPark(park);
					view.displayMessage("Park has been added!");
					view.setParkListToTable(model.getParkList());
				}
				
			}
			
			else if(e.getSource() == view.getBtnMoveToPark()) {
				String parkId = view.getParkToMoveId();
				String parkName = view.getParkToMoveName();
				
				if(parkId.equals("")) {
					view.displayMessage("Please select a park first");
					return;
				}
				model.moveToParkPage(parkId, parkName);
				view.dispose();
			}
			
			else if(e.getSource() == view.getBtnAdminLogIn()) {
				model.moveToLogInPage();
				view.dispose();
			}
			
			else if(e.getSource() == view.getBtnAddNewParkAdmin()) {
				HashMap<String, String> map = view.displayAddAdminDialog();
				if(model.isAdminExist(map.get("id"))) {
					view.displayMessage("Admin already exists! please choose another id.");
					return;
				}else if(!(map.get("id").matches("[0-9]+"))) {
					view.displayMessage("Id can only contain numbers!");
					return;
				}else {
					ParkAdmin admin = new ParkAdmin();
					admin.setId(map.get("id"));
					admin.setPassword(map.get("password"));
					model.addNewParkAdmin(admin);
					view.displayMessage("Park admin has been adeed!");
				}
				
				
			}
			
		}
		
	}
	
}
