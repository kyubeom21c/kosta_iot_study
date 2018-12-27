package test.com;

public class Test04NoteBookVO {

	private String productNO;
	private String productName;
	private String modelName;
	private int price;

	public Test04NoteBookVO() {
	}

	public Test04NoteBookVO(String productNO, String productName, String modelName, int price) {
		this.productNO = productNO;
		this.productName = productName;
		this.modelName = modelName;
		this.price = price;
	}

	public void setProductNO(String productNO) {
		this.productNO = productNO;
	}

	public String getProductNO() {
		return productNO;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
