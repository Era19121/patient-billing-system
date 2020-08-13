package billing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	public JPanel second1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 456);
		second1 = new JPanel();
		second1.setBackground(Color.GRAY);
		second1.setForeground(Color.BLACK);
		second1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(second1);
		second1.setLayout(null);
		JLabel lblPatientBillingSystem = new JLabel("PATIENT BILLING SYSTEM");
		lblPatientBillingSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientBillingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientBillingSystem.setBounds(202, 46, 270, 33);
		second1.add(lblPatientBillingSystem);
		second1.setVisible(true);
		
		JLabel Registration = new JLabel(" WELCOME TO REGISTRATION");
		Registration.setBounds(266, 91, 173, 33);
		second1.add(Registration);
		
		JButton btnRegisterPatient = new JButton("REGISTER PATIENT");
		
		btnRegisterPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PRegister p1=new PRegister();
				dispose();
				//setContentPane(p1.second);
				
				//revalidate();
				
				p1.setVisible(true);
				
			}
		});
		
		btnRegisterPatient.setBounds(268, 168, 135, 23);
		second1.add(btnRegisterPatient);
		JButton btnRegisterDoctor = new JButton("REGISTER DOCTOR");
		btnRegisterDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DRegister d1=new DRegister();
				dispose();
				//setContentPane(d1.third);
				//d1.third.updateUI();
				//revalidate();
				d1.setVisible(true);
				
			}
		});
		btnRegisterDoctor.setBounds(268, 219, 135, 23);
		second1.add(btnRegisterDoctor);
		

	}
}
