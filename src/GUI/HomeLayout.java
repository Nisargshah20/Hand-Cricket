public package GUI;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;


public class HomeLayout  {

public static void main(String s[]){
	SwingUtilities.invokeLater(new Runnable(){
	public void run(){
	new HomeLayout();
	}
});
}
public static String icon = "icon_img.png";
public static String back_grnd="back_grnd3.jpg";
public HomeLayout(){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final JFrame Home=new JFrame("Hand Cricket Java");
	Font fmotto=new Font("Comic Sans MS",Font.BOLD,130);
	Font fhead=new Font("Algerian",Font.BOLD,250);
	Font fbutton=new Font("Comic Sans MS",Font.BOLD,84);
	 JLabel Homebase;
	Color c=new Color(211,211,211);
	System.out.print(screenSize.width);
	Home.setSize(screenSize.width, screenSize.height);
	Home.setVisible(true);
	Home.setLocation(0,0);
	Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ImageIcon img = new ImageIcon(icon);
	Home.setIconImage(img.getImage());
	
	//Background as Jlabel
	
			Homebase = new JLabel();
			Homebase.setSize(screenSize.width, screenSize.height);
			BufferedImage imag = null;
			try {
			    imag = ImageIO.read(new File(back_grnd));
			} catch (IOException e) {
			}
			Image dimg = imag.getScaledInstance(Homebase.getWidth(), Homebase.getHeight(),
			        Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			Homebase.setIcon(imageIcon);
			Home.add(Homebase);
	Home.setResizable(false);

	//Label for heading
	JLabel gname=new JLabel("HAND CRICKET");
	gname.setFont(fhead);
	gname.setBounds(screenSize.width/4, screenSize.height/80, screenSize.width/2, screenSize.height/10);
	Homebase.add(gname);
	//Label for motto
	JLabel gmotto=new JLabel("\"Get Nostalgic\"");
	gmotto.setFont(fmotto);
	gmotto.setBounds(screenSize.width/2, screenSize.height/10, screenSize.width/2, screenSize.height/10);
	Homebase.add(gmotto);
	
	
	//Button for single player
	final JButton single_user=new JButton("Single Player Mode");
	single_user.setActionCommand("single_user");
	single_user.setBounds((int) (screenSize.width/(2.5)),screenSize.height/4,(int) (screenSize.width/3), screenSize.height/10);
	single_user.setBorderPainted(true);
	single_user.setFont(fbutton);
	single_user.setFocusable(false);
	Homebase.add(single_user);
	single_user.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	        single_user.setBackground(Color.lightGray);
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	        single_user.setBackground(UIManager.getColor("control"));
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	     	new Single_player();
	     	Single_player.makeList1();
	     	Single_player.makeList2();
	     	Home.setVisible(false); 
	     	Home.dispose();
	     	
	    }
	});
	
	//Button for multi-player
	final JButton multi_user=new JButton("Multi-Player Player Mode");
	multi_user.setActionCommand("multi_user");
	multi_user.setBounds((int) (screenSize.width/(2.5)),(int) (screenSize.height/(2.5)),(int) (screenSize.width/3), screenSize.height/10);
	multi_user.setBorderPainted(true);
	multi_user.setFont(fbutton);
	multi_user.setFocusable(false);
	Homebase.add(multi_user);
	multi_user.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	        multi_user.setBackground(Color.lightGray);
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	        multi_user.setBackground(UIManager.getColor("control"));
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	  	  
	    }
	});
	//button for stats
	final JButton stat=new JButton("View Statistics");
	stat.setActionCommand("stat");
	stat.setBounds((int) (screenSize.width/(2.5)),(int) (screenSize.height/(1.82)),(int) (screenSize.width/3), screenSize.height/10);
	stat.setBorderPainted(true);
	stat.setFont(fbutton);
	stat.setFocusable(true);
	stat.setFocusable(false);
	Homebase.add(stat);
	stat.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	       stat.setBackground(Color.lightGray);
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	        stat.setBackground(UIManager.getColor("control"));
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	new Statistic();
	    	Home.setVisible(false);
	    	Home.dispose();
	    }
	});
	//Button for exit
	final JButton end=new JButton("Exit");
	end.setActionCommand("end");
	end.setBounds((int) (screenSize.width/(2.5)),(int) (screenSize.height/(1.42)),(int) (screenSize.width/3), screenSize.height/10);
	end.setBorderPainted(true);
	end.setFont(fbutton);
	end.setFocusable(false);
	Homebase.add(end);
	end.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	      end.setBackground(Color.lightGray);
	    }
	    public void mouseExited(java.awt.event.MouseEvent evt) {
	        end.setBackground(UIManager.getColor("control"));
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	  
	    	  int a=JOptionPane.showConfirmDialog(Home,"Are you sure you want to exit?");  
	    	  if(a==JOptionPane.YES_OPTION){  
	    	      System.exit(0);
	    	  }
	    }
	});
}
}