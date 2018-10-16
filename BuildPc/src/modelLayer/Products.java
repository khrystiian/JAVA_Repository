package modelLayer;

public abstract class Products {
	String name, description;
	int id;
	double price= 0.0;
	
	public Products(int id, String name, String description, double price){
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [name=" + name + ", description=" + description + ", id=" + id + ", price=" + price + "]";
	}
	

}
