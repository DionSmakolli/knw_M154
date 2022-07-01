/**
 * The class ProductDAOFactory is a factory for DAO implementations.
 */

package ch.ilv.crm.persistence.product;

public class ProductDAOFactory {
	/**
	 * The singleton instance of the ProductDAOFactory
	 */
	private static ProductDAOFactory theInstance = null;
	
	
	/**
	 * The default constructor oft the ProductDAOFactory
	 */
	private ProductDAOFactory() {
	}
	
	/**
	 * @return The Singleton of the ProductDAOFactory
	 */
	public static ProductDAOFactory getInstance(){
		if(theInstance == null){
			theInstance = new ProductDAOFactory();
		}
		return theInstance;
	}
	
	/**
	 * Creates a concrete ICustomerDAO (interface)
	 * @return The ICustomerDAO
	 */
	public IProductDAO createProductDAO(){
		return new ProductDataAccessMock();
	}
}
