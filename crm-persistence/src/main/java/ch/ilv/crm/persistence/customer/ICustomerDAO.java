/**
 * The interface ICustomerDAO provides methods to perform CRUD operations
 * for the customer management
 */

package ch.ilv.crm.persistence.customer;

//Interface declaration
public interface ICustomerDAO {
	
	/**
	 * Inserts the data of a customer as an Array
	 * @param customer the customer
	 */
	public void insertCustomer(String[] customer);
	
	/**
	 * @param customerId the customer id
	 * @return The Data of the selected customer as an Array
	 */
	public String[] selectCustomer(int customerId);
	
}