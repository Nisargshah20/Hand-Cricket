package backend;
import GUI.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JLabel;
public class PlayBrain1 {
	public static int team_score_1;
	public static int wicket_1;
	public static int over_ball_1;
	public static int over_overs_1;
	public static int over_totalballs_1;
	public static int tempshot;
	public static boolean if_first_inning_over=false;
	public static boolean check_if_strike_change=false;
	public static boolean check_if_wicket=false;
	public static boolean check_if_factor=false;
	
	//For Player
	public static int bat1_score;
	public static int bat2_score;
	public static String bat1;
	public static String bat2;
	public static String Striker;
	public static String NonStriker;
	public static int list_pointer=1;
	public static int[] player_scores=new int[4];
	public static int player_score__pointer;
	public static String[] myteam= (String[]) TeamSelection.mysquadsel.toArray(new String[0]);
	public static String[] oppteam=(String[]) TeamSelection.oppsquadsel.toArray(new String[0]);
	
	
	public static JLabel comments;
	public static JLabel update_score;
	public static JLabel update_overs;
	public static JLabel update_runrate;
	public static JLabel reference;
	public static JLabel update_comments;
	public static JLabel update_strikes;
	static Random ra=new Random();
	
	static Thread t1;
	public PlayBrain1(JLabel update_score,JLabel update_overs,JLabel update_runrate,JLabel reference,JLabel update_comments,JLabel update_strikes){
		PlayBrain1.update_overs=update_overs;
		PlayBrain1.update_score=update_score;
		PlayBrain1.update_runrate=update_runrate;
		PlayBrain1.reference=reference;
		PlayBrain1.update_comments=update_comments;
		PlayBrain1.update_strikes=update_strikes;
		PlayBrain1.check_if_wicket=false;
		PlayBrain1.check_if_factor=false;
		PlayBrain1.check_if_strike_change=false;
	//	System.out.println(myteam[0]);
	//	System.out.println(myteam[3]);
		}
	public static void set_players(){
		if(TossBrain.userselect.equals("bat")){
			bat1=myteam[0];
			bat2=myteam[1];
			Striker=bat1;
			NonStriker=bat2;
		//	System.out.println(bat1);
			//System.out.println(bat2);
			}
			else{
				bat1=oppteam[0];
				bat2=oppteam[1];
				Striker=bat1;
				NonStriker=bat2;
				//System.out.println(bat1);
			//	System.out.println(bat2);
				}
	}
	//Method to set if wicket has fallen or strike is changed
	public static void set_checks(){
		
		//Check if difficulty
	
			//Check if user is batting
			if(TossBrain.userselect.equals("bat")){
				if(PlayArena1.usershot==PlayArena1.compshot){
					
					check_if_factor=true;}
				else if(PlayArena1.usershot==6 && (/*PlayArena1.compshot==2 ||*/ PlayArena1.compshot==3))
					check_if_factor=true;
				else if(PlayArena1.usershot==4 && (PlayArena1.compshot==2 ))
					check_if_factor=true;
				else
					check_if_factor=false;
				
			}
			else
			{
				if(PlayArena1.usershot==PlayArena1.compshot){
					
					check_if_factor=true;}
				else
				check_if_factor=false;
			}
			
			
		//Wicket?
			if(check_if_factor){
				
				check_if_wicket=true;
				int temp_wickets=0;
				
				if(wicket_1==2){
						 temp_wickets=3;
					}
				
				//Check Striker while wicket fell
			if(temp_wickets!=3)
			{
				if(Striker.equals(bat1))
					{
						if(TossBrain.userselect.equals("bat")){
							Striker=myteam[++list_pointer];
							}
						else{
						Striker=oppteam[++list_pointer];
							}
					bat1=Striker;
					
				//	System.out.println(Striker);
					//System.out.println(NonStriker);
					//System.out.println(wicket_1);
					}
				//Else of Striker
				else{
					if(TossBrain.userselect.equals("bat")){
						Striker=myteam[++list_pointer];}
					else{
					Striker=oppteam[++list_pointer];
						}
				bat2=Striker;
				//System.out.println(Striker);
				//System.out.println(NonStriker);
					}
					if(over_ball_1!=5)	
					check_if_strike_change=false;
					else
						check_if_strike_change=true;
			}
			}
			else{
				check_if_wicket=false;
				
				//Strike Change?
				if(TossBrain.userselect.equals("bat")){
					if(PlayArena1.usershot%2!=0 && over_ball_1!=5){
						check_if_strike_change=true;
						}
					else if(PlayArena1.usershot%2==0 && over_ball_1==5){
						check_if_strike_change=true;
						}
					else
						check_if_strike_change=false;
				}
				else
				{
					if(PlayArena1.compshot%2!=0 && over_ball_1!=5){
						check_if_strike_change=true;
					}
					else if(PlayArena1.compshot%2==0 && over_ball_1==5){
						check_if_strike_change=true;
					}
					else
						check_if_strike_change=false;
				}
			}
			
		
			
	}

public static void update_scoreboard(){
		//Update score
	if(check_if_wicket){
		
		wicket_1++;
		update_score.setText(""+team_score_1+"/"+wicket_1);
	}
	else{
		if(TossBrain.userselect.equals("bat")){
			tempshot=PlayArena1.usershot;
		team_score_1=team_score_1+PlayArena1.usershot;}
		else{
			tempshot=PlayArena1.compshot;
			team_score_1=team_score_1+PlayArena1.compshot;}
		
		update_score.setText(""+team_score_1+"/"+wicket_1);
	}
	// Overs update
	if(over_ball_1==5){
		over_ball_1=0;
		over_overs_1++;
		over_totalballs_1++;
	}
	else{
		over_ball_1++;
	over_totalballs_1++;}
	update_overs.setText(""+over_overs_1+"."+over_ball_1+" ("+PlayMode.overs+")");
	
	//Check if_first_inning_over
	if(over_overs_1==Integer.parseInt(PlayMode.overs) || wicket_1==3)
			{
		if_first_inning_over=true;
		reference.add(PlayArena1.viewscore1);
			}
	
	
	//Runrate update
	double 	runrate_1=(((double)team_score_1/over_totalballs_1)*6);
		DecimalFormat df=new DecimalFormat("#0.0");
		update_runrate.setText("<html>Run<br>Rate:<br>"+df.format(runrate_1)+"</html>");
		}
	//Making Comments

