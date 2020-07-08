package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LogInPageModel;
import view.LogInPageView;


public class LogInPageController {
	
	private LogInPageView view;
	private LogInPageModel model;

	public LogInPageController(LogInPageView view, LogInPageModel model) {
		this.view = view;
		this.model = model;
		view.setActionListenerForBtns(new BtnListener());
	}
	
	public class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnBack()) {
				model.moveToMainPage();
				view.dispose();
			}
			
			else if(e.getSource() == view.getBtnLogIn()) {
				
				String id = view.getUserId();
				String password = view.getUserPassword();
				
				if(model.logIn(id, password)) {
					model.moveToMainPage();
					view.dispose();
					
				}else {
					view.displayMessage("Wrong username or password!");
				}
			}
			
					
		}
		
	}
	

}
