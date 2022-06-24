<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.*"%>

<%
	Product product = (Product) request.getAttribute("product");
%>

<html>
<head>
<title></title>
<style>
tr td:first-child {
	background-color: skyblue;
}
</style>
</head>
<body>
	<!-- ヘッダー -->
	<%@include file="/common/adminHeader.jsp"%>
	<!-- ページタイトル -->
	<h2 style="text-align: center;">商品更新</h2>
	<hr size="5" style="width: 950px;">
	<!-- 商品更新フォーム -->
	<form action="<%=request.getContextPath()%> %>/productUpdate"
		style="margin: 50px;">
		<table style="margin: 0 auto;">
			<tr>
				<td>商品名</td>
				<td><input type="text" name="product_name"
					value="<%=product.getProduct_name()%>"></td>
			</tr>
			<tr>
				<td>価格</td>
				<td><input type="text" name="price"
					value="<%=product.getPrice()%>"></td>
			</tr>
			<tr>
				<td>在庫数</td>
				<td><input type="number" name="exist_product"
					value="<%=product.getExist_product()%>"></td>
			</tr>
			<tr>
				<td>商品画像</td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td>販売状況</td>
				<td><select name="on_sale">
						<%
							if (product.getOn_sale() == 0) {
						%>
						<option value="0" selected>販売中</option>
						<option value="1">販売停止中</option>
						<%
							} else {
						%>
						<option value="0">販売中</option>
						<option value="1" selected>販売停止中</option>
						<%
							}
						%>
				</select></td>
			</tr>
		</table>
		<div style="text-align: center; margin: 20px;">
			<input type="submit" value="更新">
		</div>
	</form>
</body>
</html>