public package GUI;
import  GUI.HomeLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import GUI.HomeLayout;
import GUI.Single_player;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class team_select extends JPanel{
	public static void main(String s[]){
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
		new team_select();}
	});
	}
	public static String difficulty="";
	static DefaultListModel myplayers=new DefaultListModel();
	static DefaultListModel oppplayers=new DefaultListModel();
	public static JLabel base1;
	public static List mysquadsel;
	public static List oppsquadsel;
	public team_select(){
		base1 = new JLabel();
		base1.setSize(Single_player.screenSize.width, Single_player.screenSize.height);
		
		base1.setIcon(Single_player.imageIcon);
		this.add(base1);
	
	//Button for back
	final JButton back_su=new JButton("Back");	
	back_su.setActionCommand("back_su");
	back_su.setBounds(Single_player.screenSize.width/80, Single_player.screenSize.height/60, Single_player.screenSize.width/8, Single_player.screenSize.height/15);
	back_su.setBorderPainted(true);
	back_su.setFont(Single_player.fbutton);
	back_su.setFocusable(false);
	base1.add(back_su);
	back_su.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	    	back_su.setBackground(Color.lightGray);
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	    	back_su.setBackground(UIManager.getColor("control"));
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	 Single_player.c1.show(Single_player.parent, "1");
	    }
	});
//Button for play
final JButton next_su=new JButton("Play");
next_su.setActionCommand("play_su");
next_su.setBounds((int) (Single_player.screenSize.width/(1.16)), Single_player.screenSize.height/60, Single_player.screenSize.width/8, Single_player.screenSize.height/15);
next_su.setBorderPainted(true);
next_su.setFont(Single_player.fbutton);
next_su.setFocusable(false);
base1.add(next_su);
next_su.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
    	next_su.setBackground(Color.lightGray);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
    	next_su.setBackground(UIManager.getColor("control"));
    }
    public void mouseClicked(java.awt.event.MouseEvent evt) {
    	if(difficulty.equals("")){
    		JOptionPane.showMessageDialog(base1, "Please Select Difficulty", "Difficulty",
    		        JOptionPane.WARNING_MESSAGE);
    	}
    	else if(mysel!=4 || oppsel!=4)
    	{
    		JOptionPane.showMessageDialog(base1, "Please Select 4 Players each ", "Players",
    		        JOptionPane.WARNING_MESSAGE);
    	}
    	else {
    		//toss panel
			final toss_su toss= new toss_su();
			Single_player.parent.add(toss,"3");					
    	Single_player.c1.show(Single_player.parent, "3"); }
    }
});


