/*
 * ユーザー側の商品一覧画面
 *初期画面では商品一覧を表示できないため、初回時のみ一覧表示ボタンを用いて一覧を表示させる。
 *
 */
package userServlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class UserProductListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String set = null;
		String cmd = null;
		Product product = new Product();
		ArrayList<Product> list = new ArrayList<Product>();
		ProductDAO productDaoObj = new ProductDAO();

		try {
			//文字エンコード
			request.setCharacterEncoding("UTF-8");


			User user = (User) session.getAttribute("user");

			if (user== null) {

				if (session.getAttribute("set") == "login") {
					request.setAttribute("error", "セッション切れの為、一覧画面に戻ります");
					cmd = "list";
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}

			} else {
				set = "login";
				session.setAttribute("set", set);
			}

			list = productDaoObj.selectAll();

			request.setAttribute("list", list);


			request.getRequestDispatcher("view/userProductList.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("error", "セッション未入力の為、一覧画面に戻ります");
			cmd = "list";
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

	}
}
