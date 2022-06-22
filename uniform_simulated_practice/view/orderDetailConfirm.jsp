<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>商品受注状況詳細</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ヘッダー部分 -->
	<%@ include file="/common/header.jsp"%>

	<!-- 受注詳細情報コンテンツ部分 -->
	<div id="main" class="container">
		<div style="text-align: center">
			<h2>受注状況詳細</h2>
			<table style="margin: auto; width: 600; text-align: center">
				<tr>
					<th style="width: 400; background-color: skyblue">ユーザー</th>
					<td style="width: 550">[ユーザー情報]</td>
				</tr>
				<tr>
					<th style="background-color: skyblue">商品名</th>
					<td>[商品名]</td>
				</tr>
				<tr>
					<th style="background-color: skyblue">価格</th>
					<td>[価格]</td>
				</tr>
				<tr>
					<th style="background-color: skyblue">購入数</th>
					<td>[購入数]</td>
				</tr>
				<tr>
					<form action="<%=request.getContextPath()%>/orderDetailConfirm">
						<th style="background-color: skyblue">入金日</th>
						<td>[入金状況]<input type="submit" value="入金"></td>
					</form>
				</tr>
				<tr>
					<form action="<%=request.getContextPath()%>/orderDetailConfirm">
						<th style="background-color: skyblue">発送日</th>
						<td>[発送状況]<input type="submit" value="発送"></td>
					</form>
				</tr>
				<tr>
					<th style="background-color: skyblue">備考欄</th>
					<td>[備考欄]</td>
				</tr>
			</table>
		</div>
</body>
</html>