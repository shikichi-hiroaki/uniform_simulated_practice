
package userServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

public class UserInsertServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

			user.setUser_name(user_name);
			user.setPlace(place);
			user.setPhone_number(phone_number);
			user.setMail_adress(mail_adress);
			user.setPassword(password);
			user.setAuthority(2);

			User users = new User();
			users = userDaoObj.selectByUser(mail_adress);

			if (users.getMail_adress() ==null) {

				userDaoObj.insert(user);

			} else {

				userDaoObj.update(user);
			}

		} finally {

			request.getRequestDispatcher("/view/userProductList.jsp").forward(request, response);

		}
	}
}
