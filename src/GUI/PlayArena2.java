package GUI;
import backend.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlayArena2 extends JPanel{
	public static int usershot2;
	public static int compshot2;
	public static JLabel reference2;
	Random ra =new Random();

	
	public static Font fsc=new Font("Comic Sans MS",Font.BOLD,100);
	public static Font fre=new Font("Comic Sans MS",Font.BOLD,50);
	public static  JLabel play_base2;
	public static JLabel update_score2;
	public static JLabel update_runrate2;
	public static JLabel update_overs2;
	public static JLabel update_strikes2;
	public static int[] hardshots2={1,2,3};
	String temp[] = null;
	public static  JButton viewscore2;
	public static JLabel update_comments2;
	public PlayArena2(){
		//Button for viewscorecard
		viewscore2=new JButton("View Scorecard>>>");	
		viewscore2.setBounds((int) (PlayMode.screenSize.width/(1.275)), (int) (PlayMode.screenSize.height/(2.5)), PlayMode.screenSize.width/4, PlayMode.screenSize.height/15);
		viewscore2.setBorderPainted(true);
		viewscore2.setFont(PlayMode.fbutton);
		viewscore2.setFocusable(false);
		viewscore2.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 viewscore2.setBackground(Color.GREEN);
			    	
			    }
			 public void mouseExited(java.awt.event.MouseEvent evt) {
				 viewscore2.setBackground(UIManager.getColor("control"));
			    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    		final ViewScore2 vs2= new ViewScore2();
	    		PlayMode.parent.add(vs2,"7");
		    	PlayMode.c1.show(PlayMode.parent, "7");
		    }
		});
		
		
	
		play_base2 = new JLabel();
		play_base2.setSize(PlayMode.screenSize.width, PlayMode.screenSize.height);
		play_base2.setIcon(PlayMode.imageIcon); 
		this.add(play_base2);
		reference2=play_base2;
		
		//Team Display
		
		
				//My Team
				final JButton my_team=new JButton(PlayMode.myteam);
				
				my_team.setBounds(0, PlayMode.screenSize.height/60, PlayMode.screenSize.width/3, PlayMode.screenSize.height/10);
				my_team.setBorderPainted(true);
				my_team.setFont(PlayMode.fbutton);
				my_team.setFocusable(false);
				play_base2.add(my_team);

				//Opposition Team
				final JButton opp_team=new JButton(PlayMode.oppteam);
				opp_team.setBounds((int) (PlayMode.screenSize.width/(1.46)), PlayMode.screenSize.height/60, PlayMode.screenSize.width/3, PlayMode.screenSize.height/10);
				opp_team.setBorderPainted(true);
				opp_team.setFont(PlayMode.fbutton);
				opp_team.setFocusable(false);
				play_base2.add(opp_team);
				
				
			//Batting Bowling
				//Myteam  Panel
				JLabel myteam_what=new JLabel(TossBrain.compselect.toUpperCase(),SwingConstants.CENTER);
				myteam_what.setFont(PlayMode.fhead);
				myteam_what.setForeground(Color.WHITE);
				myteam_what.setBounds(0, (int) (PlayMode.screenSize.height/(8.7)), PlayMode.screenSize.width/4, (int) (PlayMode.screenSize.height/(15)));
				javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
				myteam_what.setBorder(border);
				play_base2.add(myteam_what);
				
				//Opp Panel
				JLabel oppteam_what=new JLabel(TossBrain.userselect.toUpperCase(),SwingConstants.CENTER);
				oppteam_what.setFont(PlayMode.fhead);
				oppteam_what.setForeground(Color.WHITE);
				oppteam_what.setBounds((int) (PlayMode.screenSize.width/(1.30)), (int) (PlayMode.screenSize.height/(8.7)), PlayMode.screenSize.width/4, (int) (PlayMode.screenSize.height/(15)));
				oppteam_what.setBorder(border);
				play_base2.add(oppteam_what);
		//Scorecard
				JLabel score_head=new JLabel("SCORE",SwingConstants.CENTER);
				score_head.setFont(PlayMode.fbutton);
				score_head.setForeground(Color.WHITE);
				score_head.setBounds((int) (PlayMode.screenSize.width/(2.8)), (int) (PlayMode.screenSize.height/(59)), PlayMode.screenSize.width/5, PlayMode.screenSize.height/20);
				score_head.setBorder(border);
				play_base2.add(score_head);
				
				//Numeric score1
				JLabel score=new JLabel("0/0",SwingConstants.CENTER);
				update_score2=score;
				score.setFont(fsc);
				score.setForeground(Color.WHITE);
				score.setBounds((int) (PlayMode.screenSize.width/(2.8)), (int) (PlayMode.screenSize.height/(15)), PlayMode.screenSize.width/5, PlayMode.screenSize.height/15);
				score.setBorder(border);
				play_base2.add(score);
				
				//Overs
				JLabel overs=new JLabel("<html>Overs : 0.0 ("+PlayMode.overs+")</html>",SwingConstants.CENTER);
				update_overs2=overs;
				overs.setFont(PlayMode.fbutton);
				overs.setForeground(Color.WHITE);
				overs.setBounds((int) (PlayMode.screenSize.width/(2.8)), (int) (PlayMode.screenSize.height/(7.5)), PlayMode.screenSize.width/5, PlayMode.screenSize.height/20);
				overs.setBorder(border);
				play_base2.add(overs);
				
				//needed
				JLabel runrate=new JLabel("<html>NEED<br>"+(PlayBrain1.team_score_1+1)+"<br>OFF<br>"+(Integer.parseInt(PlayMode.overs)*6)+" <br>BALLS</html>",SwingConstants.CENTER);
				update_runrate2=runrate;
				runrate.setFont(fre);
				runrate.setForeground(Color.WHITE);
				runrate.setBounds((int) (PlayMode.screenSize.width/(2.8)+PlayMode.screenSize.width/5), (int) (PlayMode.screenSize.height/(59)), PlayMode.screenSize.width/10, PlayMode.screenSize.height/6);
				runrate.setBorder(border);
				play_base2.add(runrate);
				
				//Label For Strikes
				JLabel strikes2=new JLabel("");
				strikes2.setFont(PlayMode.fstrike);
				strikes2.setForeground(Color.YELLOW);
				strikes2.setBounds((int) (PlayMode.screenSize.width/(80)), (int) (PlayMode.screenSize.height/(11)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
				update_strikes2=strikes2;
				play_base2.add(strikes2);
				
				
				//Label For Comments
				JLabel comm=new JLabel("");
				comm.setFont(Toss.finp);
				comm.setForeground(Color.WHITE);
				comm.setBounds((int) (PlayMode.screenSize.width/(100)), (int) (PlayMode.screenSize.height/(2.45)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
				update_comments2=comm;
				play_base2.add(comm);
				
		//Playing buttons
				
				//Buttons defiinition
				 final JButton one=new JButton("1");
				final JButton two=new JButton("2");	
				final JButton three=new JButton("3");
				final JButton four=new JButton("4");
				final JButton six=new JButton("6");
				
				//1 Button
				one.setActionCommand("1");
				one.setBounds((int) (PlayMode.screenSize.width/(2.8)), PlayMode.screenSize.height/50+(int) (PlayMode.screenSize.height/(1.55)), PlayMode.screenSize.width/15, PlayMode.screenSize.height/10);
				one.setBorderPainted(true);
				one.setFont(PlayMode.fbutton);
				one.setFocusable(false);
				play_base2.add(one);
				one.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	one.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	one.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain2.if_second_inning_over)){
				    	usershot2=Integer.parseInt(one.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
				    	compshot2=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(TossBrain.compselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=Toss.randnumbers[ra.nextInt(5)];
				    	}				    	
				    	PlayBrain2 pb2 =new PlayBrain2(update_score2,update_overs2, update_runrate2,reference2,update_comments2,update_strikes2);
				    	try {
							pb2.main(temp);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
					    	repaint();
					    	pb2=null;
				    	
				    	}
					    	//Disabling if inning over
				    	else{
					    		one.setEnabled(false);
					    		two.setEnabled(false);
					    		three.setEnabled(false);
					    		four.setEnabled(false);
					    		six.setEnabled(false);
					    	}
			
				    }
				});
				
				//2 Button1
				two.setActionCommand("2");
				two.setBounds((int) (PlayMode.screenSize.width/(2.07)), PlayMode.screenSize.height/50+(int) (PlayMode.screenSize.height/(1.55)), PlayMode.screenSize.width/15, PlayMode.screenSize.height/10);
				two.setBorderPainted(true);
				two.setFont(PlayMode.fbutton);
				two.setFocusable(false);
				play_base2.add(two);
				two.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	two.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	two.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	
				    	if(!(PlayBrain2.if_second_inning_over)){
				    	usershot2=Integer.parseInt(two.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
					    	compshot2=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(TossBrain.compselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=Toss.randnumbers[ra.nextInt(5)];
				    	}
				    	PlayBrain2 pb2 =new PlayBrain2(update_score2,update_overs2, update_runrate2,reference2,update_comments2,update_strikes2);
				    	try {
							pb2.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb2=null;
				    	}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
			
				    }
				});				
				
				//3 Button
				three.setActionCommand("3");
				three.setBounds((int) (PlayMode.screenSize.width/(1.65)), PlayMode.screenSize.height/50+(int) (PlayMode.screenSize.height/(1.55)), PlayMode.screenSize.width/15, PlayMode.screenSize.height/10);
				three.setBorderPainted(true);
				three.setFont(PlayMode.fbutton);
				three.setFocusable(false);
				play_base2.add(three);
				three.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	three.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	three.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain2.if_second_inning_over)){
				    	usershot2=Integer.parseInt(three.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
					    	compshot2=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(TossBrain.compselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=Toss.randnumbers[ra.nextInt(5)];
				    	}
				    	PlayBrain2 pb2 =new PlayBrain2(update_score2,update_overs2, update_runrate2,reference2,update_comments2,update_strikes2);
				    	try {
							pb2.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb2=null;}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
			
				    }
				});				
				
				//4 Button
				four.setActionCommand("4");
				four.setBounds((int) (PlayMode.screenSize.width/(2.38)), PlayMode.screenSize.height/50+(int) (PlayMode.screenSize.height/(1.25)), PlayMode.screenSize.width/15, PlayMode.screenSize.height/10);
				four.setBorderPainted(true);
				four.setFont(PlayMode.fbutton);
				four.setFocusable(false);
				play_base2.add(four);
				four.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	four.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	four.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain2.if_second_inning_over)){
				    	usershot2=Integer.parseInt(four.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
					    	compshot2=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(TossBrain.compselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=Toss.randnumbers[ra.nextInt(5)];
				    	}
				    	
				    	PlayBrain2 pb2 =new PlayBrain2(update_score2,update_overs2, update_runrate2,reference2,update_comments2,update_strikes2);
				    	try {
							pb2.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb2=null;
				    	}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
			
				    }
				});
				//6 Button
				six.setActionCommand("6");
				six.setBounds((int) (PlayMode.screenSize.width/(1.83)), PlayMode.screenSize.height/50+(int) (PlayMode.screenSize.height/(1.25)), PlayMode.screenSize.width/15, PlayMode.screenSize.height/10);
				six.setBorderPainted(true);
				six.setFont(PlayMode.fbutton);
				six.setFocusable(false);
				play_base2.add(six);
				six.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	six.setBackground(Color.green);
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	six.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain2.if_second_inning_over)){
				    	usershot2=Integer.parseInt(six.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy") ){
					    	compshot2=Toss.randnumbers[ra.nextInt(5)];}
					    	else
					    	{	
					    		if(TossBrain.compselect.equals("bat"))
					    		compshot2=hardshots2[ra.nextInt(3)];
					    		else
					    			compshot2=Toss.randnumbers[ra.nextInt(5)];
					    	}
				    	PlayBrain2 pb2 =new PlayBrain2(update_score2,update_overs2, update_runrate2,reference2,update_comments2,update_strikes2);
				    	try {
							pb2.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb2=null;
				    	}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
				    }
				});		
	}
	@Override
	protected void paintChildren(Graphics g) {
		 super.paintChildren(g);
		  if(!(usershot2==0))
		  {
			  try {
				final BufferedImage image1 = ImageIO.read(new File(usershot2+".jpg"));
				Image dimg1 = image1.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
				        Image.SCALE_SMOOTH);
				  g.drawImage(dimg1, (int) (PlayMode.screenSize.width/(3.75)), (int) (PlayMode.screenSize.height/(3.25)), null);
					//Images For hand2
				  final BufferedImage image2;
				  if(PlayBrain2.check_if_wicket2){				
					  	image2 = ImageIO.read(new File(usershot2+".jpg"));
					  	}
				  else{
					  image2 = ImageIO.read(new File(compshot2+".jpg"));
				  	} 
				 
				 
					Image dimg2 = image2.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
					        Image.SCALE_SMOOTH);
					  g.drawImage(dimg2, (int) (PlayMode.screenSize.width/(1.52)), (int) (PlayMode.screenSize.height/(3.25)), null);
					  
					if(PlayBrain2.check_if_wicket2){
						final BufferedImage image3 = ImageIO.read(new File("out.jpg"));
						Image dimg3 = image3.getScaledInstance(PlayMode.screenSize.width/6,PlayMode.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg3, (int) (PlayMode.screenSize.width/(1.2)), (int) (PlayMode.screenSize.height/(1.6)), null);
						
					}
					if((!(PlayBrain2.check_if_wicket2)) && (PlayBrain2.tempshot2==4)){
						final BufferedImage image4 = ImageIO.read(new File("four.jpeg"));
						Image dimg4 = image4.getScaledInstance(PlayMode.screenSize.width/6,PlayMode.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg4, (int) (PlayMode.screenSize.width/(1.2)), (int) (PlayMode.screenSize.height/(1.6)), null);
						
					}
					if((!(PlayBrain2.check_if_wicket2)) && ( PlayBrain2.tempshot2==6)){
						final BufferedImage image5 = ImageIO.read(new File("six.jpg"));
						Image dimg5 = image5.getScaledInstance(PlayMode.screenSize.width/6,PlayMode.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg5, (int) (PlayMode.screenSize.width/(1.2)), (int) (PlayMode.screenSize.height/(1.6)), null);
						
					}
					
					  
					  
					  
			} catch (IOException e) {
				e.printStackTrace();
			} 
			  
			  

		  }
		  else
		  {
			  try {
					final BufferedImage image1 = ImageIO.read(new File("0.jpg"));
					Image dimg1 = image1.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
					        Image.SCALE_SMOOTH);
					  g.drawImage(dimg1, (int) (PlayMode.screenSize.width/(3.75)), (int) (PlayMode.screenSize.height/(3.25)), null);
					  //hsjhaiskh 
					 
					  
					  final BufferedImage image2 = ImageIO.read(new File("0.jpg"));
						Image dimg2 = image2.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg2, (int) (PlayMode.screenSize.width/(1.5)), (int) (PlayMode.screenSize.height/(3.25)), null);
						  
						  
				} catch (IOException e) {
					e.printStackTrace();
				}   
		  }
	
	}
}

