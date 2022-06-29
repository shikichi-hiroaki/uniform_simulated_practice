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
		String error = "";
		String cmd = "";
		Product product = new Product();
		ArrayList<Product> list = new ArrayList<Product>();
		ProductDAO productDaoObj = new ProductDAO();

		try {
			list = productDaoObj.selectAll();

			request.setAttribute("list", list);

		} catch (IllegalStateException e) { // 接続エラー

			error = "データベース接続エラー";
			cmd = "admin";

		} finally {

			if (error.equals("")) {// 正常

				request.getRequestDispatcher("view/adminProductList.jsp").forward(request, response);

			} else { // エラー
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}
}
