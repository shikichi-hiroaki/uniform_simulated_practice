//過去の注文履歴サーブレット

package userServlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.*;
import bean.*;


public class LogOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//変数宣言とオブジェクト作成
		User user = new User();
		PurchaseDetailDAO purchaseDetailDaoObj = new PurchaseDetailDAO();
		HttpSession session = request.getSession();//セッションオブジェクトの生成
		ArrayList<PurchaseDetail> list = new ArrayList<PurchaseDetail>();//購入情報一覧を格納する変数
		String error = "";
		String cmd = "";

		try {
			//セッションからユーザー情報の受け取り
			user = (User)session.getAttribute("user");

			//DBから購入情報の検索
			list = (ArrayList<PurchaseDetail>)purchaseDetailDaoObj.selectByMailAdress(user.getMail_adress());

		} catch (IllegalStateException e) {
			error = "データベースに接続できませんでした。";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		} finally {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/view/logOrder.jsp").forward(request, response);
		}
	}
}
