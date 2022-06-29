//購入確認サーブレット
package userServlet;

import bean.*;
import dao.*;
import util.SendMail;

import javax.servlet.*;
import java.io.*;

import javax.servlet.http.*;

public class BuyConfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 変数宣言
		String error = "";
		String cmd = "";
		User user = new User();
		UserDAO userDaoObj = new UserDAO();
		Purchase purchase = new Purchase();
		PurchaseDAO purchaseDaoObj = new PurchaseDAO();
		PurchaseDetail purchaseDetail = new PurchaseDetail();
		Product product = new Product();
		ProductDAO productDaoObj = new ProductDAO();
		HttpSession session = request.getSession();
		String product_name = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// ユーザー情報をセッションから取得
			user = (User) session.getAttribute("user");

			// ユーザが非会員であれば個人情報を取得
			if (user == null) {
				User users = new User();
				// フォームで入力された値の取得と非会員権限の付与
				users.setUser_name(request.getParameter("user_name"));
				if (users.getUser_name() == null) {
					error = "氏名が入力されていない為、購入はできません。";
				}
				users.setPhone_number(request.getParameter("phone_number"));
				if (users.getPhone_number() == null) {
					error = "電話番号が入力されていない為、購入はできません。";
				}
				users.setMail_adress(request.getParameter("mail_adress"));
				if (users.getMail_adress() == null) {
					error = "メールアドレスが入力されていない為、購入はできません。";
				}
				users.setPlace(request.getParameter("place"));
				if (users.getPlace() == null) {
					error = "住所が入力されていない為、購入はできません。";

				}
				users.setPassword("null");
				users.setAuthority(0);

				if (userDaoObj.selectByUser(users.getMail_adress()) == null) {
					userDaoObj.insert(users);
				}
				else {

				}
				user = users;
			}

			// 購入情報の取得
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			purchase.setProduct_id(product_id);
			String string_count = request.getParameter("count");
			if (string_count == "") {
				error = "個数が入力されていません。";
			}
			int count = Integer.parseInt(string_count);
			purchase.setCount(count);
			purchase.setOthers(request.getParameter("others"));
			purchase.setMail_adress(user.getMail_adress());

			//商品IDから商品情報を取得
			product = productDaoObj.selectByProductid(product_id);
			//購入数が在庫数を超えている場合、もしくは在庫数0の場合、エラー画面に遷移する
			if( product.getExist_products() == 0) {
				error = "申し訳ございません。" + product.getProduct_name() + "は現在売り切れです。";
				cmd = "user";
				return;
			} else if (product.getExist_products() < purchase.getCount()) {
				error = "申し訳ございません。現在在庫が" + product.getExist_products() + "個であるため、ご希望の個数は購入できません。";
				cmd = "user";
				return;
			}

			// 商品IDから単価を取得し、合計金額を算出
			int price = product.getPrice();
			int amount_money = count * price;
			purchase.setAmount_money(amount_money);// 合計金額を格納

			// セッションにpurchaseとuserを登録
			session.setAttribute("purchase", purchase);
			session.setAttribute("user", user);

			// 画面表示のために商品名を取得
			product_name = product.getProduct_name();

		} catch (Exception e) {
			if (error == "") {
				error = "DBに接続出来ませんでした。";
			}
			cmd = "user";
			e.printStackTrace();

		} finally {
			if (error.equals("")) {
				request.setAttribute("purchase", purchase);
				request.setAttribute("product_name", product_name);
				request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}