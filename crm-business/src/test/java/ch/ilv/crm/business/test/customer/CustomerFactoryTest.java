/**
 * The class CustomerFactoryTest implements tests for implementations of the interface ICustomer.
 */

package ch.ilv.crm.business.test.customer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.ilv.crm.business.customer.CustomerFactory;
import ch.ilv.crm.business.customer.ICustomer;

public class CustomerFactoryTest {
		
	private final static String EXPECTED_NAME = "Kunde";
	private final static String EXPECTED_FORENAME = "Drei";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsertAndSelectCustomer() {
		
		ICustomer customer_1 = CustomerFactory.getInstance().createCustomer("Kunde", "Eins");
		ICustomer customer_2 = CustomerFactory.getInstance().createCustomer("Kunde", "Zwei");
		ICustomer customer_3 = CustomerFactory.getInstance().createCustomer("Kunde", "Drei");
		ICustomer customer_4 = CustomerFactory.getInstance().createCustomer("Kunde", "Vier");
		
		CustomerFactory.getInstance().saveCustomer(customer_1);
		System.out.println("-Kunde: " + customer_1.getName() + " wurde erfolgreich gespeichert");
		
		CustomerFactory.getInstance().saveCustomer(customer_2);
		System.out.println("-Kunde: " + customer_2.getName() + " wurde erfolgreich gespeichert");
		
		CustomerFactory.getInstance().saveCustomer(customer_3);
		System.out.println("-Kunde: " + customer_3.getName() + " wurde erfolgreich gespeichert");
		
		CustomerFactory.getInstance().saveCustomer(customer_4);
		System.out.println("-Kunde: " + customer_4.getName() + " wurde erfolgreich gespeichert");
		
		
		ICustomer selectedCustomer = CustomerFactory.getInstance().findCustomer(2);
		
		assertEquals("Wrong Name!", EXPECTED_NAME, selectedCustomer.getName());	
		assertEquals("Wrong Forename!", EXPECTED_FORENAME, selectedCustomer.getForename());
		
		System.out.println("\nDer Kunde: " + selectedCustomer.getName() + " " 
							+ selectedCustomer.getForename() + " wurde erfolgreich gefunden.");
	}
	
}
