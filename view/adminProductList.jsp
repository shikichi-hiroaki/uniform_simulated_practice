<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.*"%>
<html>
<head>
		<title>商品一覧(管理者)</title>
	</head>
<jsp:include page="/common/adminHeader.jsp" flush="true" />
<body>
	<table align="center" width="850">
		<tr>
			<td width="120">&nbsp;</td>

			<td width="508" align="center"><font size="5">商品一覧</font></td>
			<td width="120">[<a
				href="<%=request.getContextPath()%>/view/adminMenu.jsp">管理者メニュー</a>]
			</td>

		</tr>
	</table>

	<hr align="center" size="2" color="black" width="950"></hr>

	<p align="center">ユニフォーム一覧</p>

	<%
		ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Product products = (Product) list.get(i);
	%>

	<p align="center">
		<a href="<%=request.getContextPath()%>/adminProductDetail?name=<%=products.getProduct_id()%>"><%=products.getProduct_name()%></a>
	</p>

	<%
		}
		} else {
	%>
		<form action="<%=request.getContextPath()%>/adminProductList">
		<p align="center"><input type="submit" value="一覧表示"></p>
		</form>
	<%
		}
	%>

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
	<br>
	<br>


</body>
</html>