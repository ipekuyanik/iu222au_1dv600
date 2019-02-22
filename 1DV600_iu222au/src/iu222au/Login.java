package iu222au;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
		private JTextField textField;
		private JTextField textField_1;
		private JLabel labelInfo;
		private JButton login;
		private JButton register;
		private JButton guestUser;
		


		public Login() {
			setBounds(new Rectangle(0, 0, 700, 550));
			setAlignmentY(Component.TOP_ALIGNMENT);
			setAlignmentX(Component.LEFT_ALIGNMENT);
			setLayout(null);
			
			JLabel lblUserId = new JLabel("User Id:");
			lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUserId.setBounds(134, 161, 120, 25);
			add(lblUserId);
			
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPassword.setBounds(134, 212, 120, 25);
			add(lblPassword);
			
			textField = new JTextField();
			textField.setBounds(277, 165, 223, 22);
			add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(277, 216, 223, 22);
			add(textField_1);
			textField_1.setColumns(10);
			
			login = new JButton("Login");
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelInfo.setText("Wrong password or userId");
				}
			});
			login.setBounds(403, 281, 97, 25);
			add(login);
			
			guestUser = new JButton("Guest User");
			guestUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Main.lpane.removeAll();
					Main.lpane.add(Main.menu,new Integer(0),0);
				}
			});
			guestUser.setBounds(134, 281, 120, 25);
			add(guestUser);
			
			register = new JButton("Register");
			register.setBounds(282, 281, 97, 25);
			add(register);
			
			labelInfo = new JLabel();
			labelInfo.setBounds(134, 250, 366, 16);
			add(labelInfo);
		}
	}