//Difficulty Panel
	JLabel dif_head=new JLabel("DIFFICULTY",SwingConstants.CENTER);
	dif_head.setFont(Single_player.fhead);
	dif_head.setForeground(Color.WHITE);
	dif_head.setBounds(0, (int) (Single_player.screenSize.height/(3.5)), Single_player.screenSize.width/4, (int) (Single_player.screenSize.height/(15)));
	javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
	dif_head.setBorder(border);
	base1.add(dif_head);
	
	
	
	final JButton easy=new JButton("EASY");
	final JButton hard=new JButton("HARD");
	
	//easy
	easy.setActionCommand("easy");
	easy.setBounds(0, (int) (Single_player.screenSize.height/(2.35)), (int) (Single_player.screenSize.width/(4.5)), (int) (Single_player.screenSize.height/(15)));
	easy.setBorderPainted(true);
	easy.setFont(Single_player.fbutton);
	easy.setFocusable(false);
	base1.add(easy);
	easy.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	    	
	    }
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	
	    	difficulty=easy.getActionCommand();
	    	easy.setBackground(Color.GREEN);
	    	hard.setBackground(UIManager.getColor("control"));
	    }
	});
	//hard
	hard.setActionCommand("3");
	hard.setBounds(0, (int) (Single_player.screenSize.height/(1.75)), (int) (Single_player.screenSize.width/(4.5)), (int) (Single_player.screenSize.height/(15)));
	hard.setBorderPainted(true);
	hard.setFont(Single_player.fbutton);
	hard.setFocusable(false);
	base1.add(hard);
	hard.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	
	    	difficulty=hard.getActionCommand();
	    	hard.setBackground(Color.GREEN);
	    	easy.setBackground(UIManager.getColor("control"));
	    }
	});
	
	
	//Teams 
	JLabel team_head=new JLabel("--SQUAD--", SwingConstants.CENTER);
	team_head.setFont(Single_player.fhead);
	team_head.setForeground(Color.WHITE);
	team_head.setBounds((int) (Single_player.screenSize.width/(1.96)), (int) (Single_player.screenSize.height/(5)),Single_player. screenSize.width/4, (int) (Single_player.screenSize.height/(15)));
		team_head.setBorder(border);
	base1.add(team_head);

	
	//Label For my_team
		JLabel my_team=new JLabel("MY TEAM", SwingConstants.CENTER);
		my_team.setFont(Single_player.flabel);
		my_team.setForeground(Color.WHITE);
		my_team.setBounds((int) (Single_player.screenSize.width/(2.75)), (int) (Single_player.screenSize.height/(3)), Single_player.screenSize.width/6, (int) (Single_player.screenSize.height/(20)));
		my_team.setBorder(border);
		base1.add(my_team);
		//Jlabel for v/s
				JLabel vs=new JLabel(" V/S ", SwingConstants.CENTER);
				vs.setFont(Single_player.fvs);
				vs.setForeground(Color.WHITE);
				vs.setBounds((int) (Single_player.screenSize.width/(1.77)), (int) (Single_player.screenSize.height/(1.9)), Single_player.screenSize.width/8, (int) (Single_player.screenSize.height/(15)));
				base1.add(vs);
		//Label For OPP_team
		JLabel opp_team=new JLabel("OPPONENT", SwingConstants.CENTER);
		opp_team.setFont(Single_player.flabel);
		opp_team.setForeground(Color.WHITE);
		opp_team.setBounds((int) (Single_player.screenSize.width/(1.37)), (int) (Single_player.screenSize.height/(3)), Single_player.screenSize.width/6, (int) (Single_player.screenSize.height/(20)));
		opp_team.setBorder(border);
		base1.add(opp_team);
		squadList1();
		squadList2();
	}
	
	//SQUAD FROM DB
	public static String mysquad[]={"a","b","c","d","e"};
	public static String oppsquad[]={"a","b","c","d","ee"};

	public static int mysel;
	public static int oppsel;
	
	public static void squadList1(){
		//List For Teams selection
		final JList my_list_squad;
		JScrollPane scroller;
		for(String player : mysquad){
			
			myplayers.addElement(player);
		}
		
		my_list_squad=new JList(myplayers);
		my_list_squad.setFixedCellHeight(Single_player.screenSize.height/(17));
		my_list_squad.setFixedCellWidth((int) (Single_player.screenSize.width/(2.75)));
		my_list_squad.setSelectionBackground(Color.LIGHT_GRAY);
		my_list_squad.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroller=new JScrollPane(my_list_squad);
		my_list_squad.setFont(Single_player.flabel);
		my_list_squad.setBounds((int) (Single_player.screenSize.width/(2.75)), (int) (Single_player.screenSize.height/(2.43)), Single_player.screenSize.width/6, (int) (Single_player.screenSize.height/(3.2)));
		my_list_squad.setBackground(Single_player.clist);
		base1.add(my_list_squad);
		
		my_list_squad.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent le) {
				mysquadsel= my_list_squad.getSelectedValuesList();	
				mysel=my_list_squad.getSelectedIndices().length;
				}				
		});
	}
		
		//List2
	
	public static void squadList2(){
		final JList opp_list_squad;
		for(String player : oppsquad){
			
		oppplayers.addElement(player);
		}
		opp_list_squad=new JList(oppplayers);
		opp_list_squad.setFixedCellHeight(Single_player.screenSize.height/(17));
		opp_list_squad.setFixedCellWidth((int) (Single_player.screenSize.width/(2.75)));
		opp_list_squad.setSelectionBackground(Color.LIGHT_GRAY);
		opp_list_squad.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		opp_list_squad.setFont(Single_player.flabel);
		opp_list_squad.setBounds((int) (Single_player.screenSize.width/(1.37)), (int) (Single_player.screenSize.height/(2.43)), Single_player.screenSize.width/6, (int) (Single_player.screenSize.height/(3.2)));
		opp_list_squad.setBackground(Single_player.clist);
		base1.add(opp_list_squad);
		opp_list_squad.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent le) {
				oppsquadsel=opp_list_squad.getSelectedValuesList();
				oppsel=opp_list_squad.getSelectedIndices().length;
			}
			
		});
	}
	
	
	
	
}
