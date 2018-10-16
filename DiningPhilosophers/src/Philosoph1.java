
 public class Philosoph1 extends Thread{

	Table tbl = Table.getInstance();
		
	
	@Override
	public void run() {

		while (tbl.isAct()){
			if(tbl.isChopstick1() && tbl.isChopstick5()){
				tbl.setChopstick1(false);
				tbl.setChopstick5(false);
				tbl.setP1eat();
				tbl.setChopstick1(true);
				tbl.setChopstick5(true);
							
			}
			 
			tbl.setP1think();
			
			try {
				Philosoph1.sleep(tbl.getWait());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
