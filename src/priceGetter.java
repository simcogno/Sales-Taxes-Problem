
public interface priceGetter {
	
	public double calculateBasicSalesTax(Good good);
	public double calculateImportTax(Good good);
	public double getPrice(Good good);
	public double calculateTotalSalesTaxes(Good perfume);

}
