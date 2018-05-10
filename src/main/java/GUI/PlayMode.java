package GUI;
import  GUI.HomeLayout;
import GUI.TeamSelection;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import javafx.scene.layout.Border;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * Generates new Frame for selecting teams and overs.
 */
public class PlayMode{
	/**
	 * overs string for number of overs 
	 */
	public static String overs="";
	/**
	 * myteam has user selected team
	 */
	public static String myteam="";
	/**
	 * oppteam has computer team
	 */
	public static String oppteam="";
	public static String teams_db[]={"India","Australia","SouthAfrica","Pakistan","England","WestIndies","Newzealand","SriLanka"};
	public static JLabel base;
	public static DefaultListModel teams=new DefaultListModel();
public static  ImageIcon imageIcon;
	public static void main(String s[]){
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
		new PlayMode();
		makeList1();
		makeList2();
		}
	});
	}
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * CardLayout refrence to be used on panel
	 */
	final static CardLayout c1=new CardLayout();
	/**
	 * parent panel on frame which contains card layout
	 */
	final static JPanel parent = new JPanel();
	public static Font fvs=new Font("Comic Sans MS",Font.BOLD,screenSize.width/26);
	public static Font fstrike=new Font("Comic Sans MS",Font.BOLD,screenSize.width/38);	
	public static Font fhead=new Font("Georgia",Font.BOLD,screenSize.width/36);
	public static Font fmotto=new Font("Comic Sans MS",Font.BOLD,screenSize.width/71);
	public static Font fbutton=new Font("Comic Sans MS",Font.BOLD,screenSize.width/46);
	public static Font flabel=new Font("Georgia",Font.BOLD,screenSize.width/51);
	public static Font flist=new Font("Comic Sans MS",Font.BOLD,screenSize.width/26);
	public static Font fsmalllabel=new Font("Comic Sans MS",Font.BOLD,screenSize.width/64);
	public static Color clist;
	/**
	 * Generates a GUI for teams and over selection
	 */
		public PlayMode(){
			
		final JFrame Single_playerframe=new JFrame("Hand Cricket Java");
		//Frame Set
		
		Color c=new Color(211,211,211);
		Single_playerframe.setSize(screenSize.width, screenSize.height);;
		Single_playerframe.setVisible(true);
		Single_playerframe.setLocation(0,0);
		Single_playerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(HomeLayout.icon);
		Single_playerframe.setIconImage(img.getImage());
		Single_playerframe.setResizable(false);
		//parent panel
		
		Single_playerframe.add(parent);
		
		
		
		//Background as Jlabel
		
		base = new JLabel();
		base.setSize(screenSize.width, screenSize.height);
		BufferedImage imag = null;
		try {
		    imag = ImageIO.read(new File(HomeLayout.back_grnd));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = imag.getScaledInstance(base.getWidth(),base.getHeight(),
		        Image.SCALE_SMOOTH);
		 imageIcon = new ImageIcon(dimg);
		base.setIcon(imageIcon);
		//main panel
				final JPanel main_su = new JPanel();
				
				
				
				
				

				//Card Layout 
				
				parent.setLayout(c1);
				parent.add(main_su,"1");
				
				
				

				
				c1.show(parent, "1");
		main_su.add(base);
		//
		
		//Button for back
		final  JButton back_su=new JButton("Back");	
		back_su.setActionCommand("back_su");
		back_su.setBounds(screenSize.width/80, screenSize.height/60, screenSize.width/8, screenSize.height/15);
		back_su.setBorderPainted(true);
		back_su.setFont(fbutton);
		back_su.setFocusable(false);
		base.add(back_su);
		back_su.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	back_su.setBackground(Color.lightGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	back_su.setBackground(UIManager.getColor("control"));
		    	clist=UIManager.getColor("control");
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		     	new HomeLayout();
		     	Single_playerframe.setVisible(false);
		     	Single_playerframe.dispose();
		     	 
		    }
		});
	
	//Button for next
	final JButton next_su=new JButton("Next");
	next_su.setActionCommand("next_su");
	next_su.setBounds((int) (screenSize.width/(1.16)), screenSize.height/60, screenSize.width/8, screenSize.height/15);
	next_su.setBorderPainted(true);
	next_su.setFont(fbutton);
	next_su.setFocusable(false);
	base.add(next_su);
	next_su.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	    	next_su.setBackground(Color.lightGray);
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	    	next_su.setBackground(UIManager.getColor("control"));
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	if(myteam.equals(oppteam) || myteam.equals("") || oppteam.equals(""))
	    	{
	    		JOptionPane.showMessageDialog(main_su, "Please Select two different teams", "Warning",
	    		        JOptionPane.WARNING_MESSAGE);	
	    	}
	    	else if(overs.equals(""))
	    	{
	    		JOptionPane.showMessageDialog(main_su, "Please Select overs from format", "Overs not selected",
	    		        JOptionPane.WARNING_MESSAGE);}
	    	
	    	else {
	    	//team select panel
			final TeamSelection ts = new TeamSelection();
			parent.add(ts,"2");
	     	c1.show(parent,"2");
	    	}
	    }
	});
	
	//Overs Panel
	JLabel over_head=new JLabel(" FORMAT ", SwingConstants.CENTER);
	over_head.setFont(fhead);
	over_head.setForeground(Color.WHITE);
	over_head.setBounds(0, (int) (screenSize.height/(3.5)), screenSize.width/4, (int) (screenSize.height/(15)));
	javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
	over_head.setBorder(border);
	base.add(over_head);
	final JButton overs_2=new JButton("2 Overs");
	final JButton overs_3=new JButton("3 Overs");
	final JButton overs_5=new JButton("5 Overs");
	overs_2.setActionCommand("2");
	overs_2.setBounds(0, (int) (screenSize.height/(2.55)), (int) (screenSize.width/(4.5)), (int) (screenSize.height/(15)));
	overs_2.setBorderPainted(true);
	overs_2.setFont(fbutton);
	overs_2.setFocusable(false);
	base.add(overs_2);
	overs_2.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	    	
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    
	    	overs=overs_2.getActionCommand();
	    	overs_2.setBackground(Color.GREEN);
	    	overs_3.setBackground(UIManager.getColor("control"));
	    	overs_5.setBackground(UIManager.getColor("control"));
	    }
	});
	//3 overs
	overs_3.setActionCommand("3");
	overs_3.setBounds(0, (int) (screenSize.height/(1.95)), (int) (screenSize.width/(4.5)), (int) (screenSize.height/(15)));
	overs_3.setBorderPainted(true);
	overs_3.setFont(fbutton);
	overs_3.setFocusable(false);
	base.add(overs_3);
	overs_3.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	
	    	overs=overs_3.getActionCommand();
	    	overs_3.setBackground(Color.GREEN);
	    	overs_2.setBackground(UIManager.getColor("control"));
	    	overs_5.setBackground(UIManager.getColor("control"));
	    }
	});
	//5 Overs
	overs_5.setActionCommand("5");
	overs_5.setBounds(0, (int) (screenSize.height/(1.57)), (int) (screenSize.width/(4.5)), (int) (screenSize.height/(15)));
	overs_5.setBorderPainted(true);
	overs_5.setFont(fbutton);
	overs_5.setFocusable(false);
	base.add(overs_5);
	overs_5.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	
	    	overs=overs_5.getActionCommand();
	    	overs_5.setBackground(Color.GREEN);
	    	overs_2.setBackground(UIManager.getColor("control"));
	    	overs_3.setBackground(UIManager.getColor("control"));
	    }
	});
	//Teams 
	JLabel team_head=new JLabel("--TEAMS--", SwingConstants.CENTER);
	team_head.setFont(fhead);
	team_head.setForeground(Color.WHITE);
	team_head.setBounds((int) (screenSize.width/(1.96)), (int) (screenSize.height/(5)), screenSize.width/4, (int) (screenSize.height/(15)));
		team_head.setBorder(border);
	base.add(team_head);

	
	//Label For my_team
		JLabel my_team=new JLabel("MY TEAM", SwingConstants.CENTER);
		my_team.setFont(flabel);
		my_team.setForeground(Color.WHITE);
		my_team.setBounds((int) (screenSize.width/(2.75)), (int) (screenSize.height/(3)), screenSize.width/6, (int) (screenSize.height/(20)));
		my_team.setBorder(border);
		base.add(my_team);
		
		//Jlabel for v/s
		JLabel vs=new JLabel(" V/S ", SwingConstants.CENTER);
		vs.setFont(fvs);
		vs.setForeground(Color.WHITE);
		vs.setBounds((int) (screenSize.width/(1.77)), (int) (screenSize.height/(1.9)), screenSize.width/8, (int) (screenSize.height/(15)));
		base.add(vs);
		
		//Label For OPP_team
		JLabel opp_team=new JLabel("OPPONENT", SwingConstants.CENTER);
		opp_team.setFont(flabel);
		opp_team.setForeground(Color.WHITE);
		opp_team.setBounds((int) (screenSize.width/(1.37)), (int) (screenSize.height/(3)), screenSize.width/6, (int) (screenSize.height/(20)));
		opp_team.setBorder(border);
		base.add(opp_team);
	}

