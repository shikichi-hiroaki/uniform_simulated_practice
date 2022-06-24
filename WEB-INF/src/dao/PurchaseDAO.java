package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Purchase;

public class PurchaseDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/uniform_db";
	private static String USER = "root";
	private static String PASSWD = "root123";

	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// 注文情報全件取得
	public ArrayList<Purchase> selectAll() {

		ArrayList<Purchase> list = new ArrayList<Purchase>();
		String sql = "SELECT * FROM purchase ORDER BY purchase_id";

		Connection con = null;
		Statement smt = null;
		try {
			con = PurchaseDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchase_id(rs.getInt("purchase_id"));
				purchase.setUser_id(rs.getString("user_id"));
				purchase.setUser_name(rs.getString("user_name"));
				purchase.setMail_adress(rs.getString("mail_adress"));
				purchase.setPhone_number(rs.getString("phone_number"));
				purchase.setPlace(rs.getString("place"));
				purchase.setProduct_id(rs.getInt("product_id"));
				purchase.setCount(rs.getInt("count"));
				purchase.setAmount_money(rs.getInt("amount_money"));
				purchase.setBuy_date(rs.getString("buy_date"));
				purchase.setPayment_date(rs.getString("payment_date"));
				purchase.setShopping_date(rs.getString("shopping_date"));
				purchase.setOthers(rs.getString("others"));

				list.add(purchase);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return list;
	}

	// ユーザー登録なしで購入する際のメソット
	public void insert(Purchase purchase) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "INSERT INTO purchase VALUES(null,null,'" + purchase.getUser_name() + "','"
					+ purchase.getmail_adress() + "','" + purchase.getphone_number() + "','" + purchase.getplace()
					+ "'," + purchase.getProduct_id() + "," + purchase.getCount() + "," + purchase.getAmount_money()
					+ ",curdate(),null,null,'" + purchase.getOthers() + "')";

			con = PurchaseDAO.getConnection();
			smt = con.createStatement();

			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);

		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

	// 注文詳細（注文IDでの検索）
	public Purchase selectByPurchaseId(int purchase_id) {

		Connection con = null;
		Statement smt = null;

		Purchase purchase = new Purchase();

		String sql = "select * from uniform_db where  purchase_id='" + purchase_id + "'";

		try {
			con = PurchaseDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				purchase.setPurchase_id(rs.getInt("purchase_id"));
				purchase.setUser_id(rs.getString("user_id"));
				purchase.setUser_name(rs.getString("user_name"));
				purchase.setMail_adress(rs.getString("mail_adress"));
				purchase.setPhone_number(rs.getString("phone_number"));
				purchase.setPlace(rs.getString("place"));
				purchase.setProduct_id(rs.getInt("product_id"));
				purchase.setCount(rs.getInt("count"));
				purchase.setAmount_money(rs.getInt("amount_money"));
				purchase.setBuy_date(rs.getString("buy_date"));
				purchase.setPayment_date(rs.getString("payment_name"));
				purchase.setShopping_date(rs.getString("shopping_date"));
				purchase.setOthers(rs.getString("others"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return purchase;
	}

	// 注文詳細（ユーザーID）
	public ArrayList<Purchase> selectByUserId(String user_id) {

		// 変数宣言
		Connection con = null;
		Statement smt = null;
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		Purchase purchase = new Purchase();

		String sql = "select * from uniform_db where user_id ='" + user_id + "'";

		try {
			con = PurchaseDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				purchase.setPurchase_id(rs.getInt("purchase_id"));
				purchase.setUser_id(rs.getString("user_id"));
				purchase.setUser_name(rs.getString("user_name"));
				purchase.setMail_adress(rs.getString("mail_adress"));
				purchase.setPhone_number(rs.getString("phone_number"));
				purchase.setPlace(rs.getString("place"));
				purchase.setProduct_id(rs.getInt("product_id"));
				purchase.setCount(rs.getInt("count"));
				purchase.setAmount_money(rs.getInt("amount_money"));
				purchase.setBuy_date(rs.getString("buy_date"));
				purchase.setPayment_date(rs.getString("payment_name"));
				purchase.setShopping_date(rs.getString("shopping_date"));
				purchase.setOthers(rs.getString("others"));

				list.add(purchase);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return list;
	}
}
