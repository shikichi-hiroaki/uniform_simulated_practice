<%@page contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<title>ユーザーメニュー</title>
	</head>
	<body>
		<div style="text-align:center">
		<br>
		<br>
			<%@include file="/common/userHeader.jsp" %>
			<h2>ユーザーメニュー</h2>
			<hr style="width: 950; color: black; size: 2" />
			<a href="<%=request.getContextPath()%>/userProductList">商品一覧</a>
			<br>
			<a href="<%=request.getContextPath()%>/userUpdate">会員情報変更</a>
			<br>
			<a href="<%=request.getContextPath()%>/logOrder">注文履歴</a>
			<br>
			<a href="<%=request.getContextPath()%>/logout">ログアウト</a>
		</div>
	</body>
</html>