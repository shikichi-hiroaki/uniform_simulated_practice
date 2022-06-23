package bean;

public class User {

	private String user_id;//ユーザーID
	private String user_name;//ユーザー名
	private String mail_adress;//メールアドレス
	private String place;//住所
	private String phone_number;//電話番号
	private String password;//パスワード
	private int authority;//権限

	public User() {
		user_id = null;
		user_name = null;
		mail_adress = null;
		place = null;
		phone_number = null;
		password = null;
		authority = 0;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public String getUser_id() {
		return this.user_id;
	}

	public String getUser_name() {
		return this.user_name;
	}

	public String getMail_adress() {
		return this.mail_adress;
	}

	public String getPlace() {
		return this.place;
	}

	public String getPhone_number() {
		return this.phone_number;
	}

	public String getPassword() {
		return this.password;
	}

	public int getAuthority() {
		return this.authority;
	}
}
