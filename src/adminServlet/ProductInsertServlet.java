/*機能名：商品登録機能(管理者)
 *作成者：伊藤
 *備考：
 * ProductDAOのSQL文(insertメソッド)と、DBのproductテーブルで、カラム数が合わなかったため、
 * ProductDAOののINSERT文に、以下の列名指定文を挿入しました。
 *「product(product_id,product_name,price,exist_products,image)」
 */

package adminServlet;

import java.io.*;
import com.oreilly.servlet.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;

import bean.*;
import dao.*;

public class ProductInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 変数
		String error = ""; // エラーメッセージ
		String cmd = ""; // cmd

		try {

			// ユーザーセッション獲得
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// 文字指定
			request.setCharacterEncoding("UTF-8");

			String FilePath = getServletContext().getRealPath("image");
			String imageName = "no_image.jpg";
			int maxBytes  = 1024*1024;
			MultipartRequest multireq = new MultipartRequest(request, FilePath, maxBytes, "MS932");

			// 各パラメーター取得
			Product product = new Product();
			String product_name = multireq.getParameter("product_name");
			String price = multireq.getParameter("price");
			String exist_products = multireq.getParameter("exist_products");
			if (multireq.getFile("image") != null) {
				imageName = multireq.getFile("image").getName();
			}

			// オブジェクト格納
			product.setProduct_name(product_name);
			product.setPrice(Integer.parseInt(price));
			product.setExist_products(Integer.parseInt(exist_products));
			product.setImage(imageName);

			// 登録メソッド呼び出し
			ProductDAO productDaoObj = new ProductDAO();
			productDaoObj.insert(product);

		} catch (IllegalStateException e) { // DBエラー
			error = "DBエラー";
			cmd = "logout";

		} finally {
			if (error.equals("")) {// 正常
				request.getRequestDispatcher("/adminProductList").forward(request, response);

			} else { // エラー
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
