package bean;

public class Product {

	private int product_id;//商品ID
	private String product_name;//商品名
	private int price;//価格
	private int exist_products;//在庫数
	private String image;//画像

	public Product(){

		this.product_id=0;
		this.product_name=null;
		this.price=0;
		this.exist_products=0;
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

	public void setExist_products(int exist_products) {
		this.exist_products=exist_products;
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

	public int getExist_products() {

		return this.exist_products;
	}

	public String getImage() {

		return this.image;
	}


}
