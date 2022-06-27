package dao;

import java.sql.*;
import java.util.ArrayList;
import bean.Purchase;
import bean.Product;
import bean.PurchaseDetail;

public class PurchaseDetailDAO {

	//データベース接続情報
		private static String RDB_DRIVE ="com.mysql.jdbc.Driver";
		private static String URL ="jdbc:mysql://localhost/uniform_db";
		private static String USER ="root";
		private static String PASS ="root123";

		//　データベース接続を行うメソッド
		private static Connection getConnection() {
			try {
				Class.forName(RDB_DRIVE);
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				return con;
			} catch(Exception e){
				throw new IllegalStateException(e);
			}
		}

		//ProductとPurchaseテーブルを結合し、メールアドレスで検索するメソット
		public ArrayList<PurchaseDetail> selectByMailAdress(String mail_adress){

			//変数宣言
			ArrayList<PurchaseDetail> list = new ArrayList<PurchaseDetail>();
			String sql = "SELECT * FROM purchase INNER JOIN product ON purchase.product_id=product.product_id WHERE purchase.mail_adress = '" + mail_adress + "'";
			Connection con = null;
			Statement smt = null;

			try {
				con = getConnection();
				smt = con.createStatement();

				ResultSet rs = smt.executeQuery(sql);

				while (rs.next()) {
					PurchaseDetail purchaseDetail = new PurchaseDetail();
					purchaseDetail.setProduct_id((rs.getInt("product_id")));
					purchaseDetail.setProduct_name((rs.getString("product_name")));
					purchaseDetail.setPrice((rs.getInt("price")));
					purchaseDetail.setExist_products((rs.getInt("exist_products")));
					purchaseDetail.setImage((rs.getString("image")));
					purchaseDetail.setPurchase_id(rs.getInt("purchase_id"));
					purchaseDetail.setMail_adress(rs.getString("mail_adress"));
					purchaseDetail.setProduct_id(rs.getInt("product_id"));
					purchaseDetail.setCount(rs.getInt("count"));
					purchaseDetail.setAmount_money(rs.getInt("amount_money"));
					purchaseDetail.setBuy_date(rs.getString("buy_date"));
					purchaseDetail.setOthers(rs.getString("others"));

					list.add(purchaseDetail);
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

		//ProductとPurchaseテーブルを結合し、注文IDで検索するメソット
		public PurchaseDetail selectByPurchaseId(int purchase_id) {
		//変数宣言
			PurchaseDetail purchaseDetail = new PurchaseDetail();
		String sql = "SELECT * FROM purchase INNER JOIN product ON purchase.product_id=product.product_id WHERE purchase.purchase_id = '" + purchase_id + "'";
		Connection con = null;
		Statement smt = null;

		try {

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				purchaseDetail.setProduct_id((rs.getInt("product_id")));
				purchaseDetail.setProduct_name((rs.getString("product_name")));
				purchaseDetail.setPrice((rs.getInt("price")));
				purchaseDetail.setExist_products((rs.getInt("exist_products")));
				purchaseDetail.setImage((rs.getString("image")));
				purchaseDetail.setPurchase_id(rs.getInt("purchase_id"));
				purchaseDetail.setMail_adress(rs.getString("mail_adress"));
				purchaseDetail.setProduct_id(rs.getInt("product_id"));
				purchaseDetail.setCount(rs.getInt("count"));
				purchaseDetail.setAmount_money(rs.getInt("amount_money"));
				purchaseDetail.setBuy_date(rs.getString("buy_date"));
				purchaseDetail.setOthers(rs.getString("others"));
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
		return purchaseDetail;
	}
}
