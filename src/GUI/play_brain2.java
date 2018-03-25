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
	public static boolean check_if_strike_change2=false;
	public static boolean check_if_wicket2=false;
	public static boolean check_if_factor2=false;
	public static int req=(play_brain1.team_score_1)+1;
	
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
	
	
	public static JLabel comments2;
	public static JLabel update_score2;
	public static JLabel update_overs2;
	public static JLabel update_runrate2;
	public static JLabel reference2;
	public static JLabel update_comments2;
	public static JLabel update_strikes2;
	static Thread t1;
	public play_brain2(JLabel update_score2,JLabel update_overs2,JLabel update_runrate2,JLabel reference2,JLabel update_comments2,JLabel update_strikes2){
		play_brain2.update_overs2=update_overs2;
		play_brain2.update_score2=update_score2;
		play_brain2.update_runrate2=update_runrate2;
		play_brain2.reference2=reference2;
		play_brain2.update_comments2=update_comments2;
		play_brain2.check_if_wicket2=false;
		play_brain2.check_if_factor2=false;
		play_brain2.check_if_strike_change2=false;
		play_brain2.update_strikes2=update_strikes2;
		}
	public static void set_players(){
		if(toss_brain.compselect.equals("bat")){
			System.out.println("Current batting by user");
			bat1=play_brain1.myteam[0];
			bat2=play_brain1.myteam[1];
			Striker=bat1;
			NonStriker=bat2;
		//	System.out.println(bat1);
			//System.out.println(bat2);
			}
			else{
				System.out.println("Current batting by comp");
				bat1=play_brain1.oppteam[0];
				bat2=play_brain1.oppteam[1];
				Striker=bat1;
				NonStriker=bat2;
				//System.out.println(bat1);
			//	System.out.println(bat2);
				}
	}
	//Method to set if wicket has fallen or strike is changed
	public static void set_checks2(){
		
		//Check if difficulty
	
			//Check if user is batting
			if(toss_brain.compselect.equals("bat")){
				if(Play_su2.usershot2==Play_su2.compshot2){
					
					check_if_factor2=true;}
				else if(Play_su2.usershot2==6 && (/*Play_su2.compshot2==2 ||*/ Play_su2.compshot2==3))
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
				int temp_wickets=0;
				
				if(wicket_2==2){
						 temp_wickets=3;
					}
				
				//Check Striker while wicket fell
			if(temp_wickets!=3)
			{
				if(Striker.equals(bat1))
					{
						if(toss_brain.compselect.equals("bat")){
							Striker=play_brain1.myteam[++list_pointer];
							}
						else{
						Striker=play_brain1.oppteam[++list_pointer];
							}
					bat1=Striker;
					
				//	System.out.println(Striker);
					//System.out.println(NonStriker);
					//System.out.println(wicket_1);
				}
				//Else of Striker
				else{
					if(toss_brain.compselect.equals("bat")){
						Striker=play_brain1.myteam[++list_pointer];
						}
					else{
					Striker=play_brain1.oppteam[++list_pointer];
						}
				bat2=Striker;
				//System.out.println(Striker);
				//System.out.println(NonStriker);
				}
				if(over_ball_2!=5)	
				check_if_strike_change2=false;
				else{
					//System.out.println("over strike change");
					check_if_strike_change2=true;}
			}
			}
			
			else{
				//System.out.println("no wicket zone");
				check_if_wicket2=false;
				
				//Strike Change?
				if(toss_brain.compselect.equals("bat")){
					if(Play_su2.usershot2%2!=0 && over_ball_2!=5){
						check_if_strike_change2=true;
						}
					else if(Play_su2.usershot2%2==0 && over_ball_2==5){
						check_if_strike_change2=true;
						}
					else
						check_if_strike_change2=false;
				}
				else
				{
					if(Play_su2.compshot2%2!=0 && over_ball_2!=5){
						check_if_strike_change2=true;
					}
					else if(Play_su2.compshot2%2==0 && over_ball_2==5){
						check_if_strike_change2=true;
					}
					else
						check_if_strike_change2=false;
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
		reference2.add(Play_su2.viewscore2);
			}
	
	
	//Needed update
			update_runrate2.setText("<html>NEED<br>"+req+"<br>OFF<br>"+over_totalballs_2+" <br>BALLS</html>");
		}
//Making Comments

public static void make_comments2(){
	int commentint=play_brain1.ra.nextInt(4);

	if(if_second_inning_over && (play_brain1.team_score_1<play_brain2.team_score_2)){
		if(toss_brain.userselect.equals("bat"))
		{
			update_comments2.setText(Single_player.oppteam+" Wins");
		}
		else
			update_comments2.setText(Single_player.myteam+" Wins ");
	}
	else if(if_second_inning_over && (play_brain1.team_score_1>play_brain2.team_score_2)){
		if(toss_brain.userselect.equals("bat"))
		{
			update_comments2.setText(Single_player.myteam+" Wins");
		}
		else
			update_comments2.setText(Single_player.oppteam+" Wins ");
	}
	 else if(check_if_wicket2){
		update_comments2.setText(play_su.ComWic[commentint]);
	}
	 else if(tempshot2==1){
		update_comments2.setText(play_su.ComOne[commentint]);
	}
	else if(tempshot2==2){
		update_comments2.setText(play_su.ComTwo[commentint]);
	}
	else if(tempshot2==3){
		update_comments2.setText(play_su.ComThree[commentint]);
	}
	else if(tempshot2==4){
		update_comments2.setText(play_su.ComFour[commentint]);
	}
	else if(tempshot2==6){
		update_comments2.setText(play_su.ComSix[commentint]);
	}

	else
		update_comments2.setText("");
	
	
		if(!check_if_strike_change2)
			{
		 update_strikes2.setText("<html>"+Striker+"*  "+Player2.transfer1+"<br> "+NonStriker+" "+Player2.transfer2+"</html>");}
		 else{
			 update_strikes2.setText("<html>"+Striker+"*  "+Player2.transfer2+"<br> "+NonStriker+" "+Player2.transfer1+"</html>");
		 }
	
}
public static void main(String s[])throws InterruptedException{
	if(!(if_second_inning_over)){
		if(wicket_2==0 && (over_totalballs_2==(Integer.parseInt(Single_player.overs)*6)))
		{
			set_players(); 
		}
	set_checks2();	
		
	//Multi-Threadind
	
	final Player2 p2 =new Player2();
	//Thread
	t1 = new Thread(new Runnable(){
		public void run(){
			try {
				p2.exchange_striker();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
	
	t1.start();

	t1.join();

	update_scoreboard2();
	make_comments2();
	}
}
}
