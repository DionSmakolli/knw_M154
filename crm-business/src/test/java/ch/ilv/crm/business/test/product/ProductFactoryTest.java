/**
 * The class ProductFactoryTest implements tests for implementations of the interface IProduct.
 */

package ch.ilv.crm.business.test.product;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.ilv.crm.business.product.IProduct;
import ch.ilv.crm.business.product.ProductFactory;

public class ProductFactoryTest {
		
	private final static int EXPECTED_PRODUCT_ID = 0;
	private final static String EXPECTED_PRODUCT_DESC = "Test Produkt 1";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	@Test
	public void testInsertAndSelectProduct() {
		
		IProduct prod = ProductFactory.getInstance().createProduct(EXPECTED_PRODUCT_DESC);
		prod.setId(EXPECTED_PRODUCT_ID);
		
		ProductFactory.getInstance().saveProduct(prod);
		System.out.println("-Produkt: " + prod.getDescription() + " wurde erfolgreich gespeichert");
		
		IProduct selectedProduct= ProductFactory.getInstance().findProduct(EXPECTED_PRODUCT_ID);
		
		assertEquals("Wrong Id!", EXPECTED_PRODUCT_ID, selectedProduct.getId());	
		assertEquals("Wrong Forename!", EXPECTED_PRODUCT_DESC, selectedProduct.getDescription());
		
		System.out.println("\nDas Produkt: " + selectedProduct.getId() + " " 
							+ selectedProduct.getDescription() + " wurde erfolgreich gefunden.");
	}

}
