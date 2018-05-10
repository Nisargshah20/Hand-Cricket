package backend;
import GUI.*;
import javax.swing.JLabel;
/** 
 * This class handles the Seconds innings of the game
 */
public class PlayBrain2 {
	/** 
	 * Contains the final score of the team batting Second*/
	public static int team_score_2;
	public static int wicket_2;
	/**
	 * Increments number of balls in an over
	 */
	public static int over_ball_2;
	/** 
	 * Increment number of overs*/	
	public static int over_overs_2;
	public static int over_totalballs_2=(Integer.parseInt(PlayMode.overs)*6);
	public static int tempshot2;
	public static boolean if_second_inning_over=false;
	public static boolean check_if_strike_change2=false;
	/**	
	 * Check for a wicket*/
	public static boolean check_if_wicket2=false;
	public static boolean check_if_factor2=false;
	public static int req=(PlayBrain1.team_score_1)+1;
	
	//For Player
	public static int bat1_score;
	public static int bat2_score;
	public static String bat1;
	public static String bat2;
	/** 
	 * Player currently Batting*/
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
	/** 
	 * 
	 * @param update_score2 Contains reference of JLabel to update score
	 * @param update_overs2 Contains reference of JLabel to update overs
	 * @param update_runrate2 Contains reference of JLabel to update runrate
	 * @param reference2 Contains reference of JLabel to base JLabel
	 * @param update_comments2 Contains reference of JLabel to update Comments
	 * @param update_strikes2 Contains reference of JLabel to update Strikes
	 */
	public PlayBrain2(JLabel update_score2,JLabel update_overs2,JLabel update_runrate2,JLabel reference2,JLabel update_comments2,JLabel update_strikes2){
		PlayBrain2.update_overs2=update_overs2;
		PlayBrain2.update_score2=update_score2;
		PlayBrain2.update_runrate2=update_runrate2;
		PlayBrain2.reference2=reference2;
		PlayBrain2.update_comments2=update_comments2;
		PlayBrain2.check_if_wicket2=false;
		PlayBrain2.check_if_factor2=false;
		PlayBrain2.check_if_strike_change2=false;
		PlayBrain2.update_strikes2=update_strikes2;
		}
	/**
	 * To initialize the striker and non striker
	 */
	public static void set_players(){
		if(TossBrain.compselect.equals("bat")){
			bat1=PlayBrain1.myteam[0];
			bat2=PlayBrain1.myteam[1];
			Striker=bat1;
			NonStriker=bat2;
			}
			else{
				
				bat1=PlayBrain1.oppteam[0];
				bat2=PlayBrain1.oppteam[1];
				Striker=bat1;
				NonStriker=bat2;

				}
	}
	//Method to set if wicket has fallen or strike is changed
	/**
	 * To initialize all the check Flags
	 */
	public static void set_checks2(){
		
		//Check if difficulty
	
			//Check if user is batting
			if(TossBrain.compselect.equals("bat")){
				if(PlayArena2.usershot2==PlayArena2.compshot2){
					
					check_if_factor2=true;}
				else if(PlayArena2.usershot2==6 && (PlayArena2.compshot2==2 || PlayArena2.compshot2==3))
					check_if_factor2=true;
				else if(PlayArena2.usershot2==4 && (PlayArena2.compshot2==2 ))
					check_if_factor2=true;
				else
					check_if_factor2=false;
				
			}
			else
			{
				if(PlayArena2.usershot2==PlayArena2.compshot2){
					
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
						if(TossBrain.compselect.equals("bat")){
							Striker=PlayBrain1.myteam[++list_pointer];
							}
						else{
						Striker=PlayBrain1.oppteam[++list_pointer];
							}
					bat1=Striker;
					
				//	System.out.println(Striker);
					//System.out.println(NonStriker);
					//System.out.println(wicket_1);
				}
				//Else of Striker
				else{
					if(TossBrain.compselect.equals("bat")){
						Striker=PlayBrain1.myteam[++list_pointer];
						}
					else{
					Striker=PlayBrain1.oppteam[++list_pointer];
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
				if(TossBrain.compselect.equals("bat")){
					if(PlayArena2.usershot2%2!=0 && over_ball_2!=5){
						check_if_strike_change2=true;
						}
					else if(PlayArena2.usershot2%2==0 && over_ball_2==5){
						check_if_strike_change2=true;
						}
					else
						check_if_strike_change2=false;
				}
				else
				{
					if(PlayArena2.compshot2%2!=0 && over_ball_2!=5){
						check_if_strike_change2=true;
					}
					else if(PlayArena2.compshot2%2==0 && over_ball_2==5){
						check_if_strike_change2=true;
					}
					else
						check_if_strike_change2=false;
				}
			}

	}
	/**
	 * To update the Scoreboard
	 */
public static void update_scoreboard2(){
		//Update score
	if(check_if_wicket2){
		
		wicket_2++;
		update_score2.setText(""+team_score_2+"/"+wicket_2);
	}
	else{
		if(TossBrain.compselect.equals("bat")){
			tempshot2=PlayArena2.usershot2;
		team_score_2=team_score_2+PlayArena2.usershot2;
		req=req-tempshot2;
		}
		else{
			tempshot2=PlayArena2.compshot2;
			team_score_2=team_score_2+PlayArena2.compshot2;
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
	update_overs2.setText(""+over_overs_2+"."+over_ball_2+" ("+PlayMode.overs+")");
	
	//Check if_first_inning_over
	if(over_overs_2==Integer.parseInt(PlayMode.overs) || wicket_2==3 || PlayBrain1.team_score_1<team_score_2)
			{
		if_second_inning_over=true;
		reference2.add(PlayArena2.viewscore2);
			}
	
	
	//Needed update
			update_runrate2.setText("<html>NEED<br>"+req+"<br>OFF<br>"+over_totalballs_2+" <br>BALLS</html>");
		}
//Making Comments
/**
 * To Display comments according to shots or wickets
 */
public static void make_comments2(){
	int commentint=PlayBrain1.ra.nextInt(4);

	if(if_second_inning_over && (PlayBrain1.team_score_1<PlayBrain2.team_score_2)){
		if(TossBrain.userselect.equals("bat"))
		{
			update_comments2.setText(PlayMode.oppteam+" Wins");
		}
		else
			update_comments2.setText(PlayMode.myteam+" Wins ");
	}
	else if(if_second_inning_over && (PlayBrain1.team_score_1>PlayBrain2.team_score_2)){
		if(TossBrain.userselect.equals("bat"))
		{
			update_comments2.setText(PlayMode.myteam+" Wins");
		}
		else
			update_comments2.setText(PlayMode.oppteam+" Wins ");
	}
	 else if(check_if_wicket2){
		update_comments2.setText(PlayArena1.ComWic[commentint]);
	}
	 else if(tempshot2==1){
		update_comments2.setText(PlayArena1.ComOne[commentint]);
	}
	else if(tempshot2==2){
		update_comments2.setText(PlayArena1.ComTwo[commentint]);
	}
	else if(tempshot2==3){
		update_comments2.setText(PlayArena1.ComThree[commentint]);
	}
	else if(tempshot2==4){
		update_comments2.setText(PlayArena1.ComFour[commentint]);
	}
	else if(tempshot2==6){
		update_comments2.setText(PlayArena1.ComSix[commentint]);
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
		if(wicket_2==0 && (over_totalballs_2==(Integer.parseInt(PlayMode.overs)*6)))
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
