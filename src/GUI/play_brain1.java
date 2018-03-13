package GUI;
import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.JLabel;
public class play_brain1 {
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
	
	
	public static JLabel comments;
	public static JLabel update_score;
	public static JLabel update_overs;
	public static JLabel update_runrate;
	public static JLabel reference;
	
	static Thread t1;
	public play_brain1(JLabel update_score,JLabel update_overs,JLabel update_runrate,JLabel reference){
		play_brain1.update_overs=update_overs;
		play_brain1.update_score=update_score;
		play_brain1.update_runrate=update_runrate;
		play_brain1.reference=reference;
		}
	public static void set_players(){
		if(toss_brain.userselect.equals("bat")){
			bat1=(String) team_select.mysquadsel.get(list_pointer);
			bat2=(String) team_select.mysquadsel.get((list_pointer+1));
			Striker=bat1;
			NonStriker=bat2;
			System.out.println(bat1);
			System.out.println(bat2);
			}
			else{
				bat1=(String) team_select.oppsquadsel.get(list_pointer);
				bat2=(String) team_select.oppsquadsel.get((list_pointer+1));
				Striker=bat1;
				NonStriker=bat2;
				System.out.println(bat1);
				System.out.println(bat2);}
	}
	//Method to set if wicket has fallen or strike is changed
	public static void set_checks(){
		
		//Check if difficulty
	
			//Check if user is batting
			if(toss_brain.userselect.equals("bat")){
				if(play_su.usershot==play_su.compshot){
					
					check_if_factor=true;}
				else if(play_su.usershot==6 && (play_su.compshot==2 || play_su.compshot==3))
					check_if_factor=true;
				else if(play_su.usershot==4 && (play_su.compshot==2 ))
					check_if_factor=true;
				else
					check_if_factor=false;
				
			}
			else
			{
				if(play_su.usershot==play_su.compshot){
					
					check_if_factor=true;}
				else
				check_if_factor=false;
			}
			
			
		//Wicket?
			if(check_if_factor){
				
				check_if_wicket=true;
				//if(wicket_1<3)
				//list_pointer++;
				
				//Check Striker while wicket fell
				if(Striker.equals(bat1))
					{
						if(toss_brain.userselect.equals("bat")){
							Striker=(String) team_select.mysquadsel.get(list_pointer);
					
							}
					else{
						Striker=(String) team_select.oppsquadsel.get(list_pointer);
				}
					bat1=Striker;
					System.out.println(Striker);
					System.out.println(NonStriker);
					System.out.println(wicket_1);
				}
				//Else of Striker
				else{
					if(toss_brain.userselect.equals("bat")){
						Striker=(String) team_select.mysquadsel.get(list_pointer);
						}
					else{
						Striker=(String) team_select.oppsquadsel.get(list_pointer);
						}
				bat2=Striker;
				System.out.println(Striker);
				System.out.println(NonStriker);
				}
			}
			else{
				check_if_wicket=false;
				
				//Strike Change?
				if(toss_brain.userselect.equals("bat")){
					if(play_su.usershot%2!=0 && over_ball_1!=5){
						check_if_strike_change=true;
					}
					else if(play_su.compshot%2==0 && over_ball_1==5){
						check_if_strike_change=true;
					}
					else
						check_if_strike_change=false;
				}
				else
				{
					if(play_su.compshot%2!=0 && over_ball_1!=5){
						check_if_strike_change=true;
					}
					else if(play_su.compshot%2==0 && over_ball_1==5){
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
		if(toss_brain.userselect.equals("bat")){
			tempshot=play_su.usershot;
		team_score_1=team_score_1+play_su.usershot;}
		else{
			tempshot=play_su.compshot;
			team_score_1=team_score_1+play_su.compshot;}
		
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
	update_overs.setText(""+over_overs_1+"."+over_ball_1+" ("+Single_player.overs+")");
	
	//Check if_first_inning_over
	if(over_overs_1==Integer.parseInt(Single_player.overs) || wicket_1==3)
			{
		if_first_inning_over=true;
		reference.add(play_su.viewscore1);
			}
	
	
	//Runrate update
	double 	runrate_1=(((double)team_score_1/over_totalballs_1)*6);
		DecimalFormat df=new DecimalFormat("#0.0");
		update_runrate.setText("<html>Run<br>Rate:<br>"+df.format(runrate_1)+"</html>");
		}
public static void make_comments(){
	
	}
public static void main(String s[])throws InterruptedException{
	if(!(if_first_inning_over)){
		if(wicket_1==0)
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
				p1.update_striker();
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
