
public class priceCalculator implements priceGetter{
	
	private final int BASIC_TAX = 10;
	private final int IMPORT_TAX = 5;
	
	private double round(double number) {
		return Math.round(number * 20.0) / 20.0;
	}
	
	@Override
	public double calculateBasicSalesTax(Good good) {
		if(good.isExcepted() == false) {
			double priceWithTax = good.getPrice() + (good.getPrice() * BASIC_TAX) / 100;
			double roundedPriceWithTax = round(priceWithTax);
			return roundedPriceWithTax;
		}
		return good.getPrice();
	}
	
	@Override
	public double calculateImportTax(Good good) {
		double currentPrice = calculateBasicSalesTax(good);
		if(good.isImported() == true) {
			double priceWithImport = currentPrice + (currentPrice * IMPORT_TAX) / 100;
			double roundedPriceWithImport = round(priceWithImport);
			return roundedPriceWithImport;
		}
		return currentPrice;
	}
	
	@Override
	public double calculateTotalSalesTaxes(Good good) {
		double basicIncrement = 0;
		double importIncrement = 0;
		
		if(good.isExcepted() == false)
			basicIncrement += (good.getPrice() * BASIC_TAX) / 100;

		if(good.isImported() == true)
			importIncrement += ((good.getPrice() + basicIncrement) * IMPORT_TAX) / 100;
		
		
		return round(basicIncrement + importIncrement) * good.getQuantity();
	}


	@Override
	public double getPrice(Good good) {
		return calculateImportTax(good) * good.getQuantity();
	}


}
