package modelLayer;

public class GraphicsCard extends Products {
    private String pci;
    
    public GraphicsCard(int id, String name, String description, double price, String pci){
    	super(id, name, description, price);
    	this.pci = pci;
    }

	public String getPci() {
		return pci;
	}

	public void setPci(String pci) {
		this.pci = pci;
	}
    
}
