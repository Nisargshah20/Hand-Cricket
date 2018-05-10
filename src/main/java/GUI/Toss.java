package GUI;
import java.awt.*;
import backend.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * This class generates JPanel for toss
 * JPanel will consist of  buttons and labels 
 */
public class Toss extends JPanel{

	

	public static String tempo; 
	public static int usernumber;
	public static String oe=null;
	/**
	 * Array to generate the random numbers
	 */
	public static int randnumbers[]={6,3,1,4,2};
	Random ra=new Random();
	public static int compnumber;
	public static Font finp=new Font("Comic Sans MS",Font.BOLD,PlayMode.screenSize.width/42);
	public static JLayeredPane layeredPane = new JLayeredPane();
	JLabel temp;
	/**
	 * Generates GUI for Toss
	 */
	public Toss(){
				
		layeredPane.setPreferredSize(new Dimension(PlayMode.screenSize.width, PlayMode.screenSize.height));
		
		TeamSelection.base1 = new JLabel();
		temp=TeamSelection.base1;
		TeamSelection.base1.setSize(PlayMode.screenSize.width, PlayMode.screenSize.height);
	
		TeamSelection.base1.setIcon(PlayMode.imageIcon);
		this.add(TeamSelection.base1);
		
		//layeredPane.add(this,0);
		layeredPane.add(TeamSelection.base1,1);
		this.add(layeredPane);
		layeredPane.setVisible(true);
		//Button for back
		final JButton back_su=new JButton("Back");	
		back_su.setActionCommand("back_su");
		back_su.setBounds(PlayMode.screenSize.width/80, PlayMode.screenSize.height/60, PlayMode.screenSize.width/8, PlayMode.screenSize.height/15);
		back_su.setBorderPainted(true);
		back_su.setFont(PlayMode.fbutton);
		back_su.setFocusable(false);
		TeamSelection.base1.add(back_su);
		back_su.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	back_su.setBackground(Color.lightGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	back_su.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 PlayMode.c1.show(PlayMode.parent, "2");
		    }
		});
		//Button for start
		final JButton next_su=new JButton("Start");
		next_su.setActionCommand("start_su");
		next_su.setBounds((int) (PlayMode.screenSize.width/(1.16)), PlayMode.screenSize.height/60, PlayMode.screenSize.width/8, PlayMode.screenSize.height/15);
		next_su.setBorderPainted(true);
		next_su.setFont(PlayMode.fbutton);
		next_su.setFocusable(false);
		TeamSelection.base1.add(next_su);
		next_su.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	next_su.setBackground(Color.lightGray);
		    	
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	next_su.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	if(!(TossBrain.compselect.equals(""))){
		    		//
		    		final PlayArena1 play= new PlayArena1();
		    		PlayMode.parent.add(play,"4");
			    	PlayMode.c1.show(PlayMode.parent, "4");}
			    	else{
			    		JOptionPane.showMessageDialog(TeamSelection.base1, "Complete the toss", "TOSS",
			    		        JOptionPane.WARNING_MESSAGE);	
		   		    	}
	
		    }
		});


		//Toss label
		JLabel toss_head=new JLabel("TOSS", SwingConstants.CENTER);
		toss_head.setFont(PlayMode.fhead);
		toss_head.setForeground(Color.WHITE);
		toss_head.setBounds((int) (PlayMode.screenSize.width/(2.93)), (int) (PlayMode.screenSize.height/(12)),PlayMode.screenSize.width/4, (int) (PlayMode.screenSize.height/(15)));
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
		toss_head.setBorder(border);
		TeamSelection.base1.add(toss_head);
		
		//Label For input
		JLabel input=new JLabel("<html>Please type number among 1/2/3/4/6 <br> and select ODD or EVEN </html>");
		input.setFont(finp);
		input.setForeground(Color.WHITE);
		input.setBounds((int) (PlayMode.screenSize.width/(100)), (int) (PlayMode.screenSize.height/(40)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));

		TeamSelection.base1.add(input);
		
		
		//toss text fields
		final JTextField usernum=new JTextField();
		usernum.setBounds((int) (PlayMode.screenSize.width/(200)), (int) (PlayMode.screenSize.height/(2.6)),PlayMode.screenSize.width/6, (int) (PlayMode.screenSize.height/(20)));
		usernum.setFont(PlayMode.flabel);
		TeamSelection.base1.add(usernum);
		usernum.setHorizontalAlignment(JTextField.CENTER);
		  
		usernum.addKeyListener(new KeyAdapter() {
		      
		      	
		      public void keyPressed(KeyEvent e) {
		    	  
		    	 usernumber=usernumber + e.getKeyCode();
				if(!(usernumber==49 || usernumber==50 || usernumber==51 || usernumber==52 || usernumber==54 || usernumber==8 ))
		    	 {
		    		 JOptionPane.showMessageDialog(TeamSelection.base1, "Select between 1/2/3/4/6", "1/2/4/6",
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
				odd.setBounds(0, (int) (PlayMode.screenSize.height/(2.05)), (int) (PlayMode.screenSize.width/(4.5)), (int) (PlayMode.screenSize.height/(15)));
				odd.setBorderPainted(true);
				odd.setFont(PlayMode.fbutton);
				odd.setFocusable(false);
				TeamSelection.base1.add(odd);
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
				    	TossBrain.toss_handle(temp);
				    	//TossBrain.showHands();
				    	}
				    }
				});
				//EVEN
				even.setActionCommand("even");
				even.setBounds(0, (int) (PlayMode.screenSize.height/(1.55)), (int) (PlayMode.screenSize.width/(4.5)), (int) (PlayMode.screenSize.height/(15)));
				even.setBorderPainted(true);
				even.setFont(PlayMode.fbutton);
				even.setFocusable(false);
				TeamSelection.base1.add(even);
				even.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if((even.isEnabled()) && (usernumber==49 || usernumber==50 || usernumber==51 || usernumber==52 || usernumber==54 || usernumber==8 )){
				    	oe=even.getActionCommand();
				    	even.setBackground(Color.GREEN);
				    	odd.setEnabled(false);
				    	even.setEnabled(false);
				    	compnumber=randnumbers[ra.nextInt(5)];
				    	repaint();
				    	TossBrain.toss_handle(temp);
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
				Image dimg1 = image1.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
				        Image.SCALE_SMOOTH);
				  g.drawImage(dimg1, (int) (PlayMode.screenSize.width/(2)), (int) (PlayMode.screenSize.height/(5)), null);
				 
				  
				  final BufferedImage image2 = ImageIO.read(new File(compnumber+".jpg"));
					Image dimg2 = image2.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
					        Image.SCALE_SMOOTH);
					  g.drawImage(dimg2, (int) (PlayMode.screenSize.width/(1.35)), (int) (PlayMode.screenSize.height/(5)), null);
					  
					  
			} catch (IOException e) {
				e.printStackTrace();
			} 

		  }
		  
	}

}
