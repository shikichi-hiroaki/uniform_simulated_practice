package adminServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.*;
import dao.*;;

public class AdminProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		commonProcess(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		commonProcess(request, response);

	}

	public void commonProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String set = null;
		String cmd = null;
		Product product = new Product();
		ArrayList<Product> list = new ArrayList<Product>();
		ProductDAO productDaoObj = new ProductDAO();

		try {
			list = productDaoObj.selectAll();

			request.setAttribute("list", list);

			request.getRequestDispatcher("view/adminProductList.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("error", "セッション未入力の為、一覧画面に戻ります");
			cmd = "list";
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

	}
}
