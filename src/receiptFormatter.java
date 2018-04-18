import java.util.List;

public class receiptFormatter {
	
	public static String[] createReceipt(List<Good> goods, double taxes, double total,
										priceGetter pricer) {
		
		String[] receipt = new String[goods.size()+2];
		
		for(int i = 0; i < goods.size(); i++) {
			Good current = goods.get(i);
			String imported = "";
			if(current.isImported())
				imported = "imported";
			
			receipt[i] = current.getQuantity() + " " + imported + " " + current.getName()
						+ ": " + pricer.getPrice(current);
			
		}
		
		receipt[receipt.length-2] = "Sales Taxes: " + taxes;
		receipt[receipt.length-1] = "Total: " + total;
		
		return receipt;
	}

}
