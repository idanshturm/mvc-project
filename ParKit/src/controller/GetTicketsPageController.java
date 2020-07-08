package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GetTicketsPageModel;
import utilities.Order;
import view.GetTicketsPageView;


public class GetTicketsPageController {
	
	private GetTicketsPageView view;
	private GetTicketsPageModel model;

	public GetTicketsPageController(GetTicketsPageView view, GetTicketsPageModel model) {
		this.view = view;
		this.model = model;
		view.setActionListenerForBtns(new BtnListener());
	}

	public class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnBack()) {
				model.moveToParkPage();
				view.dispose();
			}
			
			else if(e.getSource() == view.getBtnPlaceOrder()) {
				
				String clientName = view.getTextFieldName();
				String clientNumber = view.getTextFieldPhoneNumber();
				
				String regularTicAmont = view.getTextFieldRegularTicket();
				String kidTicAmont = view.getTextFieldKidTicket();
				String soldierTicAmont = view.getTextFieldSoldierTicket();
				String seniorTicAmont = view.getTextFieldSeniorTicket();
				
				if(clientName.equals("") || clientNumber.equals("") || regularTicAmont.equals("") || kidTicAmont.equals("") || soldierTicAmont.equals("")|| seniorTicAmont.equals("") ) {
					view.displayMessage("Fields can not be empty!!");
					return;
				}
				else if(!(clientNumber.matches("[0-9]+")) || !(regularTicAmont.matches("[0-9]+")) || !(kidTicAmont.matches("[0-9]+")) || !(soldierTicAmont.matches("[0-9]+")) || !(seniorTicAmont.matches("[0-9]+"))) {
					view.displayMessage("Phone number and quantity can only contain numbers!");
					return;
				}else {
					
					String orderId = model.getLastOrderId();
					String parkId = model.getParkId();
					
					int regularTicAmontNum = Integer.parseInt(regularTicAmont);
					int kidTicAmontNum = Integer.parseInt(kidTicAmont);
					int soldierTicAmountNum = Integer.parseInt(soldierTicAmont);
					int seniorTicAmontNum = Integer.parseInt(seniorTicAmont);
					
					Order order = new Order(orderId, parkId, clientName, clientNumber,regularTicAmontNum, kidTicAmontNum, soldierTicAmountNum, seniorTicAmontNum);
					model.addOrder(order);
					view.displayMessage("Order has been placed!\nOrder id: " + order.getOrderId() + "\nTotal price: " + order.getTotalPrice() + "$");
					model.moveToParkPage();
					view.dispose();
				}
			}
		}
	}
}
