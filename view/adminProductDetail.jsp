<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.*" %>

<%
Product product = (Product)request.getAttribute("product");
if (product == null) {
	product = new Product();
}
%>

<html>
	<head>
		<title>商品詳細(管理者)</title>
		<style>
			img {
				width: 200px;
				height: 100px;
			}
		</style>
	</head>
	<body>
		<div style="text-align: center">
		<%@include file="/common/adminHeader.jsp" %>

			<!-- メッセージ表示 -->
			<h2>商品詳細</h2>

			<img src="<%= request.getContextPath() %>/image/<%= product.getImage() %>" alt="ユニフォーム">

			<table align="center">
				<tr>
					<th style="background-color: lightgreen; width: 100">商品名</th>
					<td><%= product.getProduct_name() %></td>
				</tr>
				<tr>
					<th style="background-color: lightgreen">金額（単価）</th>
					<td><%= product.getPrice() %>円</td>
				</tr>
				<tr>
					<th style="background-color: lightgreen">在庫数</th>
					<td><%= product.getExist_products() %></td>
				</tr>
				<tr>
					<th style="background-color: lightgreen">販売状況</th>
					<td>
						<% if (product.getOn_sale() == 0) { %>
							販売中
						<% } else { %>
							販売停止中
						<% } %>
					</td>

				</tr>
			</table>
			<table align="center">
				<tr>
					<td width="220" align="center"><a
						href="<%=request.getContextPath()%>/adminProductList">商品一覧</a></td>
				</tr>
				<tr>
					<td width="220" align="center"><a
						href="<%=request.getContextPath()%>/adminProductDetail?cmd=update&product_id=<%= product.getProduct_id() %>">商品更新</a></td>
				</tr>
			</table>
		</div>
	</body>
</html>