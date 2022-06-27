/*
 * ユーザー一覧
 */

package adminServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import dao.UserDAO;

public class UserListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<User> list = new ArrayList<User>();

		try {
		// UserDAOをインスタンス化し、関連メソッドを呼び出す
		UserDAO userDaoObj = new UserDAO();
		list = userDaoObj.selectAll();

		} catch (IllegalStateException e) {

		} finally {

		// 取得したListをリクエストスコープに"user_list"という名前で格納
		request.setAttribute("user_list", list);

		// userList.jspにフォワード
		request.getRequestDispatcher("/view/userList.jsp").forward(request, response);

		}
	}
}