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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = null;
		String cmd = "";
		String strPrice = "";

		try {
			// 文字コードの設定をする。
			request.setCharacterEncoding("UTF-8");

			String FilePath = getServletContext().getRealPath("image");
			String imageName = "no_image.jpg";
			int maxBytes = 1024 * 1024;
			MultipartRequest multireq = new MultipartRequest(request, FilePath, maxBytes, "MS932");

			// 更新情報に関するパラメータを取得する。
			int product_id = Integer.parseInt(multireq.getParameter("product_id"));
			String product_name = multireq.getParameter("product_name");
			int price = Integer.parseInt(multireq.getParameter("price"));
			int exist_product = Integer.parseInt(multireq.getParameter("exist_product"));
			int on_sale = Integer.parseInt(multireq.getParameter("on_sale"));
			if (multireq.getFile("image") != null) {
				imageName = multireq.getFile("image").getName();
			}

			// � 取得したパラメータの各エラーチェックをおこなう
			// 全データの空白チェック（データが入力されているかどうか）
			if (product_name.equals("")) {
				error = "商品名が入力されていないため、商品情報の更新が行えませんでした。";
				cmd = "admin";
				return;
			}

			if (strPrice.equals("")) {
				error = "価格が未入力のため、商品情報の更新は行えませんでした。";
				cmd = "admin";
				return;
			}

			try {
				// 価格値チェック（整数かどうか）
				price = Integer.parseInt(strPrice);
			} catch (NumberFormatException e) {
				error = "価格の値が整数ではないため、商品情報の更新は行えませんでした。。";
				cmd = "admin";
				return;
			}

			// 受け取ったデータをProductインスタンスにセットする。
			Product product = new Product();
			product.setProduct_id(product_id);
			product.setProduct_name(product_name);
			product.setPrice(price);
			product.setExist_products(exist_product);
			product.setImage(imageName);
			product.setOn_sale(on_sale);

			// 商品情報を更新する。
			ProductDAO productDaoObj = new ProductDAO();
			productDaoObj.update(product);

		} catch (IllegalStateException e) {
			error = "DBに接続できませんでした。";
			cmd = "admin";
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/adminProductList").forward(request, response);
			} else {
				request.setAttribute("error",error);
				request.setAttribute("cmd",cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}

