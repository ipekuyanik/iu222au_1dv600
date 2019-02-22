package iu222au;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Hangman extends JPanel {

		private static final long serialVersionUID = 1L;
		private int error=8,count=0,tmp;
		private String selected;
		private String[] words4=new String[500];
		private String[] words5=new String[500];
		private String[] words6=new String[500];
		private String[] words7=new String[500];
		private String[] words8=new String[500];
		private String[] words =new String[2500];
	
		private JButton btnA = new JButton("A");
		private JButton btnB = new JButton("B");
		private JButton btnC = new JButton("C");
		private JButton btnD = new JButton("D");
		private JButton btnE = new JButton("E");
		private JButton btnF = new JButton("F");
		private JButton btnG = new JButton("G");
		private JButton btnH = new JButton("H");
		private JButton btnI = new JButton("I");
		private JButton btnJ = new JButton("J");
		private JButton btnK = new JButton("K");
		private JButton btnL = new JButton("L");
		private JButton btnM = new JButton("M");
		private JButton btnN = new JButton("N");
		private JButton btnO = new JButton("O");
		private JButton btnP = new JButton("P");
		private JButton btnQ = new JButton("Q");
		private JButton btnR = new JButton("R");
		private JButton btnS = new JButton("S");
		private JButton btnT = new JButton("T");
		private JButton btnU = new JButton("U");
		private JButton btnV = new JButton("V");
		private JButton btnW = new JButton("W");
		private JButton btnX = new JButton("X");
		private JButton btnY = new JButton("Y");
		private JButton btnZ = new JButton("Z");
	
		private JLabel[] label = new JLabel[10];
		private JLabel[] lblLetter = new JLabel[10];
		private JLabel label_Error= new JLabel();
		private JLabel labelResult = new JLabel();
		private JButton newGame = new JButton();
		private JButton quitGame = new JButton("Quit Game");
		
		public void buttonEnable(boolean tmp) {
			btnA.setEnabled(tmp);btnB.setEnabled(tmp);btnC.setEnabled(tmp);btnD.setEnabled(tmp);btnE.setEnabled(tmp);btnF.setEnabled(tmp);
			btnG.setEnabled(tmp);btnH.setEnabled(tmp);btnI.setEnabled(tmp);btnJ.setEnabled(tmp);btnK.setEnabled(tmp);btnL.setEnabled(tmp);
			btnM.setEnabled(tmp);btnN.setEnabled(tmp);btnO.setEnabled(tmp);btnP.setEnabled(tmp);btnQ.setEnabled(tmp);btnR.setEnabled(tmp);
			btnS.setEnabled(tmp);btnT.setEnabled(tmp);btnU.setEnabled(tmp);btnV.setEnabled(tmp);btnW.setEnabled(tmp);btnX.setEnabled(tmp);
			btnY.setEnabled(tmp);btnZ.setEnabled(tmp);
		}
			
			
		public void pressedButton(JButton tmp, char char1, char char2,String selected) {
			tmp.setEnabled(false);
			if(selected.contains(""+char1) || selected.contains(""+char2)) {
				for(int i=0;i<selected.length();i++) {
					if(selected.charAt(i)==char1|| selected.charAt(i)==char2) {
						lblLetter[i+((10-selected.length())/2)].setVisible(true);
						lblLetter[i+((10-selected.length())/2)].setText(""+char2);
						count++;
					}
				}
				if(count==selected.length()) {
					labelResult.setText("You win");
					labelResult.setVisible(true);
					newGame.setVisible(true);
					buttonEnable(false);
					quitGame.setBounds(326 ,184 ,106 ,60 );
				}
			}else {
				error=error-1;
				label_Error.setText(""+error);
				if(error==0) {
					labelResult.setText("Game Over");
					labelResult.setVisible(true);
					newGame.setVisible(true);
					buttonEnable(false);
					for(int i=0;i<selected.length();i++) {
						lblLetter[i+((10-selected.length())/2)].setVisible(true);
						lblLetter[i+((10-selected.length())/2)].setText(""+ Character.toUpperCase(selected.charAt(i)));
					}
					quitGame.setBounds(326 ,184 ,106 ,60 );
				}
			}
		}

		
		public void createrLabels(JLabel[] tmp,String text,boolean cont, int size,int x,int y, int weight, int height) {
			for(int i=0; i<10;i++) {
				tmp[i] = new JLabel(text);
				tmp[i].setFont(new Font("Tahoma", Font.BOLD, size));
				tmp[i].setBounds(x, y, weight, height);
				x=x+52;
				tmp[i].setVisible(cont);
				add(tmp[i]);
			}	
		}
		public void createrButton(JButton tmp,int x,int y) {
			tmp.setBorder(null);
			tmp.setOpaque(false);
			tmp.setFont(new Font("Tahoma", Font.BOLD, 15));
			tmp.setBounds(x, y, 47, 47);
			add(tmp);
		}
		
		
		public String selectedWord() {
			Random rnd=new Random();
			return words[rnd.nextInt(words.length)];
		}

		
		public Hangman() throws IOException {

			setBackground(new Color(176, 224, 230));
			setBounds(0,0,700,550);
			setBorder(new EmptyBorder(100, 100, 700, 550));
			setLayout(null);
			setBackground(new Color(176, 224, 230));
			BufferedReader reader = null;
			int i,j;
			String line;
			FileReader file;
			
			i=0;
			file = new FileReader("4 Letters");
	        reader = new BufferedReader(file);
	        while ((line = reader.readLine()) !=null) 
	        	words4[i++]=line;
	        i=0;
	        file = new FileReader("5 Letters");
	        reader = new BufferedReader(file);
	        while ((line = reader.readLine()) !=null) 
	        	words5[i++]=line;
	        i=0;
	        file = new FileReader("6 Letters");
	        reader = new BufferedReader(file);
	        while ((line = reader.readLine()) !=null) 
	        	words6[i++]=line;
	        i=0;
	        file = new FileReader("7 Letters");
	        reader = new BufferedReader(file);
	        while ((line = reader.readLine()) !=null) 
	        	words7[i++]=line;
	        i=0;
	        file = new FileReader("8 Letters");
	        reader = new BufferedReader(file);
	        while ((line = reader.readLine()) !=null) 
	        	words8[i++]=line;
	        reader.close();
			
	        i=0;
	        	for(j=0;j<500;j++)
	        	words[i++]=words4[j];
	        	for(j=0;j<500;j++)
	        	words[i++]=words5[j];
	        	for(j=0;j<500;j++)
	        	words[i++]=words4[j];
	        	for(j=0;j<500;j++)
	        	words[i++]=words6[j];
	        	for(j=0;j<500;j++)
	        	words[i++]=words7[j];
	        
	        quitGame = new JButton("Back to Menu");
			quitGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Main.lpane.removeAll();
					Main.lpane.add(Main.menu,new Integer(0),0);
				}
			});
			quitGame.setBounds(544 ,28 , 123, 60);
			add(quitGame);
	        
			label_Error.setText("8");
			label_Error.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_Error.setBounds(333, 117, 47, 16);
			add(label_Error);
			
			labelResult.setHorizontalAlignment(SwingConstants.CENTER);
			labelResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
			labelResult.setBounds(263, 146, 106, 25);
			add(labelResult);
			labelResult.setVisible(false);
			
			newGame.setBounds(213, 184, 106, 60);
			add(newGame);
			newGame.setText("New Game");
			newGame.setVisible(false);
			
			
			newGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonEnable(true);
					newGame.setVisible(false);
					selected=selectedWord();
					tmp=10-selected.length();
					tmp=tmp/2;
					for(int k=0;k<10;k++) {
						label[k].setVisible(false);
						lblLetter[k].setVisible(false);
					}
					for(int j=tmp;j<selected.length()+tmp;j++) 
						label[j].setVisible(true);
					labelResult.setVisible(false);
					error=8;
					label_Error.setText(""+error);
					count=0;
					quitGame.setBounds(551 ,28 ,106 ,60 );
					//JOptionPane.showMessageDialog(null, selected, "Mesaj 1", 1);
				}
			});
			
			//////////////////////////////////////////////////////////////////////////////////////
			JLabel lblNewLabel = new JLabel("Hangman");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel.setBounds(252, 50, 128, 54);
			add(lblNewLabel);
			
			
			JLabel lbl_Last = new JLabel("Left:");
			lbl_Last.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbl_Last.setBounds(272, 117, 47, 16);
			add(lbl_Last);
			
			createrLabels(label ,"_" ,false ,20 ,75 ,262 ,40 ,25 );
			createrLabels(lblLetter,"",false,25 ,86 ,258 ,26 , 20 );
			
			selected=selectedWord();
			tmp=10-selected.length();
			tmp=tmp/2;
			for(i=tmp;i<selected.length()+tmp;i++) 
				label[i].setVisible(true);
			//JOptionPane.showMessageDialog(null, selected, "Mesaj 1", 1);
			
			
			///////////////////////////////////////////
			
			createrButton(btnA,50,300);
			btnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnA,'a','A',selected);
				}
			});
			
			createrButton(btnB,109,300);
			btnB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnB,'b','B',selected);
				}
			});
			
			createrButton(btnC,168,300);
			btnC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pressedButton(btnC,'c','C',selected);
				}
			});
			
			createrButton(btnD,227,300);
			btnD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnD,'d','D',selected);
				}
			});
			
			createrButton(btnE,286,300);
			btnE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnE,'e','E',selected);
				}
			});
			
			createrButton(btnF,345,300);
			btnF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnF,'f','F',selected);
				}
			});
			
			createrButton(btnG,404,300);
			btnG.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnG,'g','G',selected);
				}
			});
			
			createrButton(btnH,463,300);
			btnH.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnH,'h','H',selected);
				}
			});
			
			createrButton(btnI,522,300);
			btnI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnI,'i','I',selected);
				}
			});

			createrButton(btnJ,581,300);
			btnJ.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnJ,'j','J',selected);
				}
			});
			
			createrButton(btnK,75,360);
			btnK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnK,'k','K',selected);
				}
			});
			
			createrButton(btnL,134,360);
			btnL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnL,'l','L',selected);
				}
			});
			
			createrButton(btnM,193,360);
			btnM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnM,'m','M',selected);
				}
			});
			
			createrButton(btnN,252,360);
			btnN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnN,'n','N',selected);
				}
			});
			
			createrButton(btnO,311,360);
			btnO.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnO,'o','O',selected);
				}
			});
			
			createrButton(btnP,370,360);
			btnP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnP,'p','P',selected);
				}
			});
			
			createrButton(btnQ,429,360);
			btnQ.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnQ,'q','Q',selected);
				}
			});
			
			createrButton(btnR,488,360);
			btnR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnR,'r','R',selected);
				}
			});
			
			createrButton(btnS,547,360);
			btnS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnS,'s','S',selected);
				}
			});
			
			createrButton(btnT,131,420);
			btnT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnT,'t','T',selected);
				}
			});
			
			createrButton(btnU,193,420);
			btnU.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnU,'u','U',selected);
				}
			});
			
			createrButton(btnV,252,420);
			btnV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnV,'v','V',selected);
				}
			});

			createrButton(btnW,311,420);
			btnW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnW,'w','W',selected);
				}
			});
			
			createrButton(btnX,370,420);
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnX,'x','X',selected);
				}
			});
			
			createrButton(btnY,429,420);
			btnY.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnY,'y','Y',selected);
				}
			});
			
			createrButton(btnZ,488,420);
			btnZ.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pressedButton(btnZ,'z','Z',selected);
				}
			});
			
		}
	}
