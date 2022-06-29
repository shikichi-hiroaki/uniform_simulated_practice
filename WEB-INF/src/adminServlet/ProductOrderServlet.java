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
		Calendar now = Calendar.getInstance();
		String month = "";
		String year = "";
		PurchaseDAO purchaseDaoObj = new PurchaseDAO();
		UserDAO userDaoObj = new UserDAO();
		User user = new User();
		int thisMonthlySales = 0;// 月ごとの売上合計

		ArrayList<Purchase> purchase_list = new ArrayList<Purchase>(); // データ格納用配列
		ArrayList<Purchase> purchase_thisMonthlySales = new ArrayList<Purchase>();// 月ごとの売上を取得する変数
		ArrayList<String> userNameList = new ArrayList<String>();// 名前一覧を格納する

		try {

			// 全件取得メソッド呼び出し
			purchase_list = purchaseDaoObj.selectAll();

			// メアドからユーザー検索メソッド呼び出し(ユーザ－名取得)
			for (int i = 0; i < purchase_list.size(); i++) {
				String user_name = userDaoObj.selectUsernameByMailadress(purchase_list.get(i).getmail_adress());
				userNameList.add(user_name);
			}

			// 現在の月を取得(ひと月前が取得される為、＋１）
			month = String.valueOf(now.get(Calendar.MONTH) + 1);
			// 現在の年を取得
			year = String.valueOf(now.get(Calendar.YEAR));
			// 10月未満であれば先頭に0をつける
			if (Integer.parseInt(month) < 10) {
				month = 0 + month;
			}
			// 引数用の年月を作成
			String yearMonth = year + "-" + month;

			// 月ごとの売上金額一覧を取得
			purchase_thisMonthlySales = (ArrayList<Purchase>) purchaseDaoObj.monthlySales(yearMonth);

			// 最新の月の売上を計算
			for (int i = 0; i < purchase_thisMonthlySales.size(); i++) {
				thisMonthlySales += purchase_thisMonthlySales.get(i).getAmount_money();
			}

		} catch (IllegalStateException e) { // DBエラー
			error = "DBに接続できませんでした。";
			cmd = "admin";

		} finally {

			if (error.equals("")) {// 正常
				request.setAttribute("purchase_list", purchase_list); // リクエストスコープ
				request.setAttribute("userNameList", userNameList); // リクエストスコープ
				request.setAttribute("month", month); // リクエストスコープ
				request.setAttribute("thisMonthlySales", thisMonthlySales); // リクエストスコープ
				request.getRequestDispatcher("/view/productOrder.jsp").forward(request, response);

			} else {
				// エラー
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}

	}

}
