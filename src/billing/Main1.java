package billing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 frame = new Main1();
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
	public Main1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginid = new JLabel("LoginId");
		lblLoginid.setBounds(202, 159, 60, 33);
		contentPane.add(lblLoginid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(202, 214, 60, 21);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(283, 165, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(283, 214, 86, 21);
		contentPane.add(passwordField);
		
		JLabel lblPatientBillingSystem = new JLabel("PATIENT BILLING SYSTEM");
		lblPatientBillingSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientBillingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientBillingSystem.setBounds(202, 46, 270, 33);
		contentPane.add(lblPatientBillingSystem);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=textField.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				if(username.equals("era") & password.equals("erakrishna"))
				{
					
					Welcome w1=new Welcome();
				    
					setContentPane(w1.second1);
					revalidate();
				   
					
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "invalide Credentials");
				}
			}
		});
		btnLogin.setBounds(268, 326, 89, 23);
		contentPane.add(btnLogin);

	}
}
