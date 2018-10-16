
public class Philosoph5  extends Thread{

	Table tbl = Table.getInstance();
	
	
	
	@Override
	public void run() {
		
		
		while (tbl.isAct()){
			if(tbl.isChopstick5() && tbl.isChopstick4()){
				tbl.setChopstick5(false);
				tbl.setChopstick4(false);
				tbl.setP5eat();
				tbl.setChopstick5(true);
				tbl.setChopstick4(true);
							
			}
			 
			tbl.setP5think();
			
			try {
				Philosoph5.sleep(tbl.getWait());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	

}
