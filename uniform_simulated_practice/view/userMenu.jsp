<%@page contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<title>ユーザーメニュー</title>
	</head>
	<body>
		<div style="text-align:center">
		<br>
		<br>
			<%@include file="/common/header.jsp" %>
			<h2>ユーザーメニュー</h2>
			<hr style="width: 950; color: black; size: 2" />
			<a href="<%=request.getContextPath()%>/リンク">商品一覧</a>
			<br>
			<a href="<%=request.getContextPath()%>/リンク">会員情報変更</a>
			<br>
			<a href="<%=request.getContextPath()%>/リンク">注文履歴</a>
			<br>
			<a href="<%=request.getContextPath()%>リンク">ログアウト</a>
		</div>
	</body>
</html>