package GUI;

public class Player {
	

	
	
 public void update_striker() throws InterruptedException{
		{
			//System.out.println("Entered update");
			
			Thread t2 = new Thread(new Runnable(){
				public void run(){
					try{
						exchange_striker();
					}
					catch(InterruptedException ie){
					ie.printStackTrace();
					}
				}
			});
			t2.start();
			t2.join();
		//	System.out.println("Leaving update");
		}
	}
 public void exchange_striker() throws InterruptedException{
		{
			//System.out.println("Entered exchange");
			//System.out.println("Leaving exchNGE");
		}
	}
}
