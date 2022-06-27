/*機能名：商品受注一覧機能
 * 作成者：伊藤
 */

package adminServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import dao.*;

public class ProductOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 変数
		String error = ""; // エラーメッセージ
		String cmd = ""; // cmd

		ArrayList<Purchase> purchase_list = new ArrayList<Purchase>(); // データ格納用配列

		try {

			// 全件取得メソッド呼び出し
			PurchaseDAO purchaseDaoObj = new PurchaseDAO();
			purchase_list = purchaseDaoObj.selectAll();
			request.setAttribute("purchase_list", purchase_list); // リクエストスコープ

			// メアドからユーザー検索メソッド呼び出し(ユーザ－名取得)
			User user = new User();
			for (int i = 0; i < purchase_list.size(); i++) {
				UserDAO userDaoObj = new UserDAO();
				user = userDaoObj.selectByUser(purchase_list.get(i).getmail_adress());
			}
			request.setAttribute("user", user); // リクエストスコープ

			// 発注日から月を取得
			int month = Integer.parseInt(purchase_list.get(purchase_list.size() - 1).getBuy_date().substring(5, 7));
			request.setAttribute("month", month); // リクエストスコープ

			// 月の売上を計算
			int sum = 0;
			for (int i = 0; i < purchase_list.size(); i++) {
				sum += purchase_list.get(i).getAmount_money();
			}
			request.setAttribute("sum", sum); // リクエストスコープ

		} catch (IllegalStateException e) { // DBエラー
			error = "DBエラー";
			cmd = "";

		} finally {

			if (error.equals("")) {// 正常
				request.getRequestDispatcher("/view/productOrder.jsp").forward(request, response);

			} else { // エラー
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}

	}

}
