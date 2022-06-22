<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
		<title>商品一覧(共通)</title>
	</head>
<jsp:include page="/common/userHeader.jsp" flush="true" />
<body>
	<table align="center" width="850">
		<tr>
			<td width="80">&nbsp;</td>
			<td width="80">&nbsp;</td>
			<td width="508" align="center"><font size="5">商品一覧</font></td>
			<td width="80">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">ログイン</a>]
			</td>
			<td width="80">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">会員登録</a>]
			</td>
		</tr>
	</table>

	<hr align="center" size="2" color="black" width="950"></hr>

	<p align="center">ユニフォーム一覧</p>

	<br>

	<p align="center"><a href="<%=request.getContextPath()%>/view/menu.jsp">・ユニフォームA</a></p>
	<p align="center"><a href="<%=request.getContextPath()%>/リンク">・ユニフォームB</a></p>
	<p align="center"><a href="<%=request.getContextPath()%>/リンク">・ユニフォームC</a></p>
	<p align="center"><a href="<%=request.getContextPath()%>/リンク">・ユニフォームD</a></p>
	<p align="center"><a href="<%=request.getContextPath()%>/リンク">・ユニフォームE</a></p>

	<br>
	<br>

	<form action="<%=request.getContextPath()%>/view/menu.jsp">
	<p align="center"><input type="submit" value="購入"></p>
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

	<hr align="center" size="5" color="blue" width="950"></hr>
	<jsp:include page="/common/footer.jsp" flush="true" />
</body>
</html>