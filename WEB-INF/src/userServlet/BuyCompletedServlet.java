package userServlet;

import bean.Purchase;
import bean.User;
import bean.Product;
import dao.ProductDAO;
import dao.PurchaseDAO;
import dao.UserDAO;
import util.SendMail;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class BuyCompletedServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 変数宣言
		String error = "";
		User user = new User();
		Purchase purchase = new Purchase();
		HttpSession session = request.getSession();
		PurchaseDAO purchaseDaoObj = new PurchaseDAO();
		UserDAO userDaoObj = new UserDAO();
		String product_name = null;
		Product product = new Product();
		ProductDAO productDaoObj = new ProductDAO();

		try {
			// セッションから情報の取得
			user = (User) session.getAttribute("user");
			purchase = (Purchase) session.getAttribute("purchase");

			// DBに登録
			User users = userDaoObj.selectByUser(user.getMail_adress());

			if (users.getMail_adress() == null) {
				userDaoObj.insert(user);
			}
			purchaseDaoObj.insert(purchase);

			// 商品IDから商品名の取得
			product = productDaoObj.selectByProductid(purchase.getProduct_id());
			product_name = product.getProduct_name();


			//メール作成
			SendMail sendMail=new SendMail();

			sendMail.MailSetup(user.getUser_name(), purchase, product_name);

		} catch (Exception e) {
			error = "エラー";

		} finally {
			if (error.equals("")) {
				request.setAttribute("purchase", purchase);
				request.setAttribute("product_name", product_name);
				request.getRequestDispatcher("/view/buyCompleted.jsp").forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
