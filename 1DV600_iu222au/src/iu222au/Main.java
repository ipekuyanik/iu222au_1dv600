package iu222au;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.io.IOException;

public class Main {

	public static JFrame frame;
	public static JLayeredPane lpane = new JLayeredPane();
	public static Login log=new Login();
	public static Menu menu=new Menu();
	public static Hangman hangman;
	public String userid;
	public String password;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void chnge() {
		frame.getContentPane().removeAll();
	}
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(650, 300, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lpane.setBounds(new Rectangle(0, 0, 700, 550));
		lpane.setBorder(new EmptyBorder(0, 0, 0, 0));
		lpane.setLayout(null);
		
		try {
			hangman=new Hangman();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lpane.add(log,new Integer(0),0);
		
		frame.getContentPane().add(lpane);
		
	}

}