package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ViewScore2 extends JPanel{
	public static  JLabel view2_base;
	public ViewScore2(){
		//Adding base
		
		view2_base = new JLabel();
		view2_base.setSize(Single_player.screenSize.width, Single_player.screenSize.height);
		view2_base.setIcon(Single_player.imageIcon);
		this.add(view2_base);
		
		
	/*	//Second inning start
		
		final JButton seconstart=new JButton("Continue");

		seconstart.setBounds((int) (Single_player.screenSize.width/(1.16)), Single_player.screenSize.height/60, Single_player.screenSize.width/8, Single_player.screenSize.height/15);
		seconstart.setBorderPainted(true);
		seconstart.setFont(Single_player.fbutton);
		seconstart.setFocusable(false);
		view1_base.add(seconstart);
		seconstart.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	seconstart.setBackground(Color.GREEN);
		    	
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	seconstart.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	
		    		final Play_su2 ps2= new Play_su2();
		    		Single_player.parent.add(ps2,"6");
			    	Single_player.c1.show(Single_player.parent, "6");	
	
		    }
		});  */
		
		
	}

}
