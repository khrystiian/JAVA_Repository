import java.util.Random;

// This class represents the table where the philosophers are seating

public class Table {
	
	

	public static Table instance;
	public static boolean act = true;
	
    /* Chopstick1..5 represents the 5 chopsticks available at the table
	Philosoph1 will be able to use chopstick1 and chopstick5
	Philosoph2 will be able to use chopstick1 and chopstick2
	Philosoph3 will be able to use chopstick2 and chopstick3
	Philosoph4 will be able to use chopstick3 and chopstick4
	Philosoph5 will be able to use chopstick4 and chopstick5
	Each chopstick is set to true if is available and is set to false if is in use by one of the philosophers
	*/
	
	private boolean chopstick1 = true;  
	private boolean chopstick2 = true;
	private boolean chopstick3 = true;
	private boolean chopstick4 = true;
	private boolean chopstick5 = true;
	
	private int p1eat = 0;    //p1eat will keep the count of how many times philosoph1 is eating 
	private int p1think = 0;  //p1think will keep the count of how many time philosoph1 is thinking
	private int p2eat = 0;    //p2eat will keep the count of how many times philosoph2 is eating
	private int p2think = 0;  //p2think will keep the count of how many time philosoph2 is thinking
	private int p3eat = 0;    //p3eat will keep the count of how many times philosoph3 is eating
	private int p3think = 0;  //p3think will keep the count of how many time philosoph3 is thinking
	private int p4eat = 0;    //p4eat will keep the count of how many times philosoph4 is eating
	private int p4think = 0;  //p4think will keep the count of how many time philosoph4 is thinking
	private int p5eat = 0;    //p5eat will keep the count of how many times philosoph5 is eating
	private int p5think = 0;  //p5think will keep the count of how many time philosoph5 is thinking
	
		
	public static Table getInstance(){
		if(instance == null)
			instance = new Table();
		return instance;
	}
			
	Random x = new Random();
	 private int wait;
	
	public int getWait(){
		
		return  wait = x.nextInt(1000);
	}
	
	public boolean isAct(){
		return act;
	}
	
	public void setAct(boolean act){
		this.act = act;
	}
	
	public boolean isChopstick1() {
		return chopstick1;
	}
	public void setChopstick1(boolean chopstick1) {
		this.chopstick1 = chopstick1;
	}
	public boolean isChopstick2() {
		return chopstick2;
	}
	public void setChopstick2(boolean chopstick2) {
		this.chopstick2 = chopstick2;
	}
	public boolean isChopstick3() {
		return chopstick3;
	}
	public void setChopstick3(boolean chopstick3) {
		this.chopstick3 = chopstick3;
	}
	public boolean isChopstick4() {
		return chopstick4;
	}
	public void setChopstick4(boolean chopstick4) {
		this.chopstick4 = chopstick4;
	}
	public boolean isChopstick5() {
		return chopstick5;
	}
	public void setChopstick5(boolean chopstick5) {
		this.chopstick5 = chopstick5;
	}
	public int getP1eat() {
		return p1eat;
	}
	public void setP1eat() {
		p1eat ++;
	}
	public int getP1think() {
		return p1think;
	}
	public void setP1think() {
		p1think ++;
	}
	public int getP2eat() {
		return p2eat;
	}
	public void setP2eat() {
		 p2eat ++;
	}
	public int getP2think() {
		return p2think;
	}
	public void setP2think() {
		p2think ++;
	}
	public int getP3eat() {
		return p3eat;
	}
	public void setP3eat() {
		p3eat ++;
	}
	public int getP3think() {
		return p3think;
	}
	public void setP3think() {
		p3think ++;
	}
	public int getP4eat() {
		return p4eat;
	}
	public void setP4eat() {
		p4eat ++;
	}
	public int getP4think() {
		return p4think;
	}
	public void setP4think() {
		p4think ++;
	}
	public int getP5eat() {
		return p5eat;
	}
	public void setP5eat() {
		p5eat ++;
	}
	public int getP5think() {
		return p5think;
	}
	public void setP5think() {
		p5think ++;
	}
	
	
}
