package adminServlet;

/*
 * プログラム名：詳細表示処理のサーブレット
 * プログラム説明：対象の商品情報を取得し表示する。画像に関しては保留
 * 作成者：原凜太郎
 * 作成日：20220623
 */

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class AdminProductDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String change = "";
		String cmd = "";

		try {
			// 文字コード設定
			request.setCharacterEncoding("UTF-8");

			// リクエストスコープで受け取った商品IDを取得する。
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			change = request.getParameter("change");

			// 受け取った商品IDを持つ商品を取得する。
			ProductDAO productDaoObj = new ProductDAO();
			Product product = productDaoObj.selectByProductid(product_id);

			// 商品一覧画面の商品リンクをクリック時、表示対象のユニフォームが存在しない場合の処理
			if (product.getProduct_id() == 0) {
				error = "表示対象のユニフォームが存在しないため、詳細情報は表示できません。";
				cmd = "admin";
				return;
			}

			// 変更ボタンをクリック時、変更対象のユニフォームが存在しない
			if (productDaoObj.selectByProductid(product_id).getProduct_id() == 0) {
				error = "更新対象のユニフォームが存在しないため、更新画面は表示できません。";
				cmd = "admin";
				return;
			}

			// 取得した商品情報をリクエストスコープに登録する。
			request.setAttribute("product", product);

		} catch (IllegalStateException e) {
			error = "DB接続エラー";
			cmd = "admin";
		} finally {
			if (error.equals("")) {
				if (change != null) {
					request.getRequestDispatcher("/view/productUpdate.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/view/adminProductDetail.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}
		}

	}

}
