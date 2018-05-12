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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
/**
 *
 * This class generates JPanel for first inning.
 * JPanel with score board and different buttons for game play.
 */
//
public class PlayArena1 extends JPanel{
	public static int usershot;
	public static int compshot;
	public static JLabel reference;
	public static Random ra =new Random();

	public static String ComOne[]={"<html>Sweeps it to long <br>leg for a single</html>","<html>Pushed through covers <br> for a single</html>","<html>One run,<br> Came down the track and <br> driven down to <br> sweeper cover</html>","<html>One run,<br> Slaps it through cover point</html>"};
	public static String ComWic[]={"<html>Bowled! <br>Misses a clean Yorker!</html>",
									"<html>LBW!<br>Missed the ball, and <br>hits him on the pads</html>",
									"<html>Stumped!<br>Clever work from<br>Wicket-Keeper</html>",
									"<html>Caught!<br>Can't clear the fielder there!</html>"};
	public static String ComTwo[]={"<html>Two runs,<br>Short ball,punched through<br>extra-cover</html>",
									"<html>Two runs,<br>works it to<br>short fine leg</html>",
									"<html>Two runs,<br>slashed into the gap <br>at deep Extra-cover</html>",
									"<html>Two runs,<br>gets a thick edge<br>that flies slip fielder</html>"};
	public static String ComFour[]={"<html>Four Runs,cuts it away<br>over backwardpoint</html>",
									"<html>Four Runs,short ball<br>pulls it off backfoot</html>",
									"<html>Four Runs,full & wide<br>driven through covers for <br> a boundary</html>",
									"<html>Four Runs,oh the power!<br>Brute</html>"};
	public static String ComThree[]={"<html>Three runs,<br>misfield from fielder there</html>",
									"<html>Three runs,<br>overthrows! and<br>batsman reacted quockly!</html>",
									"<html>Three runs,<br>almost squeezing out <br>a boundary</html>",
									"<html>Three runs,<br>good running <br>between wickets!</html>"};
	public static String ComSix[]={"<html>Six Runs,<br>that's a <br>MONSTER hit!</html>",
									"<html>Six Runs,<br>drags it down half way<br>snatches the over</html>",
									"<html>Six Runs,<br>lofts it over extra-cover<br>on the ropes</html>",
									"<html>Six Runs,<br>hook over fine leg</html>"};
	public static Font fsc=new Font("Comic Sans MS",Font.BOLD,100);
	public static  JLabel play_base;
	/**
	 * update_score is a second reference of score fro updation.
	 */
	public static JLabel update_score;
	public static JLabel update_runrate;
	/**
	 * update_overs is a second reference of overs for updation.
	 */
	public static JLabel update_overs;
	public static JLabel update_comments;
	public static JLabel update_strikes;
	/**
	 * hardshots is an array for computer generated number in hard mode.
	 */
	public static int[] hardshots={1,2,3};
	/**
	 * playerescores contains score of players with their names.
	 */
	public static String[][] playerscores1=new String[4][2];
	public static String[][] playerscores2=new String[4][2];
	public static String[] myteam= (String[]) TeamSelection.mysquadsel.toArray(new String[0]);
	public static String[] oppteam=(String[]) TeamSelection.oppsquadsel.toArray(new String[0]);
	public static String temp[] = null;
	public static  JButton viewscore1;
	public final JButton one=new JButton("1");
	public final JButton two=new JButton("2");
	public final JButton three=new JButton("3");
	public final JButton four=new JButton("4");
	public final JButton six=new JButton("6");

