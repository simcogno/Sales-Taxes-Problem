
public class Good {
	
	private String name;
	private int quantity;
	private double price;
	private boolean imported, excepted;
	
	public Good(String name, int quantity, double price, boolean imported, boolean excepted) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.imported = imported;
		this.excepted = excepted;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean isImported() {
		return imported;
	}
	
	public boolean isExcepted() {
		return excepted;
	}

}
