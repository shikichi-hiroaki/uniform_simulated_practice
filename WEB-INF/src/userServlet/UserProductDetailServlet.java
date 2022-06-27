//顧客側の商品詳細サーブレット

package userServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ProductDAO;
import bean.Product;

public class UserProductDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 変数宣言
		Product product = new Product();
		ProductDAO proDaoObj = new ProductDAO();
		String error = "";// エラーメッセージ

		try {
			// ユニフォームIDの受け取り
			int product_id = Integer.parseInt(request.getParameter("product_id"));

			// ユニフォーム情報の取得
			product = proDaoObj.selectByProductid(product_id);
		} catch (IllegalStateException e) {
			error = "DBに接続できませんでした。";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		} finally {
			request.setAttribute("product", product);
			request.getRequestDispatcher("/view/userProductDetail.jsp").forward(request, response);
		}
	}
}
