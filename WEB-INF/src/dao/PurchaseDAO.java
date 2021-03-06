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
				purchase.setMail_adress(rs.getString("mail_adress"));
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
			String sql = "INSERT INTO purchase VALUES(null,'" + purchase.getmail_adress() + "',"
					+ purchase.getProduct_id() + "," + purchase.getCount() + "," + purchase.getAmount_money()
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

		String sql = "select * from purchase where purchase_id=" + purchase_id;

		try {
			con = PurchaseDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				purchase.setPurchase_id(rs.getInt("purchase_id"));
				purchase.setMail_adress(rs.getString("mail_adress"));
				purchase.setProduct_id(rs.getInt("product_id"));
				purchase.setCount(rs.getInt("count"));
				purchase.setAmount_money(rs.getInt("amount_money"));
				purchase.setBuy_date(rs.getString("buy_date"));
				purchase.setPayment_date(rs.getString("payment_date"));
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

	// 注文詳細（メールアドレス）
	public ArrayList<Purchase> selectByUserId(String mail_adress) {

		// 変数宣言
		Connection con = null;
		Statement smt = null;
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		Purchase purchase = new Purchase();

		String sql = "select * from uniform_db where mail_adress ='" + mail_adress + "'";

		try {
			con = PurchaseDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				purchase.setPurchase_id(rs.getInt("purchase_id"));
				purchase.setMail_adress(rs.getString("mail_adress"));
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

	// 入金日を更新
	public void updatePayment(String payment_date, String purchase_id) {
		Connection con = null;
		Statement smt = null;

		String sql = "UPDATE purchase SET payment_date ='" + payment_date + "' WHERE purchase_id = " + purchase_id + "";

		try {

			con = getConnection();
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

	// 発送日を更新
	public void updateShopping(String shopping_date, String purchase_id) {
		Connection con = null;
		Statement smt = null;

		String sql = "UPDATE purchase SET shopping_date ='" + shopping_date + "' WHERE purchase_id = " + purchase_id
				+ "";

		try {

			con = getConnection();
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

	// 月ごとの売上を取得するメソッド
	public ArrayList<Purchase> monthlySales(String yearMonth) {

		Connection con = null;
		Statement smt = null;
		ArrayList<Purchase> monthlySalesList = new ArrayList<Purchase>();
		String sql = "SELECT purchase_id,amount_money FROM purchase WHERE buy_date LIKE '" + yearMonth + "%'";

		try {
			con = PurchaseDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchase_id(rs.getInt("purchase_id"));
				purchase.setAmount_money(rs.getInt("Amount_money"));

				monthlySalesList.add(purchase);
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
		return monthlySalesList;
	}

}
