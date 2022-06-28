package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.*;

public class UserDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/uniform_db";
	private static String USER = "root";
	private static String PASSWORD = "root123";

	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static void main(String[] args) throws Exception {

		Connection con = getConnection();
		System.out.print("con" + con);
		con.close();
	}

	// ユーザー情報確認
	public User selectByUser(String mail_adress) {

		User user = new User();
		String sql = "SELECT * FROM user WHERE mail_adress ='" + mail_adress + "'";

		Connection con = null;
		Statement smt = null;

		try {

			con = UserDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				user.setUser_name(rs.getString("user_name"));
				user.setMail_adress(rs.getString("mail_adress"));
				user.setPlace(rs.getString("place"));
				user.setPhone_number(rs.getString("phone_number"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getInt("authority"));
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

		return user;
	}

	// ログイン用
	public User selectByUser(String mail_adress, String password) {

		User user = new User();
		String sql = "SELECT * FROM user WHERE mail_adress ='" + mail_adress + "' AND password='" + password + "'";

		Connection con = null;
		Statement smt = null;
		try {
			con = UserDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				user.setUser_name(rs.getString("user_name"));
				user.setMail_adress(rs.getString("mail_adress"));
				user.setPlace(rs.getString("place"));
				user.setPhone_number(rs.getString("phone_number"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getInt("authority"));
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
		return user;

	}

	// 会員登録
	public void insert(User user) {

		String sql = "INSERT INTO user VALUES('" + user.getUser_name() + "','" + user.getMail_adress() + "','"
				+ user.getPlace() + "','" + user.getPhone_number() + "','" + user.getPassword() + "',"
				+ user.getAuthority() + ")";

		Connection con = null;
		Statement smt = null;

		try {

			con = UserDAO.getConnection();
			smt = con.createStatement();

			int c = smt.executeUpdate(sql);

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

	// 会員情報変更
	public void update(User user) {
		Connection con = null;
		Statement smt = null;

		String sql = "UPDATE user SET user_name='" + user.getUser_name() + "',mail_adress='" + user.getMail_adress()
				+ "',place='" + user.getPlace() + "',phone_number='" + user.getPhone_number() + "',password='"
				+ user.getPassword() + "',authority="+ user.getAuthority() +" WHERE mail_adress ='" + user.getMail_adress() + "'";

		try {

			con = getConnection();
			smt = con.createStatement();

			int c = smt.executeUpdate(sql);

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

	public ArrayList<User> selectAll() {

		ArrayList<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user WHERE authority = 0";

		Connection con = null;
		Statement smt = null;
		try {
			con = UserDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				User users = new User();
				users.setUser_name(rs.getString("user_name"));
				users.setMail_adress(rs.getString("mail_adress"));
				users.setPlace(rs.getString("place"));
				users.setPhone_number(rs.getString("phone_number"));
				users.setPassword(rs.getString("password"));
				users.setAuthority(rs.getInt("authority"));

				list.add(users);
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
