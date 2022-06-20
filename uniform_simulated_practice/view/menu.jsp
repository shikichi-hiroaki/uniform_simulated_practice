<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>ユーザーメニュー</title>
	</head>
		<div style="text-align:center">
			<h1 align="center">受注管理システム</h1>
			<hr align="center" size="5" color="sky blue" width="950"/>
		</div>

	<body>
	<center>
		<h2>メニュー</h2>
		<a href="<%=request.getContextPath()%><td width="220" align="center">商品一覧</a></td><br>
		<a href="<%=request.getContextPath()%><td width="220" align="center">会員情報変更</a><td><br>
		<a href="<%=request.getContextPath()%><td width="220" align="center">注文履歴</a><td><br><br>
		<a href="<%=request.getContextPath()%><td width="220" align="center">ログアウト</a><td>
	</center>
	</body>
</html>