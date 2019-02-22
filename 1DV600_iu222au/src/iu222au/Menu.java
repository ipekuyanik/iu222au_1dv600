package iu222au;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox difficulty;
	public int level=0;


	public Menu() {
		
		setBounds(0,0,700,550);
		setBorder(new EmptyBorder(100, 100, 700, 550));
		setLayout(null);
		
		JButton playGame = new JButton("Play Game");
		playGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.lpane.removeAll();
				Main.lpane.add(Main.hangman,new Integer(0),0);
			}
		});
		playGame.setBounds(84, 119, 119, 25);
		add(playGame);
		
		JButton viewScore = new JButton("High Scores");
		viewScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewScore.setText("My Scores");
			}
		});
		viewScore.setToolTipText("");
		viewScore.setBounds(84, 157, 119, 30);
		add(viewScore);
		
		JButton quitGame = new JButton("Exit");
		quitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.dispose();
			}
		});
		quitGame.setBounds(84, 377, 119, 25);
		add(quitGame);
		
		String[] difficulties=new String[] {"Easy","Medium","Hard"};
		difficulty = new JComboBox(difficulties);
		difficulty.setSelectedIndex(level);
		difficulty.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				level=difficulty.getSelectedIndex();
			}
		});
		
		difficulty.setBounds(233, 120, 97, 22);
		add(difficulty);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(233, 160, 308, 242);
		add(textPane);

		
	}
}
