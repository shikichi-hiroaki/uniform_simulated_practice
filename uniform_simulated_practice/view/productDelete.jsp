<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>

<html>
<head>
<title>商品削除</title>
</head>
<body>
	<!-- ヘッダー -->
	<%@include file="/common/adminHeader.jsp"%>
	<h2 style="text-align: center;">商品削除</h2>
	<hr style="width: 950;">
	<div>
		<h3 style="text-align: center;">本当に削除しますか？</h3>
		<table style="margin: 0 auto;">
			<tr>
				<td>商品名</td>
				<td>[リクエストスコープで受けとった商品の商品名]</td>
			</tr>
			<tr>
				<td>価格</td>
				<td>[リクエストスコープで受けとった商品の在庫数]</td>
			</tr>
			<tr>
				<td>在庫数</td>
				<td>[リクエストスコープで受け取った商品の在庫数]</td>
			</tr>
			<tr>
				<td>商品画像</td>
				<td>リクエストスコープで受け取った商品の画像</td>
			</tr>
		</table>
		<div style="display: flex; justify-content: center; margin-top: 20px;">
			<form action="" style="display: inline-block;">
				<input type="button" name="" id="" value="削除">
			</form>
			<form action="" style="display: inline-block;">
				<input type="button" value="キャンセル">
			</form>
		</div>

	</div>
</body>
</html>