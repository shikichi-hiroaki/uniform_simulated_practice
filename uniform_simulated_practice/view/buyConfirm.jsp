<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>購入確認</title>
</head>
<body>
	<div style="text-align: center">
		<h1 align="center">受注管理システム</h1>
		<hr align="center" size="5" color="sky blue" width="950" />

		<!-- メッセージ表示 -->
		<h2>以下の商品を購入しますか。</h2>

		<!-- 注文内容を表示 -->
		<table align="center">
			<tr>
				<th style="background-color: skyblue; width: 100">商品名</th>
				<td>[商品名]</td>
			</tr>
			<tr>
				<th style="background-color: skyblue">個数</th>
				<td>[個数]</td>
			</tr>
			<tr>
				<th style="background-color: skyblue">金額(合計)</th>
				<td>[金額(合計)]</td>
			</tr>
		</table>
		<br> <br> <br> <a
			href="<%=request.getContextPath()%><td width="220" align="center">購入</a></td><br>
			 <a
			href="<%=request.getContextPath()%><td width="220" align="center">商品購入画面へ戻る</a></td><br>
		</div>
	</body>
</html>