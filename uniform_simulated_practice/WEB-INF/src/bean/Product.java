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

	public void Product_id(int product_id) {
		this.product_id=product_id;
	}

	public void Product_name(String product_name) {
		this.product_name=product_name;
	}

	public void price(int price) {
		this.price=price;
	}

	public void exist_product(int exist_product) {
		this.exist_product=exist_product;
	}

	public void image(String image) {
		this.image=image;
	}

	public int Product_id() {

		return this.product_id;
	}


	public String product_name() {

		return this.product_name;
	}

	public int price() {

		return this.price;
	}

	public int exist_product() {

		return this.exist_product;
	}

	public String image() {

		return this.image;
	}


}
