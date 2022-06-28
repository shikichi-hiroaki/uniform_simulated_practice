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
			String mail_adress = request.getParameter("mail_adress");
			String password = request.getParameter("password");
			int authority=Integer.parseInt(request.getParameter("authority"));

			user.setUser_name(user_name);
			user.setPlace(place);
			user.setPhone_number(phone_number);
			user.setMail_adress(mail_adress);
			user.setPassword(password);
			user.setAuthority(authority);

			// 更新用メソッドを呼び出す。
			userDaoObj.update(user);

		} finally {

			request.getRequestDispatcher("/view/userMenu.jsp").forward(request, response);

		}
	}
}