	public static void make_comments(){
		int commentint=ra.nextInt(4);
		 if(check_if_wicket){
			update_comments.setText(PlayArena1.ComWic[commentint]);
		}
		 else if(tempshot==1){
			update_comments.setText(PlayArena1.ComOne[commentint]);
		}
		else if(tempshot==2){
			update_comments.setText(PlayArena1.ComTwo[commentint]);
		}
		else if(tempshot==3){
			update_comments.setText(PlayArena1.ComThree[commentint]);
		}
		else if(tempshot==4){
			update_comments.setText(PlayArena1.ComFour[commentint]);
		}
		else if(tempshot==6){
			update_comments.setText(PlayArena1.ComSix[commentint]);
		}
		
		else
			update_comments.setText("");
		 
		
			 if(!check_if_strike_change){
			// System.out.println("change nthi vala "+Player.transfer1+"  "+Player.transfer2);
				 update_strikes.setText("<html>"+Striker+"*  "+Player.transfer1+"<br> "+NonStriker+" "+Player.transfer2+"</html>");}
			 else{
				 update_strikes.setText("<html>"+Striker+"*  "+Player.transfer2+"<br> "+NonStriker+" "+Player.transfer1+"</html>");
				 // System.out.println("change vala "+Player.transfer1+"  "+Player.transfer2);	 
			 	}
		 
}
	
	
public static void main(String s[])throws InterruptedException{
	if(!(if_first_inning_over)){
		if(wicket_1==0 && over_totalballs_1==0)
		{
			set_players();
		}
	set_checks();	
	
	//Multi-Threadind
	
	final Player p1 =new Player();
	//Thread
	t1 = new Thread(new Runnable(){
		public void run(){
			try {
				p1.exchange_striker();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
	
	t1.start();

	t1.join();

	
	//System.out.println("Back to main thread");
	
	//xyzz
	update_scoreboard();
	make_comments();
	}
}
}
