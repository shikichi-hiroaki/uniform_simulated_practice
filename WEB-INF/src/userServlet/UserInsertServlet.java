
package userServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

public class UserInsertServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// DTOオブジェクト宣言
			User user = new User();

			// DAOオブジェクト宣言
			UserDAO userDaoObj = new UserDAO();

			// パラメータの取得
			String user_name = request.getParameter("user_name");
			String place = request.getParameter("place");
			String phone_number = request.getParameter("phone_number");
			String mail_adress = request.getParameter("mail_adress");
			String password = request.getParameter("password");

			// データの空白チェック
			if (user_name.equals("")) {
				error = "名前を入力してください。";
				cmd = "user";
				return;
			}

			if (place.equals("")) {
				error = "住所を入力してください。";
				cmd = "user";
				return;
			}

			if (phone_number.equals("")) {
				error = "電話番号を入力してください。";
				cmd = "user";
				return;
			}

			if (mail_adress.equals("")) {
				error = "メールアドレスを入力してください。";
				cmd = "user";
				return;
			}

			if (password.equals("")) {
				error = "パスワードを入力してください。";
				cmd = "user";
				return;
			}

			// 重複チェック
			if (userDaoObj.selectByUser(mail_adress).getMail_adress() != null) {
				error = "登録済みのメールアドレスです。";
				cmd = "user";
				return;
			}

			try {
				user.setPhone_number(phone_number);
			} catch (NumberFormatException e) {
				error = "電話番号は数値で入力してください。";
				cmd = "user";
				return;
			}

			user.setUser_name(user_name);
			user.setPlace(place);
			user.setMail_adress(mail_adress);
			user.setPassword(password);
			user.setAuthority(2);

			User users = new User();
			users = userDaoObj.selectByUser(mail_adress);

			if (users.getMail_adress() == null) {

				userDaoObj.insert(user);

			} else {

				userDaoObj.update(user);
			}

		} finally {

			if(error.equals("")) {
			request.getRequestDispatcher("/view/userProductList.jsp").forward(request, response);

			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
