//過去の注文履歴を表示するため、PurchaseとProductを結合し、使用するためのクラス

package bean;

public class PurchaseDetail {

	//変数宣言
	private int product_id;// 商品ID
	private String product_name;// 商品名
	private int price;// 価格
	private int exist_products;// 在庫数
	private String image;// 画像
	private int on_sale;// 販売状況
	private int purchase_id; // 購入ID
	private String mail_adress;//メールアドレス
	private int count; // 注文数
	private int amount_money; // 金額
	private String buy_date; // 購入日
	private String others; // 備考欄

	//コンストラクタ
	public PurchaseDetail() {
		this.product_id = 0;
		this.product_name = null;
		this.price = 0;
		this.exist_products = 0;
		this.image = null;
		this.on_sale = 0;
		this.purchase_id = 0;
		this.mail_adress = null;
		this.product_id = 0;
		this.count = 0;
		this.amount_money = 0;
		this.buy_date = null;
		this.others = null;
	}


	// setメソッド
		public void setPurchase_id(int purchase_id) {
			this.purchase_id = purchase_id;
		}

		public void setMail_adress(String mail_adress) {
			this.mail_adress = mail_adress;
		}

		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public void setAmount_money(int amount_money) {
			this.amount_money = amount_money;
		}

		public void setBuy_date(String buy_date) {
			this.buy_date = buy_date;
		}

		public void setOthers(String others) {
			this.others = others;
		}

		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public void setExist_products(int exist_products) {
			this.exist_products = exist_products;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public void setOn_sale(int on_sale) {
			this.on_sale = on_sale;
		}


		// getメソッド
		public int getPurchase_id() {
			return purchase_id;
		}

		public String getMail_adress() {
			return mail_adress;
		}


		public int getProduct_id() {
			return product_id;
		}

		public int getCount() {
			return count;
		}

		public int getAmount_money() {
			return amount_money;
		}

		public String getBuy_date() {
			return buy_date;
		}

		public String getOthers() {
			return others;
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

		public int getOn_sale() {
			return this.on_sale;
		}
}
