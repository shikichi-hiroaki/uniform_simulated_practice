package bean;

public class Purchase {

	// フィールド変数
	private int purchase_id; // 購入ID
	private String user_id; // ユーザーID
	private String user_name; //ユーザー名
	private String product_id; // 商品ID
	private int count; // 注文数
	private int amount_money; // 金額
	private String buy_date; // 購入日
	private String payment_date; // 入金日
	private String shopping_date; // 発送日
	private String others; // 備考欄
	private String mail_adress; //メールアドレス
	private String place;	//住所
	private String phone_number;	//電話番号

	// コンストラクタ
	public Purchase() {

		this.purchase_id = 0;
		this.user_id = null;
		this.user_name = null;
		this.product_id = null;
		this.count = 0;
		this.amount_money = 0;
		this.buy_date = null;
		this.payment_date = null;
		this.shopping_date = null;
		this.others = null;
		this.mail_adress = null;
		this.place = null;
		this.phone_number = null;

	}

	// setメソッド
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setProduct_id(String product_id) {
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

	public void setPament_date(String pament_date) {
		this.payment_date = pament_date;
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
	public void setPlace(String place) {
		this.place = place;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	// getメソッド
	public int getPurchase_id() {
		return purchase_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getProduct_id() {
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

	public String getPament_date() {
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

	public String getplace() {
		return place;
	}

	public String getphone_number() {
		return phone_number;
	}
}

