/*機能名：受注商品詳細機能
 *作成者：伊藤
 *
 */

package adminServlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import bean.Purchase;
import bean.User;
import dao.*;

public class OrderDetailConfirmServlet extends HttpServlet {

	// 現在日時を取得するメソッド
	public static String getNowDate() {
		final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		final Date date = new Date(System.currentTimeMillis());
		return df.format(date);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 変数
		String error = ""; // エラーメッセージ用
		String cmd = "";

		try {

			// 文字指定
			request.setCharacterEncoding("UTF-8");

			// 注文idパラメーター取得
			String purchase_id = request.getParameter("purchase_id");
			// cmdパラメータ取得(更新)
			cmd = request.getParameter("cmd");
			PurchaseDAO purchaseDaoObj = new PurchaseDAO();
			// 入金・発送日時更新
			if (cmd != null) {

				String date = getNowDate(); // メソッドから日付取得

				// 入金
				if (cmd.equals("conpletePayment")) {
					String payment_date = String.valueOf(date); // 日付を格納

					// 更新メソッド呼び出し
					purchaseDaoObj.updatePayment(payment_date, purchase_id);
				}
				// 発送
				if (cmd.equals("conpleteShopping")) {
					String shopping_date = String.valueOf(date); // 日付を格納

					// 更新メソッド呼び出し
					purchaseDaoObj.updateShopping(shopping_date, purchase_id);
				}
			}

			// 注文id検索メソッド呼び出し(個数、入金・発送状況、備考欄を取得)

			Purchase purchase = purchaseDaoObj.selectByPurchaseId(Integer.parseInt(purchase_id));
			request.setAttribute("purchase", purchase); // リクエストスコープ

			// 商品id検索メソッド呼び出し(商品名、価格を取得)
			ProductDAO productDaoObj = new ProductDAO();
			Product product = productDaoObj.selectByProductid(purchase.getProduct_id());
			request.setAttribute("product", product); // リクエストスコープ

			// メアドからユーザー検索メソッド呼び出し(ユーザ－名取得)
			UserDAO userDaoObj = new UserDAO();
			User user = userDaoObj.selectByUser(purchase.getmail_adress());
			request.setAttribute("user", user); // リクエストスコープ

			// 受注管理一覧の詳細画面をクリック時、表示対象の詳細が存在しない
			if (purchase.getmail_adress() == null) {
				error = "表示対象の情報が存在しないため、詳細情報は表示できません。";
				cmd = "admin";
				return;
			}

		} catch (IllegalStateException e) { // 接続エラー

			error = "データベース接続エラー";

		} finally {

			if (error.equals("")) {// 正常

				request.getRequestDispatcher("/view/orderDetailConfirm.jsp").forward(request, response);

			} else { // エラー
				request.setAttribute("error", error);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
