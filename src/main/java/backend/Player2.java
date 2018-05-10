package backend;
import GUI.*;
/**
 * Maintains Strike and update runs of players batting in second innings
 */
public class Player2 {
	
	public int shotadd;
	public  static String transfer1="0";
	public  static String transfer2="0";
	public static int index1,index2;
	
	/**
	 * It will handle the exchange of strike between players
	 * @throws InterruptedException
	 */
 public void exchange_striker() throws InterruptedException{
		
			
			Thread t2 = new Thread(new Runnable(){
				public void run(){
					try{
						update_striker();
					}
					catch(InterruptedException ie){
					ie.printStackTrace();
					}
				}
			});
			t2.start();
			t2.join();
			
		
 if(PlayBrain2.check_if_strike_change2){
	// System.out.println("Striker changing : ");
			PlayBrain2.Striker = PlayBrain2.Striker + PlayBrain2.NonStriker;
			PlayBrain2.NonStriker = PlayBrain2.Striker.substring(0, (PlayBrain2.Striker.length() - PlayBrain2.NonStriker.length()));
			PlayBrain2.Striker = PlayBrain2.Striker.substring(PlayBrain2.NonStriker.length());
 		}
 

 }
 
 /**
  * It will update the score of striker
  * @throws InterruptedException
  */
 public void update_striker() throws InterruptedException{
	 int strikerscore;
		//System.out.println("Entered exchange");
	if(!PlayBrain2.check_if_wicket2){
			if(TossBrain.compselect.equals("bat")){
				shotadd=PlayArena2.usershot2;
			for(int x=0;x<4;x++){
				if(PlayBrain2.Striker.equals(PlayArena1.playerscores1[x][0])){
					index1=x;
					strikerscore=Integer.parseInt(PlayArena1.playerscores1[x][1])+shotadd;
					PlayArena1.playerscores1[x][1]=""+strikerscore;
					transfer1=PlayArena1.playerscores1[x][1];
				}
				if(PlayBrain2.NonStriker.equals(PlayArena1.playerscores1[x][0])){
					transfer2=PlayArena1.playerscores1[x][1];
					index2=x;
				}
			}
			
			}
			else{
					shotadd=PlayArena2.compshot2;
					for(int x=0;x<4;x++){
						if(PlayBrain2.Striker.equals(PlayArena1.playerscores2[x][0])){
							index1=x;
							strikerscore=Integer.parseInt(PlayArena1.playerscores2[x][1])+shotadd;
							PlayArena1.playerscores2[x][1]=""+strikerscore;
							transfer1=PlayArena1.playerscores2[x][1];
							}
						if(PlayBrain2.NonStriker.equals(PlayArena1.playerscores2[x][0])){
						index2=x;
						transfer2=PlayArena1.playerscores2[x][1];
						}
					}
				}
		}
	else{
		int tempwick=0;
			if(PlayBrain1.wicket_1==2){
				tempwick=3;
			}
			if(tempwick!=3){
				transfer1="0";
				
				if(TossBrain.compselect.equals("bat")){
				for(int x=0;x<4;x++){
					if(PlayBrain2.NonStriker.equals(PlayArena1.playerscores1[x][0])){
						transfer2=PlayArena1.playerscores1[x][1];
					}
				}
				}
				else{
						
						for(int x=0;x<4;x++){
							if(PlayBrain2.NonStriker.equals(PlayArena1.playerscores2[x][0])){
							transfer2=PlayArena1.playerscores2[x][1];}
											}
					}
				
				

			}
	}
	
}

}