/**
 * Method to generate first list for selection of user team		
 */
		public static void makeList1(){
			//List For Teams selection
			final JList my_list_teams;
			JScrollPane scroller;
			for(String team : teams_db){
				
				teams.addElement(team);
			}
			
			my_list_teams=new JList(teams);
			my_list_teams.setFixedCellHeight((int) (screenSize.height/(17)));
			my_list_teams.setFixedCellWidth((int) (screenSize.width/(2.75)));
			my_list_teams.setSelectionBackground(Color.LIGHT_GRAY);
			my_list_teams.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scroller=new JScrollPane(my_list_teams);
			my_list_teams.setFont(flabel);
			my_list_teams.setBounds((int) (screenSize.width/(2.75)), (int) (screenSize.height/(2.43)), screenSize.width/6, (int) (screenSize.height/(2.15)));
			my_list_teams.setBackground(clist);
			base.add(my_list_teams);
			
			my_list_teams.addListSelectionListener(new ListSelectionListener(){
				
				public void valueChanged(ListSelectionEvent le) {
					myteam=(String) my_list_teams.getSelectedValue();									}				
			});
		}
			
			//List2
		/**
		 * Method to generate second list for selection of opponent team		
		 */		
		public static void makeList2(){
			final JList opp_list_teams;
			opp_list_teams=new JList(teams);
			opp_list_teams.setFixedCellHeight(screenSize.height/(17));
			opp_list_teams.setFixedCellWidth((int) (screenSize.width/(2.75)));
			opp_list_teams.setSelectionBackground(Color.LIGHT_GRAY);
			opp_list_teams.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			opp_list_teams.setFont(flabel);
			opp_list_teams.setBounds((int) (screenSize.width/(1.37)), (int) (screenSize.height/(2.43)), screenSize.width/6, (int) (screenSize.height/(2.15)));
			opp_list_teams.setBackground(clist);
			base.add(opp_list_teams);
			opp_list_teams.addListSelectionListener(new ListSelectionListener(){
				
				public void valueChanged(ListSelectionEvent le) {
					oppteam=(String) opp_list_teams.getSelectedValue();
				}
				
			});
		}
		
		
}