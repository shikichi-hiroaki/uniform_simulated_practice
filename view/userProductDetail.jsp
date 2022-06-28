<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.*" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/adminstyle.css">
<%
Product product = (Product)request.getAttribute("product");
%>
<html>
<head>
	<title>商品詳細(顧客)</title>
</head>
<body>
	<div style="text-align: center">
		<%@include file="/common/userHeader.jsp" %>

		<!-- メッセージ表示 -->
		<h2>商品詳細</h2>

		<img src="<%= request.getContextPath() %>/image/<%= product.getImage() %>" style="width: 300px; height: 200px;" alt="ユニフォーム">

		<table align="center">
			<tr>
				<th style="background-color: skyblue; width: 100">商品名</th>
				<td><%= product.getProduct_name() %></td>
			</tr>
			<tr>
				<th style="background-color: skyblue">金額（単価）</th>
				<td><%= product.getPrice() %></td>
			</tr>
			<tr>
				<th style="background-color: skyblue">在庫数</th>
				<td><%= product.getExist_products() %></td>
			</tr>
		</table>
		<br> <br> <br>
		<table align="center">

			<tr width="220" align="center">
				<td><a href="<%=request.getContextPath()%>/view/userProductList.jsp">商品一覧</a></td>
			</tr>
		</table>
	</div>
</body>
</html>