package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ViewTicketsPageModel;
import view.ViewTicketsPageView;

public class ViewTicketsPageController {
	
	private ViewTicketsPageView view;
	private ViewTicketsPageModel model;


	public ViewTicketsPageController(ViewTicketsPageView view, ViewTicketsPageModel model) {
		this.view = view;
		this.model = model;
		view.setActionListenerForBtns(new BtnListener());
		view.setAttractionListToTable(model.getOrdersList());
	}

	
	
	public class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			model.moveToParkPage();
			view.dispose();
			
		}
	}


}
