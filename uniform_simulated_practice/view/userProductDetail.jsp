<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>商品詳細</title>
</head>
<body>
	<div style="text-align: center">
		<h1 align="center">受注管理システム</h1>
		<hr align="center" size="5" color="sky blue" width="950" />

		<!-- メッセージ表示 -->
		<h2>商品詳細</h2>

		<img src="uniform.jpg" alt="ユニフォーム">

		<table align="center">
			<tr>
				<th style="background-color: skyblue; width: 100">商品名</th>
				<td>[商品名]</td>
			</tr>
			<tr>
				<th style="background-color: skyblue">金額（単価）</th>
				<td>[金額（単価）]</td>
			</tr>
			<tr>
				<th style="background-color: skyblue">在庫数</th>
				<td>[在庫数]</td>
			</tr>
		</table>
		<br> <br> <br>
		<table align="center">

			<tr width="220" align="center">
				<td><a href="<%=request.getContextPath()%>">商品一覧</a></td>
			</tr>
			<tr width="220" align="center">
				<td><a href="<%=request.getContextPath()%>">商品更新</a></td>
			</tr>
			<tr width="220" align="center">
				<td><a href="<%=request.getContextPath()%>">商品削除</a></td>
			</tr>
		</table>
	</div>
</body>
</html>