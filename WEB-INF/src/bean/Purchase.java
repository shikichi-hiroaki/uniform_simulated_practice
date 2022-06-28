package bean;

public class Purchase {

	// フィールド変数
	private int purchase_id; // 購入ID
	private int product_id; // 商品ID
	private int count; // 注文数
	private int amount_money; // 金額
	private String buy_date; // 購入日
	private String payment_date; // 入金日
	private String shopping_date; // 発送日
	private String others; // 備考欄
	private String mail_adress; // メールアドレス

	// コンストラクタ
	public Purchase() {

		this.purchase_id = 0;
		this.product_id = 0;
		this.count = 0;
		this.amount_money = 0;
		this.buy_date = null;
		this.payment_date = null;
		this.shopping_date = null;
		this.others = null;
		this.mail_adress = null;


	}

	// setメソッド
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
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

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public void setShopping_date(String shopping_date) {
		this.shopping_date = shopping_date;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public void setMail_adress(String mail_adress) {
		this.mail_adress = mail_adress;
	}


	// getメソッド
	public int getPurchase_id() {
		return purchase_id;
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

	public String getPayment_date() {
		return payment_date;
	}

	public String getShopping_date() {
		return shopping_date;
	}

	public String getOthers() {
		return others;
	}

	public String getmail_adress() {
		return mail_adress;
	}


}
