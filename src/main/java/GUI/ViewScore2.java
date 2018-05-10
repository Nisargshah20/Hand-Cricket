package GUI;
import backend.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ViewScore2 extends JPanel{
	public static  JLabel view2_base;
	public ViewScore2(){
		//Adding base
		
		view2_base = new JLabel();
		view2_base.setSize(PlayMode.screenSize.width, PlayMode.screenSize.height);
		view2_base.setIcon(PlayMode.imageIcon);
		this.add(view2_base);
		

		//Label for heading
		JLabel head=new JLabel("SCORE-CARD",SwingConstants.CENTER);
		head.setFont(PlayMode.fvs);
		head.setBounds(PlayMode.screenSize.width/(100), PlayMode.screenSize.height/80, PlayMode.screenSize.width, PlayMode.screenSize.height/10);
		view2_base.add(head);
		
		//Player Heading
		JLabel player_heading=new JLabel("PLAYER",SwingConstants.CENTER);
		player_heading.setFont(PlayMode.fhead);
		player_heading.setForeground(Color.WHITE);
		player_heading.setBounds( PlayMode.screenSize.width/4, (int) (PlayMode.screenSize.height/(4.5)), PlayMode.screenSize.width/3, (int) (PlayMode.screenSize.height/(12)));
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 5);
		player_heading.setBorder(border);
		view2_base.add(player_heading);
		
		//Runs Heading
		JLabel runs_heading=new JLabel("RUNS",SwingConstants.CENTER);
		runs_heading.setFont(PlayMode.fhead);
		runs_heading.setForeground(Color.WHITE);
		runs_heading.setBounds( (PlayMode.screenSize.width/4+PlayMode.screenSize.width/3), (int) (PlayMode.screenSize.height/(4.5)), PlayMode.screenSize.width/7, (int) (PlayMode.screenSize.height/(12)));
		runs_heading.setBorder(border);
		view2_base.add(runs_heading);
										
		
//Player1
		//Player Name
		JLabel player1=new JLabel("",SwingConstants.CENTER);
		player1.setFont(PlayMode.fhead);
		player1.setForeground(Color.WHITE);
		player1.setBounds( PlayMode.screenSize.width/4, player_heading.getY()+player_heading.getHeight(), PlayMode.screenSize.width/3, player_heading.getHeight());
		player1.setBorder(border);
		view2_base.add(player1);
		
		//Runs Heading
		JLabel player1r=new JLabel("",SwingConstants.CENTER);
		player1r.setFont(PlayMode.fhead);
		player1r.setForeground(Color.WHITE);
		player1r.setBounds( (PlayMode.screenSize.width/4+PlayMode.screenSize.width/3), player1.getY(), PlayMode.screenSize.width/7, player_heading.getHeight());
		player1r.setBorder(border);
		view2_base.add(player1r);		
	
		
//Player2
		//Player Name
		JLabel player2=new JLabel("",SwingConstants.CENTER);
		player2.setFont(PlayMode.fhead);
		player2.setForeground(Color.WHITE);
		player2.setBounds( PlayMode.screenSize.width/4, player1.getY()+player_heading.getHeight(), PlayMode.screenSize.width/3, player_heading.getHeight());
		player2.setBorder(border);
		view2_base.add(player2);
		
		//Runs Heading
		JLabel player2r=new JLabel("",SwingConstants.CENTER);
		player2r.setFont(PlayMode.fhead);
		player2r.setForeground(Color.WHITE);
		player2r.setBounds( (PlayMode.screenSize.width/4+PlayMode.screenSize.width/3), player2.getY(), PlayMode.screenSize.width/7, player_heading.getHeight());
		player2r.setBorder(border);
		view2_base.add(player2r);				

//Player3
				//Player Name
				JLabel player3=new JLabel("",SwingConstants.CENTER);
				player3.setFont(PlayMode.fhead);
				player3.setForeground(Color.WHITE);
				player3.setBounds( PlayMode.screenSize.width/4, player2.getY()+player_heading.getHeight(), PlayMode.screenSize.width/3, player_heading.getHeight());
				player3.setBorder(border);
				view2_base.add(player3);
				
				//Runs Heading
				JLabel player3r=new JLabel("",SwingConstants.CENTER);
				player3r.setFont(PlayMode.fhead);
				player3r.setForeground(Color.WHITE);
				player3r.setBounds( (PlayMode.screenSize.width/4+PlayMode.screenSize.width/3), player3.getY(), PlayMode.screenSize.width/7, player_heading.getHeight());
				player3r.setBorder(border);
				view2_base.add(player3r);				
	
//Player4
				//Player Name
				JLabel player4=new JLabel("",SwingConstants.CENTER);
				player4.setFont(PlayMode.fhead);
				player4.setForeground(Color.WHITE);
				player4.setBounds( PlayMode.screenSize.width/4, player3.getY()+player_heading.getHeight(), PlayMode.screenSize.width/3, player_heading.getHeight());
				player4.setBorder(border);
				view2_base.add(player4);
				
				//Runs Heading
				JLabel player4r=new JLabel("",SwingConstants.CENTER);
				player4r.setFont(PlayMode.fhead);
				player4r.setForeground(Color.WHITE);
				player4r.setBounds( (PlayMode.screenSize.width/4+PlayMode.screenSize.width/3), player4.getY(), PlayMode.screenSize.width/7, player_heading.getHeight());
				player4r.setBorder(border);
				view2_base.add(player4r);				
	
//Comments
				
				
				//Label For Comments
				JLabel comm=new JLabel("",SwingConstants.CENTER);
				comm.setFont(PlayArena1.fsc);
				comm.setForeground(Color.yellow);
				comm.setBounds((int) (PlayMode.screenSize.width/(100)), (int) (PlayMode.screenSize.height/(2)),(int) (PlayMode.screenSize.width), (int) (PlayMode.screenSize.height/(2)));
				view2_base.add(comm);
				
//Checking battig/bowling				
				int flag;
				if(TossBrain.compselect.equals("bat"))
					flag=1;
				else
					flag=0;
//Updating Texts
			if(flag==1){
				player1.setText(PlayArena1.playerscores1[0][0]);
				player1r.setText(PlayArena1.playerscores1[0][1]);
				
				player2.setText(PlayArena1.playerscores1[1][0]);
				player2r.setText(PlayArena1.playerscores1[1][1]);
				
				player3.setText(PlayArena1.playerscores1[2][0]);
				player3r.setText(PlayArena1.playerscores1[2][1]);
				
				player4.setText(PlayArena1.playerscores1[3][0]);
				player4r.setText(PlayArena1.playerscores1[3][1]);
					
			}
			else
			{
				player1.setText(PlayArena1.playerscores2[0][0]);
				player1r.setText(PlayArena1.playerscores2[0][1]);
				
				player2.setText(PlayArena1.playerscores2[1][0]);
				player2r.setText(PlayArena1.playerscores2[1][1]);
				
				player3.setText(PlayArena1.playerscores2[2][0]);
				player3r.setText(PlayArena1.playerscores2[2][1]);
				
				player4.setText(PlayArena1.playerscores2[3][0]);
				player4r.setText(PlayArena1.playerscores2[3][1]);
				
			}
				
			if(PlayBrain2.if_second_inning_over && (PlayBrain1.team_score_1<PlayBrain2.team_score_2)){
				if(TossBrain.userselect.equals("bat"))
				{
					comm.setText(PlayMode.oppteam+" Wins");
				}
				else
					comm.setText(PlayMode.myteam+" Wins ");
			}
			else if(PlayBrain2.if_second_inning_over && (PlayBrain1.team_score_1>PlayBrain2.team_score_2)){
				if(TossBrain.userselect.equals("bat"))
				{
					comm.setText(PlayMode.myteam+" Wins");
				}
				else
					comm.setText(PlayMode.oppteam+" Wins ");
			}
			else if(PlayBrain2.if_second_inning_over && (PlayBrain1.team_score_1==PlayBrain2.team_score_2)){
				comm.setText("Match Tied!");
				
				
			}
			
//Exit Button
			//Button for exit
			final JButton end=new JButton("Exit");
			end.setActionCommand("end");
			end.setBounds((int) (PlayMode.screenSize.width/(2)),(int) (PlayMode.screenSize.height/(1.2)),(int) (PlayMode.screenSize.width/6), PlayMode.screenSize.height/10);
			end.setBorderPainted(true);
			end.setFont(PlayMode.fbutton);
			end.setFocusable(false);
			view2_base.add(end);
			end.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			      end.setBackground(Color.lightGray);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        end.setBackground(UIManager.getColor("control"));
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {			  
			    	      System.exit(0);
			    }
			});
		
	}

}