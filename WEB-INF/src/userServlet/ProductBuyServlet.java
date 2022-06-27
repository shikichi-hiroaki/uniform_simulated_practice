package userServlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import bean.Purchase;
import bean.User;
import dao.ProductDAO;
import dao.PurchaseDAO;

public class ProductBuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 変数
		String error = "";
		String cmd = "";
		User user = new User();
		ArrayList<Product> nameList = new ArrayList<Product>();

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// DAOオブジェクト宣言
			ProductDAO productDaoObj = new ProductDAO();

			// ユーザーセッション取得
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");

			// メソッドの呼び出し
			nameList = productDaoObj.selectNameByOnsale();

		} catch (IllegalStateException e) {
			error = "エラー";
			cmd = "logout";

		} finally {
			if (error.equals("")) {
				request.setAttribute("nameList", nameList);
				//if (user.getAuthority() == 2) {
					//request.setAttribute("user", user);結合の際はコメントを外す
				//}
				request.getRequestDispatcher("/view/productBuy.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
