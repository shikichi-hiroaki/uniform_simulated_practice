<%@page contentType="text/html; charset=UTF-8"%>
<html>
<jsp:include page="/common/header.jsp" flush="true" />
<body>
	<table align="center" width="850">
		<tr>
			<td width="120">&nbsp;</td>

			<td width="508" align="center"><font size="5">商品一覧</font></td>
			<td width="120">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">管理者メニュー</a>]
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