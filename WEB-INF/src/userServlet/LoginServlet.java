package userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			// user_id,password入力パラメータを取得
			String mail_adress = (String) request.getParameter("mailadress");
			String password = (String) request.getParameter("password");


			// UserDAOをインスタンス化し、ユーザー情報の検索
			UserDAO userDaoObj = new UserDAO();
			User user = userDaoObj.selectByUser(mail_adress, password);
			int authority = user.getAuthority();

			// ユーザー情報のチェック
			if (user.getMail_adress() == null) {
				error = "入力データが間違っています。";
				cmd = "login";
				return;
			}

			if (user != null) {

				// ユーザー情報がある場合、セッションにスコープにmail_adressという名前で登録
				HttpSession session = request.getSession();
				session.setAttribute("mail_adress", mail_adress);

				// クッキーに入力情報のuser_idとpasswordを登録
				Cookie userCookie = new Cookie("mail_adress", user.getMail_adress());
				userCookie.setMaxAge(60 * 60 * 24 * 1);
				response.addCookie(userCookie);

				Cookie passCookie = new Cookie("password", user.getPassword());
				passCookie.setMaxAge(60 * 60 * 24 * 1);
				response.addCookie(passCookie);

				if (authority == 1) {
					request.getRequestDispatcher("/view/adminMenu.jsp").forward(request, response);

				} else if (authority == 0) {
					session.setAttribute("user", user);
					request.getRequestDispatcher("/view/userMenu.jsp").forward(request, response);
				}else if(authority==2) {
					request.setAttribute("error", "会員ではありません。");
					cmd="login";
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}
			}

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログイン出来ません。";
			cmd = "login";

		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				if (cmd.equals("login")) {
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				} else {
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}
			}
		}

	}

}
