package ch.ilv.crm.persistence.product.dto;

public class ProductDTO {
	private int id = -1;
	private String desciption = null;
	
	public ProductDTO(int id, String desc) {
		this.id = id;
		this.desciption = desc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
}
