//購入確認サーブレット
package userServlet;

import bean.*;
import dao.ProductDAO;
import util.SendMail;

import javax.servlet.*;
import java.io.*;

import javax.servlet.http.*;

public class BuyConfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//変数宣言
		String error = "";
		String cmd = "";
		User user = new User();
		Purchase purchase = new Purchase();
		PurchaseDetail purchaseDetail=new PurchaseDetail();
		Product product = new Product();
		ProductDAO productDaoObj = new ProductDAO();
		HttpSession session = request.getSession();
		String product_name = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			//ユーザー情報をセッションから取得
			user = (User)session.getAttribute("user");

			//ユーザが非会員であれば個人情報を取得
			if(user.getMail_adress() == null) {
				//フォームで入力された値の取得と非会員権限の付与
				user.setUser_name(request.getParameter("name"));
				user.setPhone_number(request.getParameter("phone_number"));
				user.setMail_adress(request.getParameter("mail_adress"));
				user.setPlace(request.getParameter("place"));

				user.setAuthority(0);
			}

			//購入情報の取得
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			purchase.setProduct_id(product_id);
			int count = Integer.parseInt(request.getParameter("count"));
			purchase.setCount(count);
			purchase.setOthers(request.getParameter("others"));
			purchase.setMail_adress(user.getMail_adress());

			//商品IDから単価を取得し、合計金額を算出
			product = productDaoObj.selectByProductid(product_id);
			int price = product.getPrice();
			int amount_money = count * price;
			purchase.setAmount_money(amount_money);//合計金額を格納

			//セッションにpurchaseとuserを登録
			session.setAttribute("purchase", purchase);
			session.setAttribute("user", user);

			//画面表示のために商品名を取得
			product_name = product.getProduct_name();


		} catch (Exception e) {
			error = "エラー";
			cmd = "logout";
			e.printStackTrace();

		} finally {
			if (error.equals("")) {
				request.setAttribute("purchase", purchase);
				request.setAttribute("product_name", product_name);
				request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
