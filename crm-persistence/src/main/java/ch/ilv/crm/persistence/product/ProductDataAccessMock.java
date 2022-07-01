/**
 * The class DataAccessMock is a mock implementation of the interface Product
 * and using a list as in-memory data storage (like a database).
 */

package ch.ilv.crm.persistence.product;

import java.util.ArrayList;
import java.util.UUID;

import ch.ilv.crm.persistence.product.dto.ProductDTO;

public class ProductDataAccessMock implements IProductDAO {
	
	/**
	 * The in-memory data storage.
	 */	
	private ArrayList<ProductDTO> products = null;
	
	/**
	 * The default constructor 
	 */
	public ProductDataAccessMock() {		
		products = new ArrayList<ProductDTO>();		
	}

	/**
	 * @param product The product is the Data of an product
	 */
	@Override
	public void insertProduct(ProductDTO product) {
		if (product.getId() == -1) {
			product.setId(products.size());
		}
		this.products.add(product);
	}

	/**
	 * @param productId The productId is the ID of the wanted Product
	 */
	@Override
	public ProductDTO selectProduct(int productId) {
		ProductDTO result = null;
		
		for (ProductDTO productDTO : products) {
			if (productDTO.getId() == productId) {
				result = productDTO;
				break;
			}
		}
		
		return result;
	}
}
