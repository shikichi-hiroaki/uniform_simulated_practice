package bean;

public class Product {

	private int product_id;
	private String product_name;
	private int price;
	private int exist_product;
	private String image;

	public Product(){

		this.product_id=0;
		this.product_name=null;
		this.price=0;
		this.exist_product=0;
		this.image=null;
	}

	public void setProduct_id(int product_id) {
		this.product_id=product_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name=product_name;
	}

	public void setPrice(int price) {
		this.price=price;
	}

	public void setExist_product(int exist_product) {
		this.exist_product=exist_product;
	}

	public void setImage(String image) {
		this.image=image;
	}

	public int getProduct_id() {

		return this.product_id;
	}


	public String getProduct_name() {

		return this.product_name;
	}

	public int getPrice() {

		return this.price;
	}

	public int getExist_product() {

		return this.exist_product;
	}

	public String getImage() {

		return this.image;
	}


}
