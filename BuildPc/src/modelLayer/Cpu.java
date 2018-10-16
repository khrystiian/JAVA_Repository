package modelLayer;

public class Cpu extends Products {
	private String socket;
	
	public Cpu(int id, String name, String description, double price, String socket){
		super(id, name, description, price);
		this.socket = socket;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}
	

}
