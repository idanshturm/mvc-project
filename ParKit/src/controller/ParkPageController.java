package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import model.ParkPageModel;
import utilities.Attraction;
import view.ParkPageView;

public class ParkPageController {
	
	private ParkPageView view;
	private ParkPageModel model;
	
	//global vars:
	
	private String id;
	private String name;
	private String description;
	private boolean isAvailable;
	private boolean scary;
	private boolean water;
	private boolean kids;
	private boolean heights;
	private boolean rollerCoaster;


	public ParkPageController(ParkPageView view, ParkPageModel model) {
		this.view = view;
		this.model = model;
		view.setActionListenerForBtns(new BtnListener());
		if(model.isUserAdmin()) {
			view.setFieldsEnabled();
		}
		view.setAttractionListToTable(model.getAttractionList());
	}

	
	
	
	public class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnBack()) {
				model.moveToMainPage();
				view.dispose();
			}
			
			else if(e.getSource() == view.getBtnFilter()) {
				
				HashMap<String, Boolean> tags = new HashMap<String, Boolean>();
				
				if(view.isScary())
					tags.put("scary", view.isScary());
				if(view.isWater())
					tags.put("water", view.isWater());
				if(view.isKids())
					tags.put("kids", view.isKids());
				if(view.isHeights())
					tags.put("heights", view.isHeights());
				if(view.isRollerCoaster())
					tags.put("roller_coaster", view.isRollerCoaster());
				
				view.setAttractionListToTable(model.getAttractionsFiltered(tags));
			}
			
			else if(e.getSource() == view.getBtnGetPermission()) {
				HashMap<String, String> map = view.displayLogInDialog();
				if(model.isUserParkAdmin(map.get("user"), map.get("pass"))) {
					view.setFieldsEnabled();
				}else
					view.displayMessage("Wrong username or password!");
			}
			
			else if(e.getSource() == view.getBtnGetTickets()) {
				model.moveToGetTicketsPage();
				view.dispose();
			}
			
			else if(e.getSource() == view.getBtnAdd()) {
				if(!getFieldsAndValidate())
					return;
				if(model.isAttractionExists(id)) {
					view.displayMessage("Attraction id is already taken! choose a different id.");
				}else {
					
					String parkId = model.getParkId();
					Attraction attraction = new Attraction(id, parkId, name, description, isAvailable, scary, water, kids, heights, rollerCoaster);
					model.addAttraction(attraction);
					view.displayMessage("Attraction has been added");
					view.setAttractionListToTable(model.getAttractionList());
					view.clearFields();
				}
			}
			
			else if(e.getSource() == view.getBtnUpdate()) {
				if(!getFieldsAndValidate())
					return;
				if(!model.isAttractionExists(id)) {
					view.displayMessage("Attraction id not found!");
				}else {
					
					String parkId = model.getParkId();
					Attraction attraction = new Attraction(id, parkId, name, description, isAvailable, scary, water, kids, heights, rollerCoaster);
					model.deleteAttraction(id);
					model.addAttraction(attraction);
					view.displayMessage("Attraction has been updated");
					view.setAttractionListToTable(model.getAttractionList());
					view.clearFields();
				}
			}
			
			else if(e.getSource() == view.getBtnDelete()) {
				String attId = view.getTextFieldId();
				if(!model.isAttractionExists(attId)) {
					view.displayMessage("Attraction id not found!");
				}else {
					model.deleteAttraction(attId);
					view.displayMessage("Attraction has been deleted!");
					view.setAttractionListToTable(model.getAttractionList());
					view.clearFields();
				}
			}
			
			else if(e.getSource() == view.getBtnSeeTickets()) {
				model.moveToViewTicketsPage();
				view.dispose();
			}
		}

	}
	
	private boolean getFieldsAndValidate() {
		
		this.id = view.getTextFieldId();
		this.name = view.getTextFieldName();
		this.description = view.getTextFieldDiscription();
		this.isAvailable = view.isAvailable();
		this.scary = view.isScaryAdmin();
		this.kids = view.isKidsAdmin();
		this.water = view.isWaterAdmin();
		this.heights = view.isHeightsAdmin();
		this.rollerCoaster = view.isRollerCoasterAdmin();
		
		if(id.equals("") || name.equals("") || description.equals("")) {
			view.displayMessage("Fields can not be empty!");
			return false;
		}else if(!(id.matches("[0-9]+"))) {
			view.displayMessage("Id can only contain numbers!");
			return false;
		}else return true;
	}
}
