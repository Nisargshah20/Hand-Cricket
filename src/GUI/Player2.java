package GUI;

public class Player2 {
	
	public int shotadd;
	public  static String transfer1="0";
	public  static String transfer2="0";
	public static int index1,index2;
	
	
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
			
		
 if(play_brain2.check_if_strike_change2){
	// System.out.println("Striker changing : ");
			play_brain2.Striker = play_brain2.Striker + play_brain2.NonStriker;
			play_brain2.NonStriker = play_brain2.Striker.substring(0, (play_brain2.Striker.length() - play_brain2.NonStriker.length()));
			play_brain2.Striker = play_brain2.Striker.substring(play_brain2.NonStriker.length());
 		}
 

 }
 public void update_striker() throws InterruptedException{
	 int strikerscore;
		//System.out.println("Entered exchange");
	if(!play_brain2.check_if_wicket2){
			if(toss_brain.compselect.equals("bat")){
				shotadd=Play_su2.usershot2;
			for(int x=0;x<4;x++){
				if(play_brain2.Striker.equals(play_su.playerscores1[x][0])){
					index1=x;
					strikerscore=Integer.parseInt(play_su.playerscores1[x][1])+shotadd;
					play_su.playerscores1[x][1]=""+strikerscore;
					transfer1=play_su.playerscores1[x][1];
				}
				if(play_brain2.NonStriker.equals(play_su.playerscores1[x][0])){
					transfer2=play_su.playerscores1[x][1];
					index2=x;
				}
			}
			
			}
			else{
					shotadd=Play_su2.compshot2;
					for(int x=0;x<4;x++){
						if(play_brain2.Striker.equals(play_su.playerscores2[x][0])){
							index1=x;
							strikerscore=Integer.parseInt(play_su.playerscores2[x][1])+shotadd;
							play_su.playerscores2[x][1]=""+strikerscore;
							transfer1=play_su.playerscores2[x][1];
							}
						if(play_brain2.NonStriker.equals(play_su.playerscores2[x][0])){
						index2=x;
						transfer2=play_su.playerscores2[x][1];
						}
					}
				}
		}
	else{
		int tempwick=0;
			if(play_brain1.wicket_1==2){
				tempwick=3;
			}
			if(tempwick!=3){
				transfer1="0";
				
				if(toss_brain.compselect.equals("bat")){
				for(int x=0;x<4;x++){
					if(play_brain2.NonStriker.equals(play_su.playerscores1[x][0])){
						transfer2=play_su.playerscores1[x][1];
					}
				}
				}
				else{
						
						for(int x=0;x<4;x++){
							if(play_brain2.NonStriker.equals(play_su.playerscores2[x][0])){
							transfer2=play_su.playerscores2[x][1];}
											}
					}
				
				

			}
	}
	
}

}
