package billing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.ResultSetMetaData;
import java.sql.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctorlist extends JFrame {

	private JPanel fourth;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctorlist frame = new Doctorlist();
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
	public Doctorlist() {
		int c;
		String col[]= {"id","name","pid","speciality"};
		String data[][]= {};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 456);
		fourth = new JPanel();
		fourth.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fourth);
		fourth.setBackground(Color.GRAY);
		fourth.setForeground(Color.BLACK);
		fourth.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		fourth.setLayout(null);
		fourth.setLayout(null);
	
		JLabel lblPatientBillingSystem = new JLabel("PATIENT BILLING SYSTEM");
		lblPatientBillingSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientBillingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientBillingSystem.setBounds(202, 46, 270, 33);
		fourth.add(lblPatientBillingSystem);
		
		JLabel lblDoctorList = new JLabel("Doctor List");
		lblDoctorList.setBounds(295, 90, 92, 22);
		
		fourth.add(lblDoctorList);
		
		table = new JTable();
		table.setBounds(421, 330, -236, -135);
		 JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setLocation(57, 123);
	        scrollPane.setSize(440,243);
	        
	        table.setSize(500,500);
	        fourth.add(scrollPane);
		//fourth.add(table);
		
		
		fourth.setVisible(true);
		Connection con1;
		PreparedStatement insert;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost/pbs","root","space314#$era");
			insert=con1.prepareStatement("select * from doctor");
			ResultSet rs=insert.executeQuery();
			ResultSetMetaData rss=rs.getMetaData();
			c=rss.getColumnCount();
			DefaultTableModel df=new DefaultTableModel(col,0);
			table.setModel(df);
			
			JButton btnBack = new JButton("back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PRegister p2=new PRegister();
					dispose();
					p2.setVisible(true);
				}
			});
			btnBack.setBounds(522, 90, 89, 23);
			fourth.add(btnBack);
			df.setRowCount(0);
			while(rs.next())
			{
				Vector v1=new Vector();
				for(int a=1;a<=c;a++)
				{
					v1.add(rs.getString("docid"));
					v1.add(rs.getString("Name"));
					v1.add(rs.getString("pid"));
					v1.add(rs.getString("speciality"));
					
				}
					df.addRow(v1);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
