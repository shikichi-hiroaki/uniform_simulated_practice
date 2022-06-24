package adminServlet;

/*
 * プログラム名：商品更新処理のサーブレット
 * プログラム説明：対象の商品情報を取得し表示する。画像に関しては保留
 * 作成者：原凜太郎
 * 作成日：20220623
 */

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import dao.ProductDAO;

public class ProductUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = null;

		try {
			//　文字コードの設定をする。
			request.setCharacterEncoding("UTF-8");

			//　更新情報に関するパラメータを取得する。
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			String product_name = request.getParameter("product_name");
			int price = Integer.parseInt(request.getParameter("price"));
			int exist_products = Integer.parseInt(request.getParameter("exist_products"));
			int on_sale = Integer.parseInt(request.getParameter("on_sale"));

			//　受け取ったデータをProductインスタンスにセットする。
			Product product = new Product();
			product.setProduct_id(product_id);
			product.setProduct_name(product_name);
			product.setPrice(price);
			product.setExist_products(exist_products);
			product.setOn_sale(on_sale);

			//　商品情報を更新する。
			ProductDAO productDaoObj = new ProductDAO();
			productDaoObj.update(product);
		} catch (NumberFormatException e) {

		} catch (IllegalStateException e) {
			error = "";
		} finally {
			if (error == null) {
				request.getRequestDispatcher("/adminProductList").forward(request, response);
			} else {

			}
		}

	}

}
