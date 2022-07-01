/**
 * The class DataAccessMockTest implements tests 
 * for implementations of the interface ICustomerDAO.
 */

package ch.ilv.crm.persistence.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.ilv.crm.persistence.customer.CustomerDAOFactory;
import ch.ilv.crm.persistence.customer.ICustomerDAO;
import ch.ilv.crm.persistence.product.IProductDAO;
import ch.ilv.crm.persistence.product.ProductDAOFactory;
import ch.ilv.crm.persistence.product.dto.ProductDTO;

public class DataAccessMockTest {
	
	// The DAO of the customer
	private ICustomerDAO theICustomerDAO = null;
	
	// The DAO of the product
	private IProductDAO theIProductDAO = null;
	
	// Test fixture for tesing
	private final static String EXPECTED_NAME = "Kunde";
	private final static String EXPECTED_FORENAME = "Eins";
	private final static int EXPECTED_PRODUCT_ID = 0;
	private final static String EXPECTED_PRODUCT_DESC = "Test Produkt 1";
	
	protected final String[] customerNames = {"Kunde", "Kunde", "Kunde", "Kunde"};
	protected final String[] customerForenames = {"Eins", "Zwei", "Drei", "Vier"};
	
	@Before
	public void setUp() throws Exception {
		theICustomerDAO = CustomerDAOFactory.getInstance().createCustomerDAO();
		theIProductDAO = ProductDAOFactory.getInstance().createProductDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertAndSelectCustomer() {
		
		// Save the customer data
		for (int i = 0; i < customerNames.length; i++) {
			String[] customerData = new String[2];
			customerData[0] = customerNames[i];
			customerData[1] = customerForenames[i];			
			
			theICustomerDAO.insertCustomer(customerData);
		}	
		
		// Get the selected customer an put it in a array
		String[] selectedCustomer = theICustomerDAO.selectCustomer(0);
		
		// Testing the functions
		assertEquals("Wrong Name!", EXPECTED_NAME, selectedCustomer[0]);	
		assertEquals("Wrong Forename!", EXPECTED_FORENAME, selectedCustomer[1]);	
	}
	
	@Test
	public void testInsertAndSelectProduct() {
		
		ProductDTO prod = new ProductDTO(EXPECTED_PRODUCT_ID, EXPECTED_PRODUCT_DESC);
		theIProductDAO.insertProduct(prod);
		
		ProductDTO selectedProduct = theIProductDAO.selectProduct(EXPECTED_PRODUCT_ID);
		
		assertEquals("Wrong Id!", EXPECTED_PRODUCT_ID, selectedProduct.getId());	
		assertEquals("Wrong Description!", EXPECTED_PRODUCT_DESC, selectedProduct.getDesciption());	
	}
}
