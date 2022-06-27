package userServlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class ProductBuyServlet  extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{




		//DTOオブジェクト宣言
		Purchase purchase = new Purchase();
		Product product=new Product();

		//DAOオブジェクト宣言
		PurchaseDAO purchaseDaoObj = new PurchaseDAO();
		ProductDAO productDaoObj=new ProductDAO();


		try {

			//文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");
			//パラメータの取得

			String user_name = request.getParameter("user_name");
			String place = request.getParameter("place");
			String phone_number = request.getParameter("phone_number");
			String mail_adress = request.getParameter("mail_adress");
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			int count = Integer.parseInt(request.getParameter("count"));
			String others = request.getParameter("others");

			product=productDaoObj.selectByProductid(product_id);

			int money=product.getPrice();

			purchase.setPlace(place);
			purchase.setPhone_number(phone_number);
			purchase.setMail_adress(mail_adress);
			purchase.setProduct_id(product_id);
			purchase.setCount(count);
			purchase.setOthers(others);
			purchase.setAmount_money(money*count);


			purchaseDaoObj.insert(purchase);

			request.getRequestDispatcher("/view/productBuy.jsp").forward(request, response);

		}catch(Exception e) {

		}

	}

}
