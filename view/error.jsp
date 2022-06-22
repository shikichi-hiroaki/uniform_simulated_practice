<%@page contentType="text/html;charset=UTF-8"%>


<html>
	<head>
		<title>エラー画面</title>
	</head>
	<body>
		<div style="text-align:center">
			<%@include file="/common/userHeader.jsp"%>
			<p><font size="4">[エラーメッセージ]</font></p>


			<!-- 顧客側からのアクセスなら商品一覧へ、管理者側からのアクセスなら管理者メニュー-画面へ遷移 -->
			<a href=商品一覧へのリンク>商品一覧or管理者メニュー画面</a>
		<br><br><br><br><br><br><br><br><br><br>

		</div>
	</body>
</html>