package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class ViewTicketsPageView extends JFrame {

	private JPanel contentPane;
	private JTable tableOrders;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTicketsPageView frame = new ViewTicketsPageView();
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
	public ViewTicketsPageView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderPage = new JLabel("Order page");
		lblOrderPage.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblOrderPage.setBounds(277, 11, 182, 67);
		contentPane.add(lblOrderPage);
		
		JLabel lblNewLabel_1 = new JLabel("Tickets order list:");
		lblNewLabel_1.setBounds(24, 76, 667, 14);
		contentPane.add(lblNewLabel_1);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 101, 653, 265);
		contentPane.add(scrollPane);
		
		tableOrders = new JTable();
		tableOrders.setRowSelectionAllowed(false);
		scrollPane.setViewportView(tableOrders);
	}
	
	//methods:
	
		public void setActionListenerForBtns(ActionListener actionListener) {
			this.btnBack.addActionListener(actionListener);

		}
		
		public void setAttractionListToTable(ResultSet rs) {
			this.tableOrders.setModel(DbUtils.resultSetToTableModel(rs));
		}
}
