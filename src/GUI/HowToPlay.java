package GUI;
import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *Class HowToPlay extends JPanel , is a 8 member of card layout on parent
 *It shows the rules and how to' of playing hand cricket.
 *Once finished game could be begun.
 */
public class HowToPlay extends JPanel{

	public static  JLabel howto_base;  
	Font fdesc=new Font("Comic Sans MS",Font.BOLD,PlayMode.screenSize.width/59);
	/**
	 * Generates a GUI for rules on how to play
	 */
	public HowToPlay(){
		howto_base = new JLabel();
		howto_base.setSize(PlayMode.screenSize.width, PlayMode.screenSize.height);
		howto_base.setIcon(PlayMode.imageIcon);
		this.add(howto_base);
		
		//Label For Instructions
		JLabel htp=new JLabel("<html>1)Select your team, opponents' team and<br> number of overs -->click next <br><br> 2) Select your squad of 4 members among 5  available players  for your team<br> and also for opponent.Select the Difficulty level-->click play"
				+ "<br><br>3)Type a number in text box for toss and select odd or even,<br>once toss is over begin the game!"
				+ "<br><br>4)If batting you can score 1/2/3/4/6 selecting appropriate shots from buuttons.<br>If computer generates same number as you, you are declared out."
				+ "<br><br>5)Each inning has three wickets. Strike change would occur at over end <br>if even number of runs or for odd number of runs.<br>"
				+ "<br>6) After completion of first innings view scorecard would appear <br>which show scorecard of first innings."
				+ "<br><br>7)After that second innings will begin where you would have to either chase or defend a target."
				+ "<br><br>8)Final scorecard is available at end of second inning and<br> also who won the match."
				
				+ "</html>");
		htp.setFont(fdesc);
		htp.setForeground(Color.WHITE);
		htp.setBounds(10, 0,(int) (PlayMode.screenSize.width),  PlayMode.screenSize.height);

		howto_base.add(htp);
		

		//Button for Begining
			final JButton begin=new JButton("Let's Go");
			begin.setBounds((int) (PlayMode.screenSize.width/(1.45)), (int) (PlayMode.screenSize.height/(2.5)), (int) (PlayMode.screenSize.width/3.5), PlayMode.screenSize.height/10);
			begin.setBorderPainted(true);
			begin.setFont(PlayMode.fbutton);
			begin.setFocusable(false);
			howto_base.add(begin);
			begin.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	begin.setBackground(Color.lightGray);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	begin.setBackground(UIManager.getColor("control"));
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	PlayMode.c1.show(PlayMode.parent, "1");			    }
			});
	}

}