
public class Philosoph2 extends Thread{

	Table tbl = Table.getInstance();
	@Override
	public void run() {
		
		while (tbl.isAct()){
			if(tbl.isChopstick1() && tbl.isChopstick2()){
				tbl.setChopstick1(false);
				tbl.setChopstick2(false);
				tbl.setP2eat();
				tbl.setChopstick1(true);
				tbl.setChopstick2(true);
							
			}
			 
			tbl.setP2think();
			
			try {
				Philosoph2.sleep(tbl.getWait());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
