public package GUI;
import backend.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import GUI.HomeLayout;
import GUI.PlayMode;

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

public class TeamSelection extends JPanel{

	public static String difficulty="";
	static DefaultListModel myplayers=new DefaultListModel();
	static DefaultListModel oppplayers=new DefaultListModel();
	public static JLabel base1;
	public static List mysquadsel;
	public static List oppsquadsel;
	public TeamSelection(){
		base1 = new JLabel();
		base1.setSize(PlayMode.screenSize.width, PlayMode.screenSize.height);
		
		base1.setIcon(PlayMode.imageIcon);
		this.add(base1);
	
	//Button for back
	final JButton back_su=new JButton("Back");	
	back_su.setActionCommand("back_su");
	back_su.setBounds(PlayMode.screenSize.width/80, PlayMode.screenSize.height/60, PlayMode.screenSize.width/8, PlayMode.screenSize.height/15);
	back_su.setBorderPainted(true);
	back_su.setFont(PlayMode.fbutton);
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
	    	 PlayMode.c1.show(PlayMode.parent, "1");
	    }
	});
//Button for play
final JButton next_su=new JButton("Play");
next_su.setActionCommand("PlayArena1");
next_su.setBounds((int) (PlayMode.screenSize.width/(1.16)), PlayMode.screenSize.height/60, PlayMode.screenSize.width/8, PlayMode.screenSize.height/15);
next_su.setBorderPainted(true);
next_su.setFont(PlayMode.fbutton);
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
			final Toss toss= new Toss();
			PlayMode.parent.add(toss,"3");					
    	PlayMode.c1.show(PlayMode.parent, "3"); }
    }
});


//Difficulty Panel
	JLabel dif_head=new JLabel("DIFFICULTY",SwingConstants.CENTER);
	dif_head.setFont(PlayMode.fhead);
	dif_head.setForeground(Color.WHITE);
	dif_head.setBounds(0, (int) (PlayMode.screenSize.height/(3.5)), PlayMode.screenSize.width/4, (int) (PlayMode.screenSize.height/(15)));
	javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
	dif_head.setBorder(border);
	base1.add(dif_head);
	
	
	
	final JButton easy=new JButton("EASY");
	final JButton hard=new JButton("HARD");
	
	//easy
	easy.setActionCommand("easy");
	easy.setBounds(0, (int) (PlayMode.screenSize.height/(2.35)), (int) (PlayMode.screenSize.width/(4.5)), (int) (PlayMode.screenSize.height/(15)));
	easy.setBorderPainted(true);
	easy.setFont(PlayMode.fbutton);
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
	hard.setBounds(0, (int) (PlayMode.screenSize.height/(1.75)), (int) (PlayMode.screenSize.width/(4.5)), (int) (PlayMode.screenSize.height/(15)));
	hard.setBorderPainted(true);
	hard.setFont(PlayMode.fbutton);
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
	team_head.setFont(PlayMode.fhead);
	team_head.setForeground(Color.WHITE);
	team_head.setBounds((int) (PlayMode.screenSize.width/(1.96)), (int) (PlayMode.screenSize.height/(5)),PlayMode. screenSize.width/4, (int) (PlayMode.screenSize.height/(15)));
		team_head.setBorder(border);
	base1.add(team_head);

	
	//Label For my_team
		JLabel my_team=new JLabel("MY TEAM", SwingConstants.CENTER);
		my_team.setFont(PlayMode.flabel);
		my_team.setForeground(Color.WHITE);
		my_team.setBounds((int) (PlayMode.screenSize.width/(2.75)), (int) (PlayMode.screenSize.height/(3)), PlayMode.screenSize.width/6, (int) (PlayMode.screenSize.height/(20)));
		my_team.setBorder(border);
		base1.add(my_team);
		//Jlabel for v/s
				JLabel vs=new JLabel(" V/S ", SwingConstants.CENTER);
				vs.setFont(PlayMode.fvs);
				vs.setForeground(Color.WHITE);
				vs.setBounds((int) (PlayMode.screenSize.width/(1.77)), (int) (PlayMode.screenSize.height/(1.9)), PlayMode.screenSize.width/8, (int) (PlayMode.screenSize.height/(15)));
				base1.add(vs);
		//Label For OPP_team
		JLabel opp_team=new JLabel("OPPONENT", SwingConstants.CENTER);
		opp_team.setFont(PlayMode.flabel);
		opp_team.setForeground(Color.WHITE);
		opp_team.setBounds((int) (PlayMode.screenSize.width/(1.37)), (int) (PlayMode.screenSize.height/(3)), PlayMode.screenSize.width/6, (int) (PlayMode.screenSize.height/(20)));
		opp_team.setBorder(border);
		base1.add(opp_team);
		setsquads();
		squadList1();
		squadList2();
		
	}
	//Quads
	public static String Ind[]={"V Kohli","MS Dhoni(w)","Hardik P","B Kumar","J Bumrah"};
	public static String Aus[]={"S Watson","S Smith","B Haddin(w)","M Starc","N Couter-nile"};
	public static String Sa[]={"AB de villiers","Faf du Plesis","de Kock(w)","Philander","Rabada"};
	public static String Pak[]={"Az Ali","F Zaman","S Ahmed(w)","M Amir","H Ali"};
	public static String Wi[]={"C Gayle","D Smith(w)","K Pollard","S Narine","C Brathwaite"};
	public static String Eng[]={"J Root","J Bairstow(w)","B Stokes","C Woakes","S Broad"};
	public static String Nz[]={"M Guptill","Williamson(w)","M Santner","T Southee","T Boult"};
	public static String Sl[]={"N Dickwella(w)","K Prera","T Prera","D Shanaka","N Pradeep"};
	
	//SQUAD FROM DB
	public static String mysquad[];
	public static String oppsquad[];
	
	
	//Set Players
