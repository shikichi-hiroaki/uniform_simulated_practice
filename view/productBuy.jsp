<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,bean.*"%>

<html>
<head>
<title>商品購入</title>
</head>
<body>
	<div style="text-align: center">
		<%@ include file="/common/userHeader.jsp"%>

		<!-- メッセージ表示 -->
		<h2>商品購入</h2>
	<form action="<%=request.getContextPath()%>/productBuy">
		<!-- 注文内容を表示 -->
		<table align="center">

			<tr>
				<th style="background-color: skyblue; text-align: center">ユーザーID</th>
				<th>[ログインした場合、IDを表示]
				<th>
			</tr>
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
				<td><textarea name="place" rows="2" cols="50"></textarea></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">mail</th>
				<td><input type="text" name="mail_adress" value=""></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">商品</th>
				<td><select name="product_id">
						<%
						ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
						if (list != null) {
							for (int i = 0; i < list.size(); i++) {
								Product products = (Product) list.get(i);

							int j = 1;
						%>

						<option value="<%=j%>"><%=products.getProduct_name()%></option>

						<%
							}
						%>

				</select></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">個数</th>
				<td><input type="text" name="count" ></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">備考</th>
				<td><textarea name="others" rows="4" cols="50"></textarea></td>
			</tr>
		</table>
		<br> <br> <br>

		<input type="submit" value="購入確認">
		<br>
		</form>

		<a href="<%=request.getContextPath()%>/productBuy">
		<td width="220" align="center">商品一覧画面へ戻る</a></td>
		<br>
	</div>
</body>
</html>