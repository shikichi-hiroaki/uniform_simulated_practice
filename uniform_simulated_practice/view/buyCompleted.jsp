<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>購入完了</title>
</head>
<body align="center">
	<%@ include file="/common/userHeader.jsp"%>
	<!-- メッセージ表示 -->
	<h3>以下の商品を購入しました。</h3>
	<h3>ご利用ありがとうございました。</h3>


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
	<br>
	<br>
	<br>
	<td width="220" align="center"><a
		href="<%=request.getContextPath()%>/リンク"> 商品一覧画面</a>
		</td>
	<br>
</body>
</html>