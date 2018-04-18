import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesTaxesTest {
	
	private Cart cart;
	private Good perfume, chocoBox, book;
	private priceGetter priceGetter;

	@Before
	public void setUp() throws Exception {
		priceGetter = new priceCalculator();
		cart = new Cart(priceGetter);
		perfume = new Good("bottle of perfume", 1, 47.50, true, false);
		chocoBox = new Good("box of chocolates", 1, 10.00, true, true);
		book = new Good("book", 2, 12.49, false, true);
	}

	@Test
	public void retrieveGoodInformation() {
		assertEquals("bottle of perfume", perfume.getName());
		assertEquals(1, perfume.getQuantity());
		assertEquals(47.50, perfume.getPrice(), 0);
		assertTrue(perfume.isImported());
		assertFalse(perfume.isExcepted());
	}
	
	@Test
	public void calculateBasicSalesTax() {
		assertEquals(52.25, priceGetter.calculateBasicSalesTax(perfume), 0);
	}
	
	@Test
	public void calculateImportTax() {
		assertEquals(10.50, priceGetter.calculateImportTax(chocoBox), 0);
	}
	
	@Test
	public void calculateBothTaxes() {
		assertEquals(54.85, priceGetter.calculateImportTax(perfume), 0);
	}
	
	@Test
	public void calculateTotalOfSalesTaxes() {
		double perfumeSalesTaxes = priceGetter.calculateTotalSalesTaxes(perfume);
		assertEquals(7.35, perfumeSalesTaxes, 0);
	}
	
	@Test
	public void calculateTotalPrice() {
		assertEquals(54.85, priceGetter.getPrice(perfume), 0);
		assertEquals(24.98, priceGetter.getPrice(book), 0);
	}
	
	@Test
	public void addItemToCart() {
		cart.add(perfume);
	}
	
	@Test
	public void receiptPrice() {
		cart.add(perfume);
		cart.add(chocoBox);
		assertEquals(65.35, cart.calculateReceiptPrice(), 0);
	}
	
	@Test
	public void receiptSalesTaxes() {
		cart.add(perfume);
		cart.add(chocoBox);
		assertEquals(7.85, cart.calculateSalesTaxes(), 0);
	}
	
	@Test
	public void receipt() {
		cart.add(perfume);
		cart.add(chocoBox);
		String[] output = { "1 imported bottle of perfume: 54.85",
							"1 imported box of chocolates: 10.5",
							"Sales Taxes: 7.85",
							"Total: 65.35"};
		assertEquals(output, cart.printReceipt());
		}
	}


