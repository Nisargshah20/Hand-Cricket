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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Statistic {

	public static void main(String s[]){
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
		new Single_player();}
	});
	}
	public Statistic(){
		 final JFrame stat=new JFrame("Statistics");
	        stat.setSize(1800,1800);
	    	stat.setVisible(true);
	    	stat.setLocation(1400,100);
	    	ImageIcon img = new ImageIcon(HomeLayout.icon);
	    	stat.setIconImage(img.getImage());
	    	Font fhead=new Font("Algerian",Font.BOLD,154);
	    	Font fbutton=new Font("Comic Sans MS",Font.BOLD,54);
	    	try{
	    		stat.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(HomeLayout.back_grnd)))));
	    		
	    		}
	    		catch(Exception e){
	    			System.out.println("Error : "+e.getMessage());
	    		}
		//Button for back
			final JButton back_st=new JButton("Back");
			back_st.setActionCommand("back_su");
			back_st.setBounds(150, 90, 300, 110);
			back_st.setBorderPainted(true);
			back_st.setFont(fbutton);
			back_st.setFocusable(false);
			stat.add(back_st);
			back_st.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	back_st.setBackground(Color.lightGray);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	back_st.setBackground(UIManager.getColor("control"));
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			     	new HomeLayout();
			     	stat.setVisible(false);
			     	stat.dispose(); 
			    }
			});
		stat.setResizable(false);
	}

}