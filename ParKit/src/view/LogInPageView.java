package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogInPageView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserId;
	private JButton btnLogIn;
	private JButton btnBack;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPageView frame = new LogInPageView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInPageView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(323, 34, 99, 56);
		contentPane.add(lblNewLabel);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setBounds(302, 172, 134, 20);
		contentPane.add(textFieldUserId);
		textFieldUserId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User id:");
		lblNewLabel_1.setBounds(302, 157, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Password:");
		lblNewLabel_1_1.setBounds(302, 216, 99, 14);
		contentPane.add(lblNewLabel_1_1);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogIn.setBounds(323, 296, 89, 23);
		contentPane.add(btnLogIn);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(302, 241, 134, 20);
		contentPane.add(passwordField);
	}
	
	
	//methods:
	public void setActionListenerForBtns(ActionListener actionListener) {
		this.btnLogIn.addActionListener(actionListener);
		this.btnBack.addActionListener(actionListener);
	}


	
	//get and set:
	
	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public JButton getBtnBack() {
		return btnBack;
	}
	
	public String getUserId() {
		return this.textFieldUserId.getText();
	}
	
	public String getUserPassword() {
		
		char [] pass = passwordField.getPassword();
		
		StringBuilder sb = new StringBuilder();
		for (Character ch: pass) {
			sb.append(ch);
		}

		String string = sb.toString();
		
		return string;
	}
	
	
	//Massage Dialog:
	public void displayMessage(String Message){
		         
	    JOptionPane.showMessageDialog(this,Message);
		
		    }
}
