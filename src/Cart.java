import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Good> goods;
	private priceGetter pricer;
	
	public Cart(priceGetter pricer) {
		goods = new ArrayList<Good>();
		this.pricer = pricer;
	}

	public void add(Good good) {
		goods.add(good);
	}

	public double calculateReceiptPrice() {
		double total = 0;
		for(Good x : goods) 
			total += pricer.getPrice(x);
		return total;
	}
	
	public double calculateSalesTaxes() {
		double taxes = 0;
		for(Good x : goods) 
			taxes += pricer.calculateTotalSalesTaxes(x);
		return taxes;
	}

	public String[] printReceipt() {
		return receiptFormatter.createReceipt(goods, calculateSalesTaxes(), 
											calculateReceiptPrice(), pricer);
	}

}
