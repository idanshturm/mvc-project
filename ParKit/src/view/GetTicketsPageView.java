package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class GetTicketsPageView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRegularTicket;
	private JTextField textFieldKidTicket;
	private JTextField textFieldSoldierTicket;
	private JTextField textFieldSeniorTicket;
	private JButton btnPlaceOrder;
	private JTextField textFieldName;
	private JTextField textFieldPhoneNumber;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetTicketsPageView frame = new GetTicketsPageView();
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
	public GetTicketsPageView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGetTickets = new JLabel("Get Tickets");
		lblGetTickets.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblGetTickets.setBounds(287, 11, 189, 67);
		contentPane.add(lblGetTickets);
		
		textFieldRegularTicket = new JTextField();
		textFieldRegularTicket.setText("0");
		textFieldRegularTicket.setToolTipText("");
		textFieldRegularTicket.setBounds(376, 204, 96, 20);
		contentPane.add(textFieldRegularTicket);
		textFieldRegularTicket.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Regular ticket:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(248, 207, 118, 14);
		contentPane.add(lblNewLabel);
		
		textFieldKidTicket = new JTextField();
		textFieldKidTicket.setText("0");
		textFieldKidTicket.setColumns(10);
		textFieldKidTicket.setBounds(376, 235, 96, 20);
		contentPane.add(textFieldKidTicket);
		
		JLabel lblKidTicket = new JLabel("Kid ticket:");
		lblKidTicket.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKidTicket.setBounds(248, 238, 118, 14);
		contentPane.add(lblKidTicket);
		
		textFieldSoldierTicket = new JTextField();
		textFieldSoldierTicket.setText("0");
		textFieldSoldierTicket.setColumns(10);
		textFieldSoldierTicket.setBounds(376, 266, 96, 20);
		contentPane.add(textFieldSoldierTicket);
		
		JLabel lblSoldierTicket = new JLabel("Soldier ticket:");
		lblSoldierTicket.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoldierTicket.setBounds(248, 269, 118, 14);
		contentPane.add(lblSoldierTicket);
		
		JLabel lblSTicket = new JLabel("Senior ticket:");
		lblSTicket.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSTicket.setBounds(248, 300, 118, 14);
		contentPane.add(lblSTicket);
		
		textFieldSeniorTicket = new JTextField();
		textFieldSeniorTicket.setText("0");
		textFieldSeniorTicket.setColumns(10);
		textFieldSeniorTicket.setBounds(376, 297, 96, 20);
		contentPane.add(textFieldSeniorTicket);
		
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(316, 345, 118, 23);
		contentPane.add(btnPlaceOrder);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity:");
		lblNewLabel_1.setBounds(376, 176, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(301, 92, 133, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your name:");
		lblNewLabel_2.setBounds(301, 77, 123, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(301, 138, 133, 20);
		contentPane.add(textFieldPhoneNumber);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter your phone number:");
		lblNewLabel_2_1.setBounds(301, 123, 168, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("20$ per ticket");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(484, 207, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("15$ per ticket");
		lblNewLabel_3_1.setForeground(Color.GRAY);
		lblNewLabel_3_1.setBounds(484, 238, 89, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("10$ per ticket");
		lblNewLabel_3_2.setForeground(Color.GRAY);
		lblNewLabel_3_2.setBounds(484, 269, 89, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("10$ per ticket");
		lblNewLabel_3_3.setForeground(Color.GRAY);
		lblNewLabel_3_3.setBounds(484, 301, 89, 14);
		contentPane.add(lblNewLabel_3_3);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
	}
	
	//methods:
	public void setActionListenerForBtns(ActionListener actionListener) {
		this.btnBack.addActionListener(actionListener);
		this.btnPlaceOrder.addActionListener(actionListener);
	}
	
	
	//Massage Dialog:
	public void displayMessage(String Message){
		         
	    JOptionPane.showMessageDialog(this,Message);
		
	}
	
	
	
	//get and set:

	public String getTextFieldRegularTicket() {
		return textFieldRegularTicket.getText();
	}

	public String getTextFieldKidTicket() {
		return textFieldKidTicket.getText();
	}

	public String getTextFieldSoldierTicket() {
		return textFieldSoldierTicket.getText();
	}

	public String getTextFieldSeniorTicket() {
		return textFieldSeniorTicket.getText();
	}

	public JButton getBtnPlaceOrder() {
		return btnPlaceOrder;
	}
	
	public JButton getBtnBack() {
		return btnBack;
	}

	public String getTextFieldName() {
		return textFieldName.getText();
	}

	public String getTextFieldPhoneNumber() {
		return textFieldPhoneNumber.getText();
	}
	
	
	
	
	
	
}
