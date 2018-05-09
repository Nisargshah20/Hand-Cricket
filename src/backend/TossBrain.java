package backend;
import GUI.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import GUI.Toss;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;

/**
 * This class handles the toss event at the backend
 */
public class TossBrain {
	/**
	 * Shot selected by Computer
	 */
	public static String compselect="";
	/**
	 * Shot selected by User
	 */
	public static String userselect="";

	/**
	 * Gives result of toss
	 * @param temp A temporary second reference to base JLabel
	 */
 public static void toss_handle(JLabel temp){
	   int total=Toss.compnumber+Toss.usernumber;
	   
	   //Label for my hand
	   JLabel you=new JLabel(PlayMode.myteam);
	   you.setFont(Toss.finp);
	   you.setForeground(Color.WHITE);
	   you.setBounds((int) (PlayMode.screenSize.width/(2)), (int) (PlayMode.screenSize.height/(3.5)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
	   temp.add(you);
	   
	   //Label for comp hand
	   JLabel comp=new JLabel(PlayMode.oppteam);
	   comp.setFont(Toss.finp);
	   comp.setForeground(Color.WHITE);
	   comp.setBounds((int) (PlayMode.screenSize.width/(1.35)), (int) (PlayMode.screenSize.height/(3.5)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
	   temp.add(comp);
	  
	   if((Toss.oe.equals("odd") &&  total%2!=0) || (Toss.oe.equals("even") &&  total%2==0) && (!(TeamSelection.difficulty.equals("hard")))){
		   JLabel tosswon=new JLabel("<html>Congrats "+PlayMode.myteam+" Have WON The Toss <br> Please Select What you want to do? </html>");
			tosswon.setFont(Toss.finp);
			tosswon.setForeground(Color.WHITE);
			tosswon.setBounds((int) (PlayMode.screenSize.width/(2.7)), (int) (PlayMode.screenSize.height/(2.5)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
			temp.add(tosswon);
			
			//Button for bat
			final JButton bowl=new JButton("BOWL");
			final JButton bat=new JButton("BAT");	
			bat.setActionCommand("bat");
			bat.setBounds((int) (PlayMode.screenSize.width/(2.7)), (int) (PlayMode.screenSize.height/(1.25)), PlayMode.screenSize.width/8, PlayMode.screenSize.height/15);
			bat.setBorderPainted(true);
			bat.setFont(PlayMode.fbutton);
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
			bowl.setBounds((int) (PlayMode.screenSize.width/(1.7)), (int) (PlayMode.screenSize.height/(1.25)), PlayMode.screenSize.width/8, PlayMode.screenSize.height/15);
			bowl.setBorderPainted(true);
			bowl.setFont(PlayMode.fbutton);
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
			   disp="<html>OOPS! " +PlayMode.myteam + " Have LOST The Toss <br>" + PlayMode.oppteam + " Have Elected To BAT</html>";
			   compselect="bat";
			   userselect="bowl";
			   
		   }
		   else{
			   disp="<html>OOPS! " + PlayMode.myteam + " Have LOST The Toss <br>" + PlayMode.oppteam+ " Have Elected To BOWL</html>";
			   compselect="bowl";
			   userselect="bat";
		   }
			JLabel tosslost=new JLabel(disp);
			tosslost.setFont(Toss.finp);
			tosslost.setForeground(Color.WHITE);
			tosslost.setBounds((int) (PlayMode.screenSize.width/(3)), (int) (PlayMode.screenSize.height/(2)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
			
			
			temp.add(tosslost);
	   }
	 
 }
}
