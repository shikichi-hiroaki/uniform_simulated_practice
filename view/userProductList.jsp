<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.*"%>
<html>
<head>
<title>商品一覧(共通)</title>
</head>
<jsp:include page="/common/userHeader.jsp" flush="true" />
<body>
	<%
		User user = (User) request.getAttribute("user");

		if (session.getAttribute("set") == null) {
	%>

	<table align="center" width="850">
		<tr>
			<td width="80">&nbsp;</td>
			<td width="80">&nbsp;</td>
			<td width="508" align="center"><font size="5">商品一覧</font></td>
			<form action="<%=request.getContextPath()%>/view/login.jsp" method="post">
			<td width="80"><input type="submit" value="ログイン">
			</td>
			</form>
			<form action="<%=request.getContextPath()%>/view/userInsert.jsp" method="post">
			<td width="80"><input type="submit" value="会員登録">
			</td>
			</form>
		</tr>
	</table>
	<%
		}
		if(session.getAttribute("set")=="login"){
	%>

	<table align="center" width="850">
		<tr>
			<td width="200">&nbsp;</td>
			<td width="508" align="center"><font size="5">商品一覧</font></td>
			<td width="200">[<a
				href="<%=request.getContextPath()%>/view/userMenu.jsp">ユーザーメニュー</a>]
			</td>
		</tr>
	</table>

	<%
		}
	%>

	<hr align="center" size="2" color="black" width="950"></hr>

	<p align="center">ユニフォーム一覧</p>

	<br>

	<%
		ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Product products = (Product) list.get(i);
	%>

	<p align="center">
		<a href="<%=request.getContextPath()%>/userProductDetail?name=<%=products.getProduct_id()%>"><%=products.getProduct_name()%></a>
	</p>

	<%
		}
		} else {
	%>
		<form action="<%=request.getContextPath()%>/userProductList">
		<p align="center"><input type="submit" value="一覧表示"></p>
		</form>
	<%
		}
	%>

	<br>
	<br>

	<form action="<%=request.getContextPath()%>/view/productBuy.jsp">
		<p align="center">
			<input type="submit" value="購入">
		</p>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


</body>
</html>