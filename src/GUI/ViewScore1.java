package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ViewScore1 extends JPanel{
	public static  JLabel view1_base;
	public ViewScore1(){
		//Adding base
		
		view1_base = new JLabel();
		view1_base.setSize(Single_player.screenSize.width, Single_player.screenSize.height);
		view1_base.setIcon(Single_player.imageIcon);
		this.add(view1_base);
		
		
		//Second inning start
		
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
		});
		
		//Label for heading
		JLabel head=new JLabel("SCORE-CARD",SwingConstants.CENTER);
		head.setFont(Single_player.fvs);
		head.setBounds(Single_player.screenSize.width/(100), Single_player.screenSize.height/80, Single_player.screenSize.width, Single_player.screenSize.height/10);
		view1_base.add(head);
		
		//Player Heading
		JLabel player_heading=new JLabel("PLAYER",SwingConstants.CENTER);
		player_heading.setFont(Single_player.fhead);
		player_heading.setForeground(Color.WHITE);
		player_heading.setBounds( Single_player.screenSize.width/4, (int) (Single_player.screenSize.height/(4.5)), Single_player.screenSize.width/3, (int) (Single_player.screenSize.height/(12)));
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 5);
		player_heading.setBorder(border);
		view1_base.add(player_heading);
		
		//Runs Heading
		JLabel runs_heading=new JLabel("RUNS",SwingConstants.CENTER);
		runs_heading.setFont(Single_player.fhead);
		runs_heading.setForeground(Color.WHITE);
		runs_heading.setBounds( (Single_player.screenSize.width/4+Single_player.screenSize.width/3), (int) (Single_player.screenSize.height/(4.5)), Single_player.screenSize.width/7, (int) (Single_player.screenSize.height/(12)));
		runs_heading.setBorder(border);
		view1_base.add(runs_heading);
										
		
//Player1
		//Player Name
		JLabel player1=new JLabel("",SwingConstants.CENTER);
		player1.setFont(Single_player.fhead);
		player1.setForeground(Color.WHITE);
		player1.setBounds( Single_player.screenSize.width/4, player_heading.getY()+player_heading.getHeight(), Single_player.screenSize.width/3, player_heading.getHeight());
		player1.setBorder(border);
		view1_base.add(player1);
		
		//Runs Heading
		JLabel player1r=new JLabel("",SwingConstants.CENTER);
		player1r.setFont(Single_player.fhead);
		player1r.setForeground(Color.WHITE);
		player1r.setBounds( (Single_player.screenSize.width/4+Single_player.screenSize.width/3), player1.getY(), Single_player.screenSize.width/7, player_heading.getHeight());
		player1r.setBorder(border);
		view1_base.add(player1r);		
	
		
//Player2
		//Player Name
		JLabel player2=new JLabel("",SwingConstants.CENTER);
		player2.setFont(Single_player.fhead);
		player2.setForeground(Color.WHITE);
		player2.setBounds( Single_player.screenSize.width/4, player1.getY()+player_heading.getHeight(), Single_player.screenSize.width/3, player_heading.getHeight());
		player2.setBorder(border);
		view1_base.add(player2);
		
		//Runs Heading
		JLabel player2r=new JLabel("",SwingConstants.CENTER);
		player2r.setFont(Single_player.fhead);
		player2r.setForeground(Color.WHITE);
		player2r.setBounds( (Single_player.screenSize.width/4+Single_player.screenSize.width/3), player2.getY(), Single_player.screenSize.width/7, player_heading.getHeight());
		player2r.setBorder(border);
		view1_base.add(player2r);				

//Player3
				//Player Name
				JLabel player3=new JLabel("",SwingConstants.CENTER);
				player3.setFont(Single_player.fhead);
				player3.setForeground(Color.WHITE);
				player3.setBounds( Single_player.screenSize.width/4, player2.getY()+player_heading.getHeight(), Single_player.screenSize.width/3, player_heading.getHeight());
				player3.setBorder(border);
				view1_base.add(player3);
				
				//Runs Heading
				JLabel player3r=new JLabel("",SwingConstants.CENTER);
				player3r.setFont(Single_player.fhead);
				player3r.setForeground(Color.WHITE);
				player3r.setBounds( (Single_player.screenSize.width/4+Single_player.screenSize.width/3), player3.getY(), Single_player.screenSize.width/7, player_heading.getHeight());
				player3r.setBorder(border);
				view1_base.add(player3r);				
	
//Player4
				//Player Name
				JLabel player4=new JLabel("",SwingConstants.CENTER);
				player4.setFont(Single_player.fhead);
				player4.setForeground(Color.WHITE);
				player4.setBounds( Single_player.screenSize.width/4, player3.getY()+player_heading.getHeight(), Single_player.screenSize.width/3, player_heading.getHeight());
				player4.setBorder(border);
				view1_base.add(player4);
				
				//Runs Heading
				JLabel player4r=new JLabel("",SwingConstants.CENTER);
				player4r.setFont(Single_player.fhead);
				player4r.setForeground(Color.WHITE);
				player4r.setBounds( (Single_player.screenSize.width/4+Single_player.screenSize.width/3), player4.getY(), Single_player.screenSize.width/7, player_heading.getHeight());
				player4r.setBorder(border);
				view1_base.add(player4r);				
	
//Comments
				
				
				//Label For Comments
				JLabel comm=new JLabel("",SwingConstants.CENTER);
				comm.setFont(play_su.fsc);
				comm.setForeground(Color.yellow);
				comm.setBounds((int) (Single_player.screenSize.width/(100)), (int) (Single_player.screenSize.height/(2)),(int) (Single_player.screenSize.width), (int) (Single_player.screenSize.height/(2)));
				view1_base.add(comm);
				
//Checking battig/bowling				
				int flag;
				if(toss_brain.userselect.equals("bat"))
					flag=1;
				else
					flag=0;
//Updating Texts
			if(flag==1){
				player1.setText(play_su.playerscores1[0][0]);
				player1r.setText(play_su.playerscores1[0][1]);
				
				player2.setText(play_su.playerscores1[1][0]);
				player2r.setText(play_su.playerscores1[1][1]);
				
				player3.setText(play_su.playerscores1[2][0]);
				player3r.setText(play_su.playerscores1[2][1]);
				
				player4.setText(play_su.playerscores1[3][0]);
				player4r.setText(play_su.playerscores1[3][1]);
				
				comm.setText("<html>"+Single_player.oppteam.toUpperCase()+" need "+(play_brain1.team_score_1+1)+" runs to win!!!</html>");
					
			}
			else
			{
				player1.setText(play_su.playerscores2[0][0]);
				player1r.setText(play_su.playerscores2[0][1]);
				
				player2.setText(play_su.playerscores2[1][0]);
				player2r.setText(play_su.playerscores2[1][1]);
				
				player3.setText(play_su.playerscores2[2][0]);
				player3r.setText(play_su.playerscores2[2][1]);
				
				player4.setText(play_su.playerscores2[3][0]);
				player4r.setText(play_su.playerscores2[3][1]);
				
				comm.setText("<html>"+Single_player.myteam.toUpperCase()+" need "+(play_brain1.team_score_1+1)+" runs to win!!!</html>");
			}
				
	
	}

}
