package billing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class DRegister extends JFrame implements ItemListener {


public JPanel third;
private JTextField textDName;
private JTextField textDid;
private JTextField textPid;
String doctors[]= {"orthopaedic","physician","neurologist","surgeon","cardeologist"};
private JTextField textFees;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DRegister frame = new DRegister();
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
	public DRegister() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 456);
		third = new JPanel();
		third.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(third);
		third.setBackground(Color.GRAY);
		third.setForeground(Color.BLACK);
		third.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		third.setLayout(null);
	
		JLabel lblPatientBillingSystem = new JLabel("PATIENT BILLING SYSTEM");
		lblPatientBillingSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientBillingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientBillingSystem.setBounds(202, 46, 270, 33);
		third.add(lblPatientBillingSystem);
		third.setVisible(true);
		
		JLabel DocRegistration = new JLabel(" DOCTOR REGISTRATION");
		DocRegistration.setBounds(266, 91, 173, 33);
		third.add(DocRegistration);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(70, 161, 46, 14);
		third.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(70, 186, 46, 14);
		third.add(lblId);
		
		JLabel lblPatientAssignedId = new JLabel("PATIENT ASSIGNED ID");
		lblPatientAssignedId.setBounds(70, 236, 109, 14);
		third.add(lblPatientAssignedId);
		
		JLabel lblSpeciality = new JLabel("SPECIALITY");
		lblSpeciality.setBounds(70, 211, 77, 14);
		third.add(lblSpeciality);
		
		textDName = new JTextField();
		textDName.setBounds(202, 158, 156, 20);
		third.add(textDName);
		textDName.setColumns(10);
		
		textDid = new JTextField();
		textDid.setColumns(10);
		textDid.setBounds(202, 183, 156, 20);
		third.add(textDid);
		
		textPid = new JTextField();
		textPid.setColumns(10);
		textPid.setBounds(202, 233, 156, 20);
		third.add(textPid);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(281, 316, 89, 23);
		third.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBounds(403, 316, 89, 23);
		third.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(525, 316, 89, 23);
		third.add(btnDelete);

		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w2=new Welcome();
				dispose();
				w2.setVisible(true);
			}
		});
		btnBack.setBounds(404, 158, 89, 23);
		third.add(btnBack);
		
		JComboBox comboBox = new JComboBox(doctors);
		comboBox.setBounds(202, 208, 156, 23);
		//comboBox.addItemListener(frame);
	    comboBox.setSelectedItem("--select--");
		third.add(comboBox);
		
		JLabel lblFees = new JLabel("FEES");
		lblFees.setBounds(70, 259, 46, 14);
		third.add(lblFees);
		
		textFees = new JTextField();
		textFees.setColumns(10);
		textFees.setBounds(202, 256, 156, 20);
		third.add(textFees);
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Pname=textDName.getText();
				
				String Pid=textPid.getText();
				
				String Did=textDid.getText();
				String speciality=comboBox.getSelectedItem().toString();
				String Dfees=textFees.getText();
				//String illness=
				Connection con1;
				PreparedStatement insert;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con1=DriverManager.getConnection("jdbc:mysql://localhost/pbs","root","space314#$era");
					insert=con1.prepareStatement("insert into doctor(Name,docid,pid,speciality,Fees)values(?,?,?,?,?)");
					insert.setString(1,Pname);
					insert.setString(2,Did);
					insert.setString(3,Pid);
					insert.setString(4,speciality);
					insert.setString(5,Dfees);
					
					insert.executeUpdate();
					JOptionPane.showMessageDialog(third, "Doctor successfully added");
					textDName.setText("");
					textDid.setText("");
					textPid.setText("");
					textFees.setText("");
					
					textDName.requestFocus();
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
			
		});
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
