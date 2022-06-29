package adminServlet;

/*
 * プログラム名：商品更新処理のサーブレット
 * プログラム説明：対象の商品情報を取得し表示する。画像に関しては保留
 * 作成者：原凜太郎
 * 作成日：20220623
 */

import java.io.*;
import com.oreilly.servlet.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import dao.ProductDAO;

public class ProductUpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = null;

		try {
			//　文字コードの設定をする。
			request.setCharacterEncoding("UTF-8");

			String FilePath = getServletContext().getRealPath("image");
			String imageName = "no_image.jpg";
			int maxBytes  = 1024*1024;
			MultipartRequest multireq = new MultipartRequest(request, FilePath, maxBytes, "MS932");

			//　更新情報に関するパラメータを取得する。
			int product_id = Integer.parseInt(multireq.getParameter("product_id"));
			String product_name = multireq.getParameter("product_name");
			int price = Integer.parseInt(multireq.getParameter("price"));
			int exist_product = Integer.parseInt(multireq.getParameter("exist_product"));
			int on_sale = Integer.parseInt(multireq.getParameter("on_sale"));
			if (multireq.getFile("image") != null) {
				imageName = multireq.getFile("image").getName();
			}

			if (product_name.equals("")) {
				error = "商品名を入力してください。";
				return;
			}

			//　受け取ったデータをProductインスタンスにセットする。
			Product product = new Product();
			product.setProduct_id(product_id);
			product.setProduct_name(product_name);
			product.setPrice(price);
			product.setExist_products(exist_product);
			product.setImage(imageName);
			product.setOn_sale(on_sale);

			//　商品情報を更新する。
			ProductDAO productDaoObj = new ProductDAO();
			productDaoObj.update(product);

		} catch (NumberFormatException e) {
			error = "価格もしくは金額には数値を入力してください。";
		} catch (IllegalStateException e) {
			error = "データベースに接続エラーの為、更新処理を行えませんでした。。";
		} finally {
			if (error == null) {
				request.getRequestDispatcher("/adminProductList").forward(request, response);
			} else {
				request.setAttribute("cmd", "admin");
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
