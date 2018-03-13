package GUI;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
public class toss_su extends JPanel{

	
	public static void main(String s[]){
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
		new toss_su();}
	});
		
	}
	public static String tempo; 
	public static int usernumber;
	public static String oe=null;
	public static int randnumbers[]={6,3,1,4,2};
	Random ra=new Random();
	public static int compnumber;
	static Font finp=new Font("Comic Sans MS",Font.BOLD,90);
	public static JLayeredPane layeredPane = new JLayeredPane();
	JLabel temp;
	
	public toss_su(){
				
		layeredPane.setPreferredSize(new Dimension(Single_player.screenSize.width, Single_player.screenSize.height));
		
		team_select.base1 = new JLabel();
		temp=team_select.base1;
		team_select.base1.setSize(Single_player.screenSize.width, Single_player.screenSize.height);
	
		team_select.base1.setIcon(Single_player.imageIcon);
		this.add(team_select.base1);
		
		//layeredPane.add(this,0);
		layeredPane.add(team_select.base1,1);
		this.add(layeredPane);
		layeredPane.setVisible(true);
		//Button for back
		final JButton back_su=new JButton("Back");	
		back_su.setActionCommand("back_su");
		back_su.setBounds(Single_player.screenSize.width/80, Single_player.screenSize.height/60, Single_player.screenSize.width/8, Single_player.screenSize.height/15);
		back_su.setBorderPainted(true);
		back_su.setFont(Single_player.fbutton);
		back_su.setFocusable(false);
		team_select.base1.add(back_su);
		back_su.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	back_su.setBackground(Color.lightGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	back_su.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 Single_player.c1.show(Single_player.parent, "2");
		    }
		});
		//Button for start
		final JButton next_su=new JButton("Start");
		next_su.setActionCommand("start_su");
		next_su.setBounds((int) (Single_player.screenSize.width/(1.16)), Single_player.screenSize.height/60, Single_player.screenSize.width/8, Single_player.screenSize.height/15);
		next_su.setBorderPainted(true);
		next_su.setFont(Single_player.fbutton);
		next_su.setFocusable(false);
		team_select.base1.add(next_su);
		next_su.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	next_su.setBackground(Color.lightGray);
		    	
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	next_su.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	if(!(toss_brain.compselect.equals(""))){
		    		//
		    		final play_su play= new play_su();
		    		Single_player.parent.add(play,"4");
			    	Single_player.c1.show(Single_player.parent, "4");}
			    	else{
			    		JOptionPane.showMessageDialog(team_select.base1, "Complete the toss", "TOSS",
			    		        JOptionPane.WARNING_MESSAGE);	
		   		    	}
	
		    }
		});


		//Toss label
		JLabel toss_head=new JLabel("TOSS", SwingConstants.CENTER);
		toss_head.setFont(Single_player.fhead);
		toss_head.setForeground(Color.WHITE);
		toss_head.setBounds((int) (Single_player.screenSize.width/(2.93)), (int) (Single_player.screenSize.height/(12)),Single_player.screenSize.width/4, (int) (Single_player.screenSize.height/(15)));
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
		toss_head.setBorder(border);
		team_select.base1.add(toss_head);
		
		//Label For input
		JLabel input=new JLabel("<html>Please type number among 1/2/3/4/6 <br> and select ODD or EVEN </html>");
		input.setFont(finp);
		input.setForeground(Color.WHITE);
		input.setBounds((int) (Single_player.screenSize.width/(100)), (int) (Single_player.screenSize.height/(40)),(int) (Single_player.screenSize.width), (int) (Single_player.screenSize.height/(2)));

		team_select.base1.add(input);
		
		
		//toss text fields
		final JTextField usernum=new JTextField();
		usernum.setBounds((int) (Single_player.screenSize.width/(200)), (int) (Single_player.screenSize.height/(2.6)),Single_player.screenSize.width/6, (int) (Single_player.screenSize.height/(20)));
		usernum.setFont(Single_player.flabel);
		team_select.base1.add(usernum);
		usernum.setHorizontalAlignment(JTextField.CENTER);
		
		usernum.addKeyListener(new KeyAdapter() {
		      
		      	
		      public void keyPressed(KeyEvent e) {
		    	  
		    	 usernumber=usernumber + e.getKeyCode();
				if(!(usernumber==49 || usernumber==50 || usernumber==51 || usernumber==52 || usernumber==54 || usernumber==8 ))
		    	 {
		    		 JOptionPane.showMessageDialog(team_select.base1, "Select between 1/2/3/4/6", "1/2/4/6",
			    		        JOptionPane.WARNING_MESSAGE);	
		    		 usernum.setText("");
		    		 usernumber=0;
		    	 }
		      }

		      
		    });
				final JButton odd=new JButton("ODD");
				final JButton even=new JButton("EVEN");
				//ODD
				odd.setActionCommand("odd");
				odd.setBounds(0, (int) (Single_player.screenSize.height/(2.05)), (int) (Single_player.screenSize.width/(4.5)), (int) (Single_player.screenSize.height/(15)));
				odd.setBorderPainted(true);
				odd.setFont(Single_player.fbutton);
				odd.setFocusable(false);
				team_select.base1.add(odd);
				odd.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if((odd.isEnabled()) && (usernumber==49 || usernumber==50 || usernumber==51 || usernumber==52 || usernumber==54 || usernumber==8 ))
				    	{
				    	oe=odd.getActionCommand();
				    	odd.setBackground(Color.GREEN);
				    	odd.setEnabled(false);
				    	even.setEnabled(false);
				    	usernum.setEditable(false);
				    	compnumber=randnumbers[ra.nextInt(5)];
				    	repaint();
				    	toss_brain.toss_handle(temp);
				    	//toss_brain.showHands();
				    	}
				    }
				});
				//EVEN
				even.setActionCommand("even");
				even.setBounds(0, (int) (Single_player.screenSize.height/(1.55)), (int) (Single_player.screenSize.width/(4.5)), (int) (Single_player.screenSize.height/(15)));
				even.setBorderPainted(true);
				even.setFont(Single_player.fbutton);
				even.setFocusable(false);
				team_select.base1.add(even);
				even.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if((even.isEnabled()) && (usernumber==49 || usernumber==50 || usernumber==51 || usernumber==52 || usernumber==54 || usernumber==8 )){
				    	oe=even.getActionCommand();
				    	even.setBackground(Color.GREEN);
				    	odd.setEnabled(false);
				    	even.setEnabled(false);
				    	compnumber=randnumbers[ra.nextInt(5)];
				    	repaint();
				    	toss_brain.toss_handle(temp);
				    	//toss_time();
				    	}
				
				}});
				
				
				    

	}
	
	@Override
	protected void paintChildren(Graphics g) {
		  super.paintChildren(g);
		  if(!(oe==null))
		  {
			  try {
				final BufferedImage image1 = ImageIO.read(new File(Character.getNumericValue(usernumber)+".jpg"));
				Image dimg1 = image1.getScaledInstance(Single_player.screenSize.width/10,Single_player.screenSize.height/(4),
				        Image.SCALE_SMOOTH);
				  g.drawImage(dimg1, (int) (Single_player.screenSize.width/(2)), (int) (Single_player.screenSize.height/(5)), null);
				  //hsjhaiskh 
				 
				  
				  final BufferedImage image2 = ImageIO.read(new File(compnumber+".jpg"));
					Image dimg2 = image2.getScaledInstance(Single_player.screenSize.width/10,Single_player.screenSize.height/(4),
					        Image.SCALE_SMOOTH);
					  g.drawImage(dimg2, (int) (Single_player.screenSize.width/(1.35)), (int) (Single_player.screenSize.height/(5)), null);
					  
					  
			} catch (IOException e) {
				e.printStackTrace();
			} 

		  }
		  
	}

}
