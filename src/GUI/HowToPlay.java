public package GUI;
import GUI.HomeLayout;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import backend.*;
public class HowToPlay extends JPanel{

	public static  JLabel howto_base;
	public HowToPlay(){
		howto_base = new JLabel();
		howto_base.setSize(PlayMode.screenSize.width, PlayMode.screenSize.height);
		howto_base.setIcon(PlayMode.imageIcon);
		this.add(howto_base);

		//Button for Begining
			final JButton begin=new JButton("Let's Go");
			begin.setBounds((int) (PlayMode.screenSize.width/(2)),(int) (PlayMode.screenSize.height/(1.2)),(int) (PlayMode.screenSize.width/6), PlayMode.screenSize.height/10);
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