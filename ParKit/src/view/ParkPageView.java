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
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class ParkPageView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JButton btnFilter;
	private JButton btnGetPermission;
	private JButton btnGetTickets;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextArea textFieldDiscription;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblDescription;
	private JLabel lblTags;
	private JCheckBox chckbxIsAvailable;
	private JCheckBox chckbxScaryAdmin;
	private JCheckBox chckbxKidsAdmin;
	private JCheckBox chckbxRollerCoasterAdmin;
	private JCheckBox chckbxWaterAdmin;
	private JCheckBox chckbxHeightsAdmin;
	private JLabel lblParkName;
	private JCheckBox chckbxRollerCoaster;
	private JCheckBox chckbxKids;
	private JCheckBox chckbxScary;
	private JCheckBox chckbxWater;
	private JCheckBox chckbxHeights;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSeeTickets;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkPageView frame = new ParkPageView();
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
	public ParkPageView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblParkName = new JLabel("Some Park");
		lblParkName.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblParkName.setBounds(273, 11, 260, 67);
		contentPane.add(lblParkName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 89, 491, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		btnGetTickets = new JButton("Get tickets");
		btnGetTickets.setBounds(10, 41, 107, 23);
		contentPane.add(btnGetTickets);
		
		lblNewLabel = new JLabel("Filter attractions by tag:");
		lblNewLabel.setBounds(24, 350, 166, 14);
		contentPane.add(lblNewLabel);
		
		chckbxScary = new JCheckBox("Scary");
		chckbxScary.setBounds(20, 371, 71, 23);
		contentPane.add(chckbxScary);
		
		chckbxWater = new JCheckBox("Water");
		chckbxWater.setBounds(20, 390, 67, 23);
		contentPane.add(chckbxWater);
		
		chckbxKids = new JCheckBox("Kids");
		chckbxKids.setBounds(90, 370, 59, 23);
		contentPane.add(chckbxKids);
		
		chckbxHeights = new JCheckBox("Heights");
		chckbxHeights.setBounds(89, 390, 71, 23);
		contentPane.add(chckbxHeights);
		
		chckbxRollerCoaster = new JCheckBox("Roller coaster");
		chckbxRollerCoaster.setBounds(151, 370, 109, 23);
		contentPane.add(chckbxRollerCoaster);
		
		btnFilter = new JButton("Filter");
		btnFilter.setBounds(161, 400, 89, 23);
		contentPane.add(btnFilter);
		
		JLabel lblNewLabel_1 = new JLabel("Attractions:");
		lblNewLabel_1.setBounds(30, 75, 87, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Admin options)");
		lblNewLabel_2.setBounds(595, 11, 107, 14);
		contentPane.add(lblNewLabel_2);
		
		btnGetPermission = new JButton("Get permission");
		btnGetPermission.setBounds(573, 36, 125, 23);
		contentPane.add(btnGetPermission);
		
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setColumns(10);
		textFieldId.setBounds(573, 86, 96, 20);
		contentPane.add(textFieldId);
		
		textFieldName = new JTextField();
		textFieldName.setEnabled(false);
		textFieldName.setColumns(10);
		textFieldName.setBounds(573, 131, 96, 20);
		contentPane.add(textFieldName);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(573, 177, 125, 50);
		contentPane.add(scrollPane_1);
		
		textFieldDiscription = new JTextArea();
		scrollPane_1.setViewportView(textFieldDiscription);
		textFieldDiscription.setEnabled(false);
		
		chckbxScaryAdmin = new JCheckBox("Scary");
		chckbxScaryAdmin.setEnabled(false);
		chckbxScaryAdmin.setBounds(574, 279, 59, 23);
		contentPane.add(chckbxScaryAdmin);
		
		chckbxWaterAdmin = new JCheckBox("Water");
		chckbxWaterAdmin.setEnabled(false);
		chckbxWaterAdmin.setBounds(631, 279, 67, 23);
		contentPane.add(chckbxWaterAdmin);
		
		chckbxHeightsAdmin = new JCheckBox("Heights");
		chckbxHeightsAdmin.setEnabled(false);
		chckbxHeightsAdmin.setBounds(631, 305, 71, 23);
		contentPane.add(chckbxHeightsAdmin);
		
		chckbxKidsAdmin = new JCheckBox("Kids");
		chckbxKidsAdmin.setEnabled(false);
		chckbxKidsAdmin.setBounds(573, 305, 59, 23);
		contentPane.add(chckbxKidsAdmin);
		
		chckbxRollerCoasterAdmin = new JCheckBox("Roller coaster");
		chckbxRollerCoasterAdmin.setEnabled(false);
		chckbxRollerCoasterAdmin.setBounds(573, 326, 109, 23);
		contentPane.add(chckbxRollerCoasterAdmin);
		
		chckbxIsAvailable = new JCheckBox("Is available");
		chckbxIsAvailable.setEnabled(false);
		chckbxIsAvailable.setBounds(572, 234, 97, 23);
		contentPane.add(chckbxIsAvailable);
		
		lblTags = new JLabel("tags:");
		lblTags.setEnabled(false);
		lblTags.setBounds(574, 264, 48, 14);
		contentPane.add(lblTags);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setEnabled(false);
		lblDescription.setBounds(573, 162, 71, 14);
		contentPane.add(lblDescription);
		
		lblName = new JLabel("Name:");
		lblName.setEnabled(false);
		lblName.setBounds(573, 117, 48, 14);
		contentPane.add(lblName);
		
		lblId = new JLabel("Id:");
		lblId.setEnabled(false);
		lblId.setBounds(573, 70, 48, 14);
		contentPane.add(lblId);
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.setBounds(523, 357, 89, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(622, 357, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(580, 390, 89, 23);
		contentPane.add(btnDelete);
		
		btnSeeTickets = new JButton("See tickets orders");
		btnSeeTickets.setEnabled(false);
		btnSeeTickets.setBounds(320, 400, 152, 23);
		contentPane.add(btnSeeTickets);
		
		JLabel lblNewLabel_3 = new JLabel("(Admin only)");
		lblNewLabel_3.setBounds(364, 375, 75, 14);
		contentPane.add(lblNewLabel_3);
	}
	
	//methods:
		public void setActionListenerForBtns(ActionListener actionListener) {
			this.btnBack.addActionListener(actionListener);
			this.btnFilter.addActionListener(actionListener);
			this.btnGetPermission.addActionListener(actionListener);
			this.btnGetTickets.addActionListener(actionListener);
			this.btnAdd.addActionListener(actionListener);
			this.btnUpdate.addActionListener(actionListener);
			this.btnDelete.addActionListener(actionListener);
			this.btnSeeTickets.addActionListener(actionListener);
		}
		
		public void setFieldsEnabled() {
			this.lblDescription.setEnabled(true);
			this.lblId.setEnabled(true);
			this.lblName.setEnabled(true);
			this.lblTags.setEnabled(true);
			this.textFieldDiscription.setEnabled(true);
			this.textFieldId.setEnabled(true);
			this.textFieldName.setEnabled(true);
			this.btnGetPermission.setEnabled(false);
			this.chckbxHeightsAdmin.setEnabled(true);
			this.chckbxKidsAdmin.setEnabled(true);
			this.chckbxIsAvailable.setEnabled(true);
			this.chckbxRollerCoasterAdmin.setEnabled(true);
			this.chckbxScaryAdmin.setEnabled(true);
			this.chckbxWaterAdmin.setEnabled(true);
			this.btnAdd.setEnabled(true);
			this.btnUpdate.setEnabled(true);
			this.btnDelete.setEnabled(true);
			this.btnSeeTickets.setEnabled(true);
		}
		
		public HashMap<String, String> displayLogInDialog() {
			 
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

			    JOptionPane.showMessageDialog(this, panel, "login", JOptionPane.QUESTION_MESSAGE);

			    logininformation.put("user", username.getText());
			    logininformation.put("pass", new String(password.getPassword()));
			    return logininformation;
		}
		
		public void clearFields() {
			this.textFieldDiscription.setText("");
			this.textFieldId.setText("");
			this.textFieldName.setText("");
			this.chckbxHeightsAdmin.setSelected(false);
			this.chckbxKidsAdmin.setSelected(false);
			this.chckbxIsAvailable.setSelected(false);
			this.chckbxRollerCoasterAdmin.setSelected(false);
			this.chckbxScaryAdmin.setSelected(false);
			this.chckbxWaterAdmin.setSelected(false);
		}
		
		
		
		public void setAttractionListToTable(ResultSet rs) {
			this.table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		//Massage Dialog:
		public void displayMessage(String Message){
			         
		    JOptionPane.showMessageDialog(this,Message);
			
		}
		
		
		//get and set:

		public JButton getBtnBack() {
			return btnBack;
		}

		public JButton getBtnFilter() {
			return btnFilter;
		}

		public JButton getBtnGetPermission() {
			return btnGetPermission;
		}

		public JButton getBtnGetTickets() {
			return btnGetTickets;
		}
		
		public void setParkName(String parkName) {
			this.lblParkName.setText(parkName);
		}

		public JButton getBtnAdd() {
			return btnAdd;
		}

		public JButton getBtnUpdate() {
			return btnUpdate;
		}

		public JButton getBtnDelete() {
			return btnDelete;
		}
		
		public JButton getBtnSeeTickets() {
			return btnSeeTickets;
		}
		
		public boolean isScary() {
			return this.chckbxScary.isSelected();
		}
		
		public boolean isHeights() {
			return this.chckbxHeights.isSelected();
		}
		
		public boolean isKids() {
			return this.chckbxKids.isSelected();
		}
		
		public boolean isRollerCoaster() {
			return this.chckbxRollerCoaster.isSelected();
		}
		
		public boolean isWater() {
			return this.chckbxWater.isSelected();
		}
		
		public boolean isScaryAdmin() {
			return this.chckbxScaryAdmin.isSelected();
		}
		
		public boolean isHeightsAdmin() {
			return this.chckbxHeightsAdmin.isSelected();
		}
		
		public boolean isKidsAdmin() {
			return this.chckbxKidsAdmin.isSelected();
		}
		
		public boolean isRollerCoasterAdmin() {
			return this.chckbxRollerCoasterAdmin.isSelected();
		}
		
		public boolean isWaterAdmin() {
			return this.chckbxWaterAdmin.isSelected();
		}
		
		public boolean isAvailable() {
			return this.chckbxIsAvailable.isSelected();
		}

		public String getTextFieldId() {
			return textFieldId.getText();
		}

		public String getTextFieldName() {
			return textFieldName.getText();
		}

		public String getTextFieldDiscription() {
			return textFieldDiscription.getText();
		}
}
