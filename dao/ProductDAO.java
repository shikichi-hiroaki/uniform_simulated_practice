package dao;

import java.sql.*;
import java.util.*;
import bean.Product;

public class ProductDAO {
	//　データベース接続情報
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

	//　全商品情報を取得するメソッド
	public ArrayList<Product> selectAll() {
		Connection con = null;
		Statement smt = null;
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM product";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Product product = new Product();
				product.setProduct_id((rs.getInt("product_id")));
				product.setProduct_name((rs.getString("product_name")));
				product.setPrice((rs.getInt("price")));
				product.setExist_products((rs.getInt("exist_products")));
				product.setImage((rs.getString("image")));
				productList.add(product);
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
		return productList;
	}

	//　商品を登録するメソッド
	public void insert(Product product) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "INSERT INTO product VALUES(null,'" +  product.getProduct_name() + "',"
					+  product.getPrice() + ", " + product.getExist_products() + ", '" + product.getImage() + "')";
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

	public void update(Product product) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "UPDATE product SET "
						+ "product_name='" + product.getProduct_name() + "',"
						+ "price=" + product.getPrice() + ","
						+ "exist_products=" + product.getExist_products() + ","
						+ "image='" + product.getImage() + "' "
						+ "where product_id=" + product.getProduct_id();
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

	//　商品情報を取得するメソッド
	public Product selectByProductid(int product_id) {

		Connection con = null;
		Statement smt = null;
		Product product = new Product();

		try {
			//　データベースに接続する。
			con = getConnection();
			smt = con.createStatement();
			String sql = "select * from product where product_id = " + product_id;

			//　データベースにsql文を送り、実行結果を取得する
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getInt("price"));
				product.setExist_products(rs.getInt("exist_products"));
				product.setImage(rs.getString("image"));
			}

		} catch (Exception e) {
 			throw new IllegalStateException(e);
		} finally {
			//　リソースを開放する。
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
		return product;
	}

	//　商品を削除するメソッド
	public int delete(int product_id) {

		Connection con = null;
		Statement smt = null;
		int count = 0; //　データベースの更新件数

		try {
			//　データベースに接続する。
			con = getConnection();
			smt = con.createStatement();
			String sql = "delete from product where product_id=" + product_id;
			//sql文をデータベースで実行し、該当の商品情報を削除し、更新件数を取得する。
			count = smt.executeUpdate(sql);
		} catch (Exception e) {
 			throw new IllegalStateException(e);
		} finally {
			//　リソースを開放する。
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
		return count;
	}
}
