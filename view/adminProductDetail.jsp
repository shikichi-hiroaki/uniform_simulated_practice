<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>商品詳細(管理者)</title>
</head>
<body>
	<div style="text-align: center">
	<%@include file="/common/adminHeader.jsp" %>

		<!-- メッセージ表示 -->
		<h2>商品詳細</h2>

		<img src="uniform.jpg" alt="ユニフォーム">

		<table align="center">
			<tr>
				<th style="background-color: lightgreen; width: 100">商品名</th>
				<td>[商品名]</td>
			</tr>
			<tr>
				<th style="background-color: lightgreen">金額（単価）</th>
				<td>[金額（単価）]</td>
			</tr>
			<tr>
				<th style="background-color: lightgreen">在庫数</th>
				<td>[在庫数]</td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td width="220" align="center"><a
					href="<%=request.getContextPath()%>">商品一覧</a></td>
			</tr>
			<tr>
				<td width="220" align="center"><a
					href="<%=request.getContextPath()%>">商品更新</a></td>
			</tr>
			<tr>
				<td width="220" align="center"><a
					href="<%=request.getContextPath()%>">商品削除</a></td>
			</tr>
			</div>
</body>
</html>