package billing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.sql.PreparedStatement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PRegister extends JFrame {

	/**
	 * Create the panel.
	 */public JPanel second;
	private JTextField textPid;
	private JTextField textPstatus;
	private JTextField textPdocid;
	private JTextField textPAge;
	private JTextField textPname;
	private JTextField textPIll;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRegister frame = new PRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public PRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 456);
		second = new JPanel();
		second.setBackground(Color.GRAY);
		second.setForeground(Color.BLACK);
		second.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(second);
		second.setLayout(null);
		JLabel lblPatientBillingSystem = new JLabel("PATIENT BILLING SYSTEM");
		lblPatientBillingSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientBillingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientBillingSystem.setBounds(202, 46, 270, 33);
		second.add(lblPatientBillingSystem);
		second.setVisible(true);
		JLabel lblPatientRegistration = new JLabel("PATIENT REGISTRATION");
		lblPatientRegistration.setBounds(256, 90, 128, 25);
		second.add(lblPatientRegistration);
		
		JLabel lblPName = new JLabel("NAME");
		lblPName.setBounds(69, 162, 46, 14);
		second.add(lblPName);
		
		JLabel lblPid = new JLabel("PATIENT ID");
		lblPid.setBounds(70, 187, 76, 14);
		second.add(lblPid);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setBounds(69, 212, 46, 14);
		second.add(lblAge);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(69, 237, 46, 14);
		second.add(lblStatus);
		
		JLabel lblDoctorAssigned = new JLabel("DOCTOR ID ASSIGNED");
		lblDoctorAssigned.setBounds(69, 283, 120, 14);
		second.add(lblDoctorAssigned);
		
		textPid = new JTextField();
		textPid.setBounds(202, 184, 120, 20);
		second.add(textPid);
		textPid.setColumns(10);
		
		textPstatus = new JTextField();
		textPstatus.setBounds(202, 234, 120, 20);
		second.add(textPstatus);
		textPstatus.setColumns(10);
		
		textPdocid = new JTextField();
		textPdocid.setBounds(202, 280, 120, 20);
		second.add(textPdocid);
		textPdocid.setColumns(10);
		
		textPAge = new JTextField();
		textPAge.setBounds(202, 209, 120, 20);
		second.add(textPAge);
		textPAge.setColumns(10);
		
		textPname = new JTextField();
		textPname.setColumns(10);
		textPname.setBounds(202, 159, 120, 20);
		second.add(textPname);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(131, 320, 89, 23);
		second.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(256, 320, 89, 23);
		second.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(375, 320, 89, 23);
		second.add(btnDelete);
		
		JLabel lblIllness = new JLabel("ILLNESS");
		lblIllness.setBounds(69, 262, 46, 14);
		second.add(lblIllness);
		
		textPIll = new JTextField();
		textPIll.setColumns(10);
		textPIll.setBounds(202, 259, 120, 20);
		second.add(textPIll);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w2=new Welcome();
				dispose();
				w2.setVisible(true);
			}
		});
		btnBack.setBounds(404, 158, 89, 23);
		second.add(btnBack);
		
		JButton button = new JButton("DOCTOR LIST");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctorlist dl2=new Doctorlist();
				dispose();
				dl2.setVisible(true);
				
			}
		});
		button.setBounds(404, 208, 123, 23);
		second.add(button);
		
	
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Pname=textPname.getText();
				String PAge=textPAge.getText();
				String Pid=textPid.getText();
				String PStatus=textPstatus.getText();
				String docid=textPdocid.getText();
				String Pillness=textPIll.getText();
				
				Connection con1;
				PreparedStatement insert;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con1=DriverManager.getConnection("jdbc:mysql://localhost/pbs","root","space314#$era");
					insert=con1.prepareStatement("insert into patient(Name,pid,age,status,illness,docid)values(?,?,?,?,?,?)");
					insert.setString(1,Pname);
					insert.setString(2,PAge);
					insert.setString(3,Pid);
					insert.setString(4,PStatus);
					insert.setString(5,Pillness);
					insert.setString(6,docid);
					insert.executeUpdate();
					JOptionPane.showMessageDialog(second, "patient successfully added");
					textPname.setText("");
					textPAge.setText("");
					textPid.setText("");
					textPstatus.setText("");
					textPdocid.setText("");
					textPIll.setText("");
					textPname.requestFocus();
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
		
	}
}
