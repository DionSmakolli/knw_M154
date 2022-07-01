/**
 * The class ProductFactory is a factory for Product implementations.
 */

package ch.ilv.crm.business.product;

import java.util.UUID;

import ch.ilv.crm.persistence.product.IProductDAO;
import ch.ilv.crm.persistence.product.ProductDAOFactory;
import ch.ilv.crm.persistence.product.dto.ProductDTO;

public class ProductFactory {
	/**
	 * The singleton instance of the DataAccessFactory
	 */
	private static ProductFactory theInstance = null;
	
	
	/**
	 * The DAO instance of the product 
	 */
	private IProductDAO productDAO = null;
	
	
	/**
	 * The default constructor oft the ProductFactory
	 */
	private ProductFactory() {
		productDAO = ProductDAOFactory.getInstance().createProductDAO();
	}
	
	/**
	 * @return The Singleton of the DataAccessFatory
	 */
	public static ProductFactory getInstance(){
		if(theInstance == null){
			theInstance = new ProductFactory();
		}
		return theInstance;
	}
	
	/**
	 * Creates a new product object with id and description set
	 * @param desc the description of the product
	 * @return IProduct
	 */	
	public IProduct createProduct(String desc){
		return new BCProduct(desc);
	}
	
	/**
	 * Saves a product object
	 * @param product
	 */
	public void saveProduct(IProduct product){	
		productDAO.insertProduct(new ProductDTO(product.getId(), product.getDescription()));;
	}
	
	/**
	 * Finds a data object.
	 * @param productId
	 * @return IProduct object or null if there is no product object with the given productId 
	 */
	public IProduct findProduct(int productId){
		ProductDTO productDTO = productDAO.selectProduct(productId);
		
		if(productDTO == null){
			return null;
		}
		
		return new BCProduct(productDTO.getId(), productDTO.getDesciption());
	}
	
}
