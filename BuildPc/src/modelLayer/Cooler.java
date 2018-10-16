package modelLayer;

public class Cooler extends Products {
   private String series;
	
	public Cooler(int id, String name, String description, double price, String series){
		super(id, name, description, price);
		this.series = series;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
	
	
	

}
