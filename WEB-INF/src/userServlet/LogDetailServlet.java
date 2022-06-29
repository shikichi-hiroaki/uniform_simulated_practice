//過去の注文履歴詳細サーブレット
package userServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.PurchaseDetailDAO;
import bean.PurchaseDetail;

public class LogDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//変数宣言とオブジェクト作成
		PurchaseDetailDAO purchaseDetailDaoObj = new PurchaseDetailDAO();
		HttpSession session = request.getSession();//セッションオブジェクトの生成
		PurchaseDetail purchaseDetail = new PurchaseDetail();//DAOから受けとった情報を格納する変数
		String error = null;
		String cmd = "";

		try {
			//注文IDの受け取り
			int purchase_id = Integer.parseInt(request.getParameter("purchase_id"));

			//DBから購入情報の検索
			purchaseDetail = (PurchaseDetail)purchaseDetailDaoObj.selectByPurchaseId(purchase_id);

			if (purchaseDetail == null) {
				error = "存在しない注文情報です。";
				cmd = "user";

			}

		} catch (IllegalStateException e) {
			error = "データベースに接続できませんでした。";
			cmd = "user";
		} finally {
			if (error.equals("")) {
				request.setAttribute("purchaseDetail", purchaseDetail);
				request.getRequestDispatcher("/view/logOrderDetail.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
