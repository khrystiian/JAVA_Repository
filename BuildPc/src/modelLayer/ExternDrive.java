package modelLayer;

public class ExternDrive extends Products {
     private String type;
      
     public ExternDrive(int id, String name, String description, double price, String type){
    	 super(id, name, description, price);
    	 this.type = type;    	 
     }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
     
}