		public PlayArena1(){
		//Button for viewscorecard
		viewscore1=new JButton("View Scorecard>>>");
		viewscore1.setBounds((int) (PlayMode.screenSize.width/(1.275)), (int) (PlayMode.screenSize.height/(2.5)), PlayMode.screenSize.width/4, PlayMode.screenSize.height/15);
		viewscore1.setBorderPainted(true);
		viewscore1.setFont(PlayMode.fbutton);
		viewscore1.setFocusable(false);
		viewscore1.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 viewscore1.setBackground(Color.GREEN);

			    }
			 public void mouseExited(java.awt.event.MouseEvent evt) {
				 viewscore1.setBackground(UIManager.getColor("control"));
			    }
			 /**
			 * method for activating new card
			 */
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    		final ViewScore1 vs= new ViewScore1();
	    		PlayMode.parent.add(vs,"5");
		    	PlayMode.c1.show(PlayMode.parent, "5");
		    }
		});

		//Intializing MultiDimensional Array for scorecard

		for(int x=0;x<4;x++){
			playerscores1[x][0]=myteam[x];
			playerscores1[x][1]="0";
			playerscores2[x][0]=oppteam[x];
			playerscores2[x][1]="0";
		}



		//System.out.print(TeamSelection.mysquadsel);
		play_base = new JLabel();
		play_base.setSize(PlayMode.screenSize.width, PlayMode.screenSize.height);

		play_base.setIcon(PlayMode.imageIcon);
		this.add(play_base);
		reference=play_base;




		//Team Display


				//My Team
				final JButton my_team=new JButton(PlayMode.myteam);

				my_team.setBounds(0, PlayMode.screenSize.height/60, PlayMode.screenSize.width/3, PlayMode.screenSize.height/10);
				my_team.setBorderPainted(true);
				my_team.setFont(PlayMode.fbutton);
				my_team.setFocusable(false);
				play_base.add(my_team);

				//Opposition Team
				final JButton opp_team=new JButton(PlayMode.oppteam);
				opp_team.setBounds((int) (PlayMode.screenSize.width/(1.46)), PlayMode.screenSize.height/60, PlayMode.screenSize.width/3, PlayMode.screenSize.height/10);
				opp_team.setBorderPainted(true);
				opp_team.setFont(PlayMode.fbutton);
				opp_team.setFocusable(false);
				play_base.add(opp_team);


			//Batting Bowling
				//Myteam  Panel
				JLabel myteam_what=new JLabel(TossBrain.userselect.toUpperCase(),SwingConstants.CENTER);
				myteam_what.setFont(PlayMode.fhead);
				myteam_what.setForeground(Color.WHITE);
				myteam_what.setBounds(0, (int) (PlayMode.screenSize.height/(8.7)), PlayMode.screenSize.width/4, (int) (PlayMode.screenSize.height/(15)));
				javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
				myteam_what.setBorder(border);
				play_base.add(myteam_what);

				//Opp Panel
				JLabel oppteam_what=new JLabel(TossBrain.compselect.toUpperCase(),SwingConstants.CENTER);
				oppteam_what.setFont(PlayMode.fhead);
				oppteam_what.setForeground(Color.WHITE);
				oppteam_what.setBounds((int) (PlayMode.screenSize.width/(1.30)), (int) (PlayMode.screenSize.height/(8.7)), PlayMode.screenSize.width/4, (int) (PlayMode.screenSize.height/(15)));
				oppteam_what.setBorder(border);
				play_base.add(oppteam_what);
		//Scorecard
				JLabel score_head=new JLabel("SCORE",SwingConstants.CENTER);
				score_head.setFont(PlayMode.fbutton);
				score_head.setForeground(Color.WHITE);
				score_head.setBounds((int) (PlayMode.screenSize.width/(2.8)), (int) (PlayMode.screenSize.height/(59)), PlayMode.screenSize.width/5, PlayMode.screenSize.height/20);
				score_head.setBorder(border);
				play_base.add(score_head);

				//Numeric score1
				JLabel score=new JLabel("0/0",SwingConstants.CENTER);
				update_score=score;
				score.setFont(fsc);
				score.setForeground(Color.WHITE);
				score.setBounds((int) (PlayMode.screenSize.width/(2.8)), (int) (PlayMode.screenSize.height/(15)), PlayMode.screenSize.width/5, PlayMode.screenSize.height/15);
				score.setBorder(border);
				play_base.add(score);

				//Overs
				JLabel overs=new JLabel("<html>Overs : 0.0 ("+PlayMode.overs+")</html>",SwingConstants.CENTER);
				update_overs=overs;
				overs.setFont(PlayMode.fbutton);
				overs.setForeground(Color.WHITE);
				overs.setBounds((int) (PlayMode.screenSize.width/(2.8)), (int) (PlayMode.screenSize.height/(7.5)), PlayMode.screenSize.width/5, PlayMode.screenSize.height/20);
				overs.setBorder(border);
				play_base.add(overs);

				//runrate1
				JLabel runrate=new JLabel("<html>Run<br>Rate:<br>0.0</html>",SwingConstants.CENTER);
				update_runrate=runrate;
				runrate.setFont(PlayMode.fbutton);
				runrate.setForeground(Color.WHITE);
				runrate.setBounds((int) (PlayMode.screenSize.width/(2.8)+PlayMode.screenSize.width/5), (int) (PlayMode.screenSize.height/(59)), PlayMode.screenSize.width/10, PlayMode.screenSize.height/6);
				runrate.setBorder(border);
				play_base.add(runrate);


				//Label For Strikes
				JLabel strikes=new JLabel("");
				strikes.setFont(PlayMode.fstrike);
				strikes.setForeground(Color.YELLOW);
				strikes.setBounds((int) (PlayMode.screenSize.width/(80)), (int) (PlayMode.screenSize.height/(11)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
				update_strikes=strikes;
				play_base.add(strikes);



				//Label For Comments
				JLabel comm=new JLabel("");
				comm.setFont(Toss.finp);
				comm.setForeground(Color.WHITE);
				comm.setBounds((int) (PlayMode.screenSize.width/(100)), (int) (PlayMode.screenSize.height/(2.45)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
				update_comments=comm;
				play_base.add(comm);

		//Playing buttons

				//Buttons defiinition

				//1 Button
				one.setActionCommand("1");
				one.setBounds((int) (PlayMode.screenSize.width/(2.8)), PlayMode.screenSize.height/50+(int) (PlayMode.screenSize.height/(1.55)), PlayMode.screenSize.width/15, PlayMode.screenSize.height/10);
				one.setBorderPainted(true);
				one.setFont(PlayMode.fbutton);
				one.setFocusable(false);
				play_base.add(one);

				one.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	one.setBackground(Color.green);

				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	one.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain1.if_first_inning_over)){
				    	usershot=Integer.parseInt(one.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
				    	compshot=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{
				    		if(TossBrain.userselect.equals("bat"))
				    		compshot=hardshots[ra.nextInt(3)];
				    		else
				    			compshot=Toss.randnumbers[ra.nextInt(5)];
				    	}
				    	PlayBrain1 pb =new PlayBrain1(update_score,update_overs, update_runrate,reference,update_comments,update_strikes);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					    	repaint();
					    	pb=null;

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
				play_base.add(two);
				two.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	two.setBackground(Color.green);

				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	two.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {

				    	if(!(PlayBrain1.if_first_inning_over)){
				    	usershot=Integer.parseInt(two.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
					    	compshot=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{
				    		if(TossBrain.userselect.equals("bat"))
				    		compshot=hardshots[ra.nextInt(3)];
				    		else
				    			compshot=Toss.randnumbers[ra.nextInt(5)];
				    	}
				    	PlayBrain1 pb =new PlayBrain1(update_score,update_overs, update_runrate,reference,update_comments,update_strikes);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;
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
				play_base.add(three);
				three.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	three.setBackground(Color.green);

				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	three.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain1.if_first_inning_over)){
				    	usershot=Integer.parseInt(three.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
					    	compshot=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{
				    		if(TossBrain.userselect.equals("bat"))
				    		compshot=hardshots[ra.nextInt(3)];
				    		else
				    			compshot=Toss.randnumbers[ra.nextInt(5)];
				    	}
				    	PlayBrain1 pb =new PlayBrain1(update_score,update_overs, update_runrate,reference,update_comments,update_strikes);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;}
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
				play_base.add(four);
				four.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	four.setBackground(Color.green);

				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	four.setBackground(UIManager.getColor("control"));
				    }
				    /**
					 * mouse clicked method for taking user and computer inputs
					 */
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain1.if_first_inning_over)){
				    	usershot=Integer.parseInt(four.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy")){
					    	compshot=Toss.randnumbers[ra.nextInt(5)];}
				    	else
				    	{
				    		if(TossBrain.userselect.equals("bat"))
				    		compshot=hardshots[ra.nextInt(3)];
				    		else
				    			compshot=Toss.randnumbers[ra.nextInt(5)];
				    	}

				    	PlayBrain1 pb =new PlayBrain1(update_score,update_overs, update_runrate,reference,update_comments,update_strikes);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;
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
				play_base.add(six);
				six.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	six.setBackground(Color.green);
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	six.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(PlayBrain1.if_first_inning_over)){
				    	usershot=Integer.parseInt(six.getActionCommand());
				    	if(TeamSelection.difficulty.equals("easy") ){
					    	compshot=Toss.randnumbers[ra.nextInt(5)];}
					    	else
					    	{
					    		if(TossBrain.userselect.equals("bat"))
					    		compshot=hardshots[ra.nextInt(3)];
					    		else
					    			compshot=Toss.randnumbers[ra.nextInt(5)];
					    	}
				    	PlayBrain1 pb =new PlayBrain1(update_score,update_overs, update_runrate,reference,update_comments,update_strikes);

				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;
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
	/**
	 * method for drawing images on the child
	 */
	public  void paintChildren(Graphics g) {
		 super.paintChildren(g);
		  if(!(usershot==0))
		  {
			  try {
				  //Images For hand1


				  final BufferedImage image1 = ImageIO.read(new File(usershot+".jpg"));
				  	Image dimg1 = image1.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
				        Image.SCALE_SMOOTH);
				  		g.drawImage(dimg1, (int) (PlayMode.screenSize.width/(3.75)), (int) (PlayMode.screenSize.height/(3.25)), null);

				  	//Images For hand2
				  final BufferedImage image2;
				  if(PlayBrain1.check_if_wicket){
					  	image2 = ImageIO.read(new File(usershot+".jpg"));
					  	}
				  else{
					  image2 = ImageIO.read(new File(compshot+".jpg"));
				  	}
					Image dimg2 = image2.getScaledInstance(PlayMode.screenSize.width/10,PlayMode.screenSize.height/(4),
					        Image.SCALE_SMOOTH);
					  g.drawImage(dimg2, (int) (PlayMode.screenSize.width/(1.52)), (int) (PlayMode.screenSize.height/(3.25)), null);

					  //Image for umpire wicket
					if(PlayBrain1.check_if_wicket){
						final BufferedImage image3 = ImageIO.read(new File("out.jpg"));
						Image dimg3 = image3.getScaledInstance(PlayMode.screenSize.width/6,PlayMode.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg3, (int) (PlayMode.screenSize.width/(1.2)), (int) (PlayMode.screenSize.height/(1.6)), null);

					}

					//Image for umpire four
					if((!(PlayBrain1.check_if_wicket)) && (PlayBrain1.tempshot==4)){
						final BufferedImage image3 = ImageIO.read(new File("four.jpeg"));
						Image dimg3 = image3.getScaledInstance(PlayMode.screenSize.width/6,PlayMode.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg3, (int) (PlayMode.screenSize.width/(1.2)), (int) (PlayMode.screenSize.height/(1.6)), null);

					}
					//Image for umpire six
					if((!(PlayBrain1.check_if_wicket)) && ( PlayBrain1.tempshot==6)){
						final BufferedImage image3 = ImageIO.read(new File("six.jpg"));
						Image dimg3 = image3.getScaledInstance(PlayMode.screenSize.width/6,PlayMode.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg3, (int) (PlayMode.screenSize.width/(1.2)), (int) (PlayMode.screenSize.height/(1.6)), null);

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
