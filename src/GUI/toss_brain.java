package GUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import GUI.toss_su;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
public class toss_brain {
	
	public static String compselect="";
	public static String userselect="";

 public static void toss_handle(JLabel temp){
	   int total=toss_su.compnumber+toss_su.usernumber;
	   
	   //Label for my hand
	   JLabel you=new JLabel(Single_player.myteam);
	   you.setFont(toss_su.finp);
	   you.setForeground(Color.WHITE);
	   you.setBounds((int) (Single_player.screenSize.width/(2)), (int) (Single_player.screenSize.height/(3.5)),(int) (Single_player.screenSize.width), (int) (Single_player.screenSize.height/(2)));
	   temp.add(you);
	   
	   //Label for comp hand
	   JLabel comp=new JLabel(Single_player.oppteam);
	   comp.setFont(toss_su.finp);
	   comp.setForeground(Color.WHITE);
	   comp.setBounds((int) (Single_player.screenSize.width/(1.35)), (int) (Single_player.screenSize.height/(3.5)),(int) (Single_player.screenSize.width), (int) (Single_player.screenSize.height/(2)));
	   temp.add(comp);
	  
	   if((toss_su.oe.equals("odd") &&  total%2!=0) || (toss_su.oe.equals("even") &&  total%2==0) && (!(team_select.difficulty.equals("hard")))){
		   JLabel tosswon=new JLabel("<html>Congrats "+Single_player.myteam+" Have WON The Toss <br> Please Select What you want to do? </html>");
			tosswon.setFont(toss_su.finp);
			tosswon.setForeground(Color.WHITE);
			tosswon.setBounds((int) (Single_player.screenSize.width/(2.7)), (int) (Single_player.screenSize.height/(2.5)),(int) (Single_player.screenSize.width), (int) (Single_player.screenSize.height/(2)));
			temp.add(tosswon);
			
			//Button for bat
			final JButton bowl=new JButton("BOWL");
			final JButton bat=new JButton("BAT");	
			bat.setActionCommand("bat");
			bat.setBounds((int) (Single_player.screenSize.width/(2.7)), (int) (Single_player.screenSize.height/(1.25)), Single_player.screenSize.width/8, Single_player.screenSize.height/15);
			bat.setBorderPainted(true);
			bat.setFont(Single_player.fbutton);
			bat.setFocusable(false);
			temp.add(bat);
			bat.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	if(bat.isEnabled())
			    	{
			    	userselect=bat.getActionCommand();
			    	if(userselect.equals("bat"))
			    		compselect="bowl";
			    	else
			    		compselect="bat";
			    	bat.setBackground(Color.GREEN);
			    	bowl.setEnabled(false);
			    	}
			    }
			});
			//Button for bowl
			bowl.setActionCommand("bowl");
			bowl.setBounds((int) (Single_player.screenSize.width/(1.7)), (int) (Single_player.screenSize.height/(1.25)), Single_player.screenSize.width/8, Single_player.screenSize.height/15);
			bowl.setBorderPainted(true);
			bowl.setFont(Single_player.fbutton);
			bowl.setFocusable(false);
			temp.add(bowl);
			bowl.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	if(bowl.isEnabled())
			    	{
			    	userselect=bowl.getActionCommand();
			    	if(userselect.equals("bat"))
			    		compselect="bowl";
			    	else
			    		compselect="bat";
			    	bowl.setBackground(Color.GREEN);
			    	bat.setEnabled(false);
			    	}
			    }
			});
		   
	   }
	   else{
		   int tempint;
		   Random ra;
		   ra=new Random();
		   tempint=ra.nextInt(2);
		   String disp;
		 
		   if(tempint==0)
		   {
			   disp="<html>OOPS! " +Single_player.myteam + " Have LOST The Toss <br>" + Single_player.oppteam + " Have Elected To BAT</html>";
			   compselect="bat";
			   userselect="bowl";
			   
		   }
		   else{
			   disp="<html>OOPS! " + Single_player.myteam + " Have LOST The Toss <br>" + Single_player.oppteam+ " Have Elected To BOWL</html>";
			   compselect="bowl";
			   userselect="bat";
		   }
			JLabel tosslost=new JLabel(disp);
			tosslost.setFont(toss_su.finp);
			tosslost.setForeground(Color.WHITE);
			tosslost.setBounds((int) (Single_player.screenSize.width/(3)), (int) (Single_player.screenSize.height/(2)),(int) (Single_player.screenSize.width), (int) (Single_player.screenSize.height/(2)));
			
			
			temp.add(tosslost);
	   }
	 
 }
}