public static void setsquads(){
	if(PlayMode.myteam.equals("India")){
	TeamSelection.mysquad=Ind;
	}
	else if(PlayMode.myteam.equals("Australia")){
		TeamSelection.mysquad=Aus;
		}
	else if(PlayMode.myteam.equals("SouthAfrica")){
		TeamSelection.mysquad=Sa;
		}
	else if(PlayMode.myteam.equals("Pakistan")){
		TeamSelection.mysquad=Pak;
		}
	else if(PlayMode.myteam.equals("WestIndies")){
		TeamSelection.mysquad=Wi;
		}
	else if(PlayMode.myteam.equals("England")){
		TeamSelection.mysquad=Eng;
		}
	else if(PlayMode.myteam.equals("Newzealand")){
		TeamSelection.mysquad=Nz;
		}
	else if(PlayMode.myteam.equals("SriLanka")){
		TeamSelection.mysquad=Sl;
		}
	else{
		TeamSelection.mysquad=Ind;
	}
	
	if(PlayMode.oppteam.equals("India")){
		TeamSelection.oppsquad=Ind;
		}
		else if(PlayMode.oppteam.equals("Australia")){
			TeamSelection.oppsquad=Aus;
			}
		else if(PlayMode.oppteam.equals("SouthAfrica")){
			TeamSelection.oppsquad=Sa;
			}
		else if(PlayMode.oppteam.equals("Pakistan")){
			TeamSelection.oppsquad=Pak;
			}
		else if(PlayMode.oppteam.equals("WestIndies")){
			TeamSelection.oppsquad=Wi;
			}
		else if(PlayMode.oppteam.equals("England")){
			TeamSelection.oppsquad=Eng;
			}
		else if(PlayMode.oppteam.equals("Newzealand")){
			TeamSelection.oppsquad=Nz;
			}
		else if(PlayMode.oppteam.equals("SriLanka")){
			TeamSelection.oppsquad=Sl;
			}
		else{
			TeamSelection.oppsquad=Ind;
		}
}
	
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
		my_list_squad.setFixedCellHeight(PlayMode.screenSize.height/(17));
		my_list_squad.setFixedCellWidth((int) (PlayMode.screenSize.width/(2.75)));
		my_list_squad.setSelectionBackground(Color.LIGHT_GRAY);
		my_list_squad.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroller=new JScrollPane(my_list_squad);
		my_list_squad.setFont(PlayMode.flabel);
		my_list_squad.setBounds((int) (PlayMode.screenSize.width/(2.75)), (int) (PlayMode.screenSize.height/(2.43)), PlayMode.screenSize.width/6, (int) (PlayMode.screenSize.height/(3.1)));
		my_list_squad.setBackground(PlayMode.clist);
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
		opp_list_squad.setFixedCellHeight(PlayMode.screenSize.height/(17));
		opp_list_squad.setFixedCellWidth((int) (PlayMode.screenSize.width/(2.75)));
		opp_list_squad.setSelectionBackground(Color.LIGHT_GRAY);
		opp_list_squad.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		opp_list_squad.setFont(PlayMode.flabel);
		opp_list_squad.setBounds((int) (PlayMode.screenSize.width/(1.37)), (int) (PlayMode.screenSize.height/(2.43)), PlayMode.screenSize.width/6, (int) (PlayMode.screenSize.height/(3.1)));
		opp_list_squad.setBackground(PlayMode.clist);
		base1.add(opp_list_squad);
		opp_list_squad.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent le) {
				oppsquadsel=opp_list_squad.getSelectedValuesList();
				oppsel=opp_list_squad.getSelectedIndices().length;
			}
			
		});
	}
	
	
	
	
}
