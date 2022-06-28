<%@page contentType="text/html;charset=UTF-8"%>
<%@page
	import="bean.Purchase,dao.PurchaseDAO,dao.ProductDAO,bean.User,bean.Product,java.util.ArrayList"%>

<%
	User user = (User) request.getAttribute("user");
	ArrayList<Product> nameList = (ArrayList<Product>) request.getAttribute("nameList");
%>
<html>
<head>
<title>商品購入</title>
</head>
<body>
	<div style="text-align: center">
		<%@ include file="/common/userHeader.jsp"%>

		<!-- メッセージ表示 -->
		<h2>商品購入</h2>

			<!-- 入力フォームを表示 -->
			<form action="<%=request.getContextPath()%>/buyConfirm">
				<table align="center">
					<%
						if (user != null) {
					%>
					<tr>
						<th style="background-color: skyblue; text-align: center">氏名</th>
						<td><input type="text" name="user_name"
							value="<%=user.getUser_name()%>"></td>
					</tr>
					<tr>
						<th style="background-color: skyblue; text-align: center">電話番号</th>
						<td><input type="text" name="phone_number"
							value="<%=user.getPhone_number()%>"></td>
					</tr>
					<tr>
						<th style="background-color: skyblue; text-align: center">住所</th>
						<td><input type="text" name="place"
							value="<%=user.getPlace()%>"></td>
					</tr>

					<tr>
						<th style="background-color: skyblue; text-align: center">mail</th>
						<td><input type="text" name="mail_adress"
							value="<%=user.getMail_adress()%>"></td>
					</tr>
					<%
						}
						if(user == null) {
					%>
					<tr>
						<th style="background-color: skyblue; text-align: center">氏名</th>
						<td><input type="text" name="user_name" value=""></td>
					</tr>
					<tr>
						<th style="background-color: skyblue; text-align: center">電話番号</th>
						<td><input type="text" name="phone_number" value=""></td>
					</tr>
					<tr>
						<th style="background-color: skyblue; text-align: center">住所</th>
						<td><input type="text" name="place" value=""></td>
					</tr>

					<tr>
						<th style="background-color: skyblue; text-align: center">mail</th>
						<td><input type="text" name="mail_adress" value=""></td>
					</tr>
					<%
						}
					%>
					<tr>
						<th style="background-color: skyblue; text-align: center">商品</th>
						<td>
							<select name = "product_id">
								<% for(int i = 0 ; i < nameList.size() ; i ++ ){ %>
								<option value="<%=nameList.get(i).getProduct_id() %>"><%=nameList.get(i).getProduct_name()%></option>
								<%}%>
							</select>
						</td>
					</tr>
					<tr>
						<th style="background-color: skyblue; text-align: center">個数</th>
						<td><input type="number" name="count" value="" min="0" max="20"></td>
					</tr>
					<tr>
						<th style="background-color: skyblue; text-align: center">備考</th>
						<td><textarea name="others" rows="4" cols="50"></textarea></td>
					</tr>
				</table>
				<br>
				<br>
				<br>

			<input type="submit" value="購入確認">
		</form>
		<br> <a href="<%=request.getContextPath()%>/userProductList">
			<td width="220" align="center">商品一覧画面へ戻る</td>
		</a> <br>
	</div>
</body>
</html>