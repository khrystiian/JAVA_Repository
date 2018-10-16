
public class Philosoph4  extends Thread{
 
	Table tbl = Table.getInstance();
	
	@Override
	public void run() {
		
		while (tbl.isAct()){
			if(tbl.isChopstick3() && tbl.isChopstick4()){
				tbl.setChopstick3(false);
				tbl.setChopstick4(false);
				tbl.setP4eat();
				tbl.setChopstick3(true);
				tbl.setChopstick4(true);
							
			}
			 
			tbl.setP4think();
			
			try {
				Philosoph4.sleep(tbl.getWait());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
