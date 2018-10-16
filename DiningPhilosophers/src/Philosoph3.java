
public class Philosoph3  extends Thread{

	Table tbl = Table.getInstance();
	
	
	
	@Override
	public void run() {
		
		while (tbl.isAct()){
			if(tbl.isChopstick3() && tbl.isChopstick2()){
				tbl.setChopstick3(false);
				tbl.setChopstick2(false);
				tbl.setP3eat();
				tbl.setChopstick3(true);
				tbl.setChopstick2(true);
							
			}
			 
			tbl.setP3think();
			
			try {
				Philosoph3.sleep(tbl.getWait());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
