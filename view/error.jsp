<html>
<%@page contentType="text/html;charset=UTF-8"%>
<%
	String cmd = (String) request.getAttribute("cmd");
	String error = (String) request.getAttribute("error");
%>
<head>
<title>エラー画面</title>
</head>
<body>
	<div style="text-align: center">
		<%@include file="/common/userHeader.jsp"%>
		<p>
			<font size="4"><%=error %></font>
		</p>


		<!-- 顧客側からのアクセスなら商品一覧へ、管理者側からのアクセスなら管理者メニュー-画面へ遷移 -->
		<%
			if (cmd.equals("admin")) {
		%>

		<a href="<%=request.getContextPath()%>/view/adminMenu.jsp">管理者メニュー画面</a>

		<%
			}
			if (cmd.equals("user")) {
		%>

		<a href="<%=request.getContextPath()%>/userProductList">ユーザー一覧画面</a>

		<%
			}
		%>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br>

	</div>
</body>
</html>