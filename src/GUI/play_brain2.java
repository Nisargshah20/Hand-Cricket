package GUI;
import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.JLabel;
public class play_brain2 {
	public static int team_score_2;
	public static int wicket_2;
	public static int over_ball_2;
	public static int over_overs_2;
	public static int over_totalballs_2=(Integer.parseInt(Single_player.overs)*6);
	public static int tempshot2;
	public static boolean if_second_inning_over=false;
	public static boolean check_if_strike_change=false;
	public static boolean check_if_wicket2=false;
	public static boolean check_if_factor2=false;
	public static int req=(play_brain1.team_score_1)+1;
	
	//For Player
/*	public static int bat1_score;
	public static int bat2_score;
	public static String bat1;
	public static String bat2;
	public static String Striker;
	public static String NonStriker;
	public static int list_pointer=1;
	public static int[] player_scores=new int[4];
	public static int player_score__pointer;
	*/
	
	public static JLabel comments2;
	public static JLabel update_score2;
	public static JLabel update_overs2;
	public static JLabel update_runrate2;
	public static JLabel reference2;
	
	static Thread t1;
	public play_brain2(JLabel update_score2,JLabel update_overs2,JLabel update_runrate2,JLabel reference2){
		play_brain2.update_overs2=update_overs2;
		play_brain2.update_score2=update_score2;
		play_brain2.update_runrate2=update_runrate2;
		play_brain2.reference2=reference2;
		}
/*	public static void set_players(){
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
	}*/
	//Method to set if wicket has fallen or strike is changed
	public static void set_checks2(){
		
		//Check if difficulty
	
			//Check if user is batting
			if(toss_brain.compselect.equals("bat")){
				if(Play_su2.usershot2==Play_su2.compshot2){
					
					check_if_factor2=true;}
				else if(Play_su2.usershot2==6 && (Play_su2.compshot2==2 || Play_su2.compshot2==3))
					check_if_factor2=true;
				else if(Play_su2.usershot2==4 && (Play_su2.compshot2==2 ))
					check_if_factor2=true;
				else
					check_if_factor2=false;
				
			}
			else
			{
				if(Play_su2.usershot2==Play_su2.compshot2){
					
					check_if_factor2=true;}
				else
				check_if_factor2=false;
			}
			
			
		//Wicket?
			if(check_if_factor2){
				
				check_if_wicket2=true;
				//if(wicket_1<3)
				//list_pointer++;
				
				//Check Striker while wicket fell
			/*	if(Striker.equals(bat1))
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
				}*/
			}
			else{
				check_if_wicket2=false;
				
				//Strike Change?
				if(toss_brain.compselect.equals("bat")){
					if(play_su.usershot%2!=0 && over_ball_2!=5){
						check_if_strike_change=true;
					}
					else if(play_su.compshot%2==0 && over_ball_2==5){
						check_if_strike_change=true;
					}
					else
						check_if_strike_change=false;
				}
				else
				{
					if(play_su.compshot%2!=0 && over_ball_2!=5){
						check_if_strike_change=true;
					}
					else if(play_su.compshot%2==0 && over_ball_2==5){
						check_if_strike_change=true;
					}
					else
						check_if_strike_change=false;
				}
			
			}

	}

public static void update_scoreboard2(){
		//Update score
	if(check_if_wicket2){
		
		wicket_2++;
		update_score2.setText(""+team_score_2+"/"+wicket_2);
	}
	else{
		if(toss_brain.compselect.equals("bat")){
			tempshot2=Play_su2.usershot2;
		team_score_2=team_score_2+Play_su2.usershot2;
		req=req-tempshot2;
		}
		else{
			tempshot2=Play_su2.compshot2;
			team_score_2=team_score_2+Play_su2.compshot2;
			req=req-tempshot2;
			}
		if(req<0)
		{	req=0;}
		
		update_score2.setText(""+team_score_2+"/"+wicket_2);
	}
	// Overs update
	if(over_ball_2==5){
		over_ball_2=0;
		over_overs_2++;
		over_totalballs_2--;
	}
	else{
		over_ball_2++;
	over_totalballs_2--;}
	update_overs2.setText(""+over_overs_2+"."+over_ball_2+" ("+Single_player.overs+")");
	
	//Check if_first_inning_over
	if(over_overs_2==Integer.parseInt(Single_player.overs) || wicket_2==3 || play_brain1.team_score_1<team_score_2)
			{
		if_second_inning_over=true;
		reference2.add(play_su.viewscore1);
			}
	
	
	//Needed update
			update_runrate2.setText("<html>NEED<br>"+req+"<br>OFF<br>"+over_totalballs_2+" <br>BALLS</html>");
		}
public static void make_comments2(){
	
	}
public static void main(String s[])throws InterruptedException{
	if(!(if_second_inning_over)){
		if(wicket_2==0)
		{
			/*set_players(); */
		}
	set_checks2();	
		
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
	update_scoreboard2();
	make_comments2();
	}
}
}
