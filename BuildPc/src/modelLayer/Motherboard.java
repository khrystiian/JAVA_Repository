package modelLayer;

public class Motherboard extends Products {
  private String pci, series, type, socket;
  
  public Motherboard(int id, String name, String description, double price, String socket, String series, String pci, String type){
       super(id, name, description, price);
       this.socket  = socket;
       this.series = series;
       this.pci = pci;
       this.type = type;
  }

public String getPci() {
	return pci;
}

public void setPci(String pci) {
	this.pci = pci;
}

public String getSeries() {
	return series;
}

public void setSeries(String series) {
	this.series = series;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getSocket() {
	return socket;
}

public void setSocket(String socket) {
	this.socket = socket;
}
  
  
}
