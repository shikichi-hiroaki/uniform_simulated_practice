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

public class UserUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		HttpSession session = request.getSession();

		try {
			// 文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// DTOオブジェクト生成
			User user = new User();

			// DAOオブジェクト生成
			UserDAO userDaoObj = new UserDAO();

			user = (User) session.getAttribute("user");

			// パラメータを取得する
			String user_name = request.getParameter("user_name");
			String place = request.getParameter("place");
			String phone_number = request.getParameter("phone_number");
			String password = request.getParameter("password");

			// パスワードの空白チェック
			if (password.equals("")) {
				error = "パスワードが未入力のため、会員情報更新出来ませんでした。";
				cmd = "user";
			} else {

				user.setUser_name(user_name);
				user.setPlace(place);
				user.setPhone_number(phone_number);
				user.setPassword(password);

				// 更新用メソッドを呼び出す。
				userDaoObj.update(user);
			}
		} catch (IllegalStateException e) {
			error = "データベースに接続できませんでした。";
			cmd = "user";
			return;

		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view/userMenu.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
