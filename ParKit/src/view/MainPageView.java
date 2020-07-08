package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;

public class MainPageView extends JFrame {

	private JPanel contentPane;
	private JTable tableParks;
	private JTextField textFieldParkId;
	private JTextField textFieldParkName;
	private JButton btnAddPark;
	private JButton btnMoveToPark;
	private JScrollPane scrollPane;
	private JTextField textFieldParkIdToMove;
	private JButton btnAdminLogIn;
	private JButton btnAddNewParkAdmin;
	private JTextField textFieldAdminId;
	private JLabel lblNewLabel_4;
	private JTextField textFieldParkToMoveName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPageView frame = new MainPageView();
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
	public MainPageView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To ParKit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(254, 11, 248, 67);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 119, 500, 256);
		contentPane.add(scrollPane);
		
		tableParks = new JTable();
		scrollPane.setViewportView(tableParks);
		
		JLabel lblNewLabel_1 = new JLabel("Choose park:");
		lblNewLabel_1.setBounds(101, 100, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		btnMoveToPark = new JButton("Move to selcted park");
		btnMoveToPark.setBounds(448, 387, 155, 23);
		contentPane.add(btnMoveToPark);
		
		textFieldParkId = new JTextField();
		textFieldParkId.setEditable(false);
		textFieldParkId.setEnabled(false);
		textFieldParkId.setBounds(615, 126, 96, 20);
		contentPane.add(textFieldParkId);
		textFieldParkId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Park id:");
		lblNewLabel_2.setBounds(616, 110, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldParkName = new JTextField();
		textFieldParkName.setEditable(false);
		textFieldParkName.setEnabled(false);
		textFieldParkName.setColumns(10);
		textFieldParkName.setBounds(615, 182, 96, 20);
		contentPane.add(textFieldParkName);
		
		JLabel lblNewLabel_2_1 = new JLabel("Park name:");
		lblNewLabel_2_1.setBounds(616, 166, 82, 14);
		contentPane.add(lblNewLabel_2_1);
		
		btnAddPark = new JButton("Add park");
		btnAddPark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddPark.setEnabled(false);
		btnAddPark.setBounds(615, 272, 96, 23);
		contentPane.add(btnAddPark);
		
		btnAdminLogIn = new JButton("Log in as ParKit admin");
		btnAdminLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdminLogIn.setBounds(544, 41, 167, 23);
		contentPane.add(btnAdminLogIn);
		
		textFieldParkIdToMove = new JTextField();
		textFieldParkIdToMove.setEditable(false);
		textFieldParkIdToMove.setBounds(148, 387, 96, 20);
		contentPane.add(textFieldParkIdToMove);
		textFieldParkIdToMove.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Park id:");
		lblNewLabel_3.setBounds(101, 390, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		btnAddNewParkAdmin = new JButton("Add new park admin");
		btnAddNewParkAdmin.setEnabled(false);
		btnAddNewParkAdmin.setBounds(544, 75, 167, 23);
		contentPane.add(btnAddNewParkAdmin);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Admin id:");
		lblNewLabel_2_1_1.setBounds(616, 214, 82, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		textFieldAdminId = new JTextField();
		textFieldAdminId.setEditable(false);
		textFieldAdminId.setEnabled(false);
		textFieldAdminId.setColumns(10);
		textFieldAdminId.setBounds(615, 230, 96, 20);
		contentPane.add(textFieldAdminId);
		
		lblNewLabel_4 = new JLabel("Park name:");
		lblNewLabel_4.setBounds(254, 389, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldParkToMoveName = new JTextField();
		textFieldParkToMoveName.setEditable(false);
		textFieldParkToMoveName.setColumns(10);
		textFieldParkToMoveName.setBounds(328, 388, 96, 20);
		contentPane.add(textFieldParkToMoveName);
		
		tableParks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int row = tableParks.getSelectedRow();
				String id=(tableParks.getModel().getValueAt(row, 0)).toString();
				textFieldParkIdToMove.setText(id);
				String name=(tableParks.getModel().getValueAt(row, 1)).toString();
				textFieldParkToMoveName.setText(name);
			}
		});
	}
	
	

	//methods:
	public void setActionListenerForBtns(ActionListener actionListener) {
		this.btnAddPark.addActionListener(actionListener);
		this.btnMoveToPark.addActionListener(actionListener);
		this.btnAdminLogIn.addActionListener(actionListener);
		this.btnAddNewParkAdmin.addActionListener(actionListener);
	}
	
	public void setFieldsEnabled() {
		this.btnAddPark.setEnabled(true);
		this.textFieldParkId.setEnabled(true);
		this.textFieldParkName.setEnabled(true);
		this.btnAddNewParkAdmin.setEnabled(true);
		this.textFieldAdminId.setEnabled(true);
		this.btnAdminLogIn.setEnabled(false);
		this.textFieldParkId.setEditable(true);
		this.textFieldParkName.setEditable(true);
		this.textFieldAdminId.setEditable(true);
	}
	
	public void setParkListToTable(ResultSet rs) {
		this.tableParks.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	//Massage Dialog:
	public void displayMessage(String Message){
		         
	    JOptionPane.showMessageDialog(this,Message);
		
    }
	
	//new admin pop-up:
	public HashMap<String, String> displayAddAdminDialog() {
		 
	    HashMap<String, String> logininformation = new HashMap<String, String>();

	    JPanel panel = new JPanel(new BorderLayout(5, 5));

	    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
	    label.add(new JLabel("Id", SwingConstants.RIGHT));
	    label.add(new JLabel("Password", SwingConstants.RIGHT));
	    panel.add(label, BorderLayout.WEST);

	    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
	    JTextField username = new JTextField();
	    controls.add(username);
	    JPasswordField password = new JPasswordField();
	    controls.add(password);
	    panel.add(controls, BorderLayout.CENTER);

	    JOptionPane.showMessageDialog(this, panel, "Add admin", JOptionPane.QUESTION_MESSAGE);

	    logininformation.put("id", username.getText());
	    logininformation.put("password", new String(password.getPassword()));
	    return logininformation;
}


	//get and set:
	
	public JButton getBtnAddPark() {
		return btnAddPark;
	}

	public JButton getBtnMoveToPark() {
		return btnMoveToPark;
	}

	public JButton getBtnAdminLogIn() {
		return btnAdminLogIn;
	}
	
	public JButton getBtnAddNewParkAdmin() {
		return btnAddNewParkAdmin;
	}
	
	public String getParkToMoveId() {
		return textFieldParkIdToMove.getText();
	}
	
	public String getParkToMoveName() {
		return textFieldParkToMoveName.getText();
	}
	
	public String getParkId() {
		return textFieldParkId.getText();
	}
	
	public String getParkName() {
		return textFieldParkName.getText();
	}
	
	public String getAdminId() {
		return textFieldAdminId.getText();
	}
}
