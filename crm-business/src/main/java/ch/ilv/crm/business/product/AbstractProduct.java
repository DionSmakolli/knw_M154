package ch.ilv.crm.business.product;

public class AbstractProduct implements IProduct {
	private int id = -1;
	private String description = "";
	
	public AbstractProduct(int id, String desciption) {
		this.id = id;
		this.description = desciption;
	}
	
	public AbstractProduct(String desciption) {
		this.description = desciption;
	}
	
	@Override
	public void setDescription(String desc) {
		this.description = desc;
	}
	@Override
	public String getDescription() {
		return this.description;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
