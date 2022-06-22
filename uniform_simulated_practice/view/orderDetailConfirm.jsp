<%@page contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<title>商品受注状況詳細</title>
		<link rel ="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ヘッダー部分 -->
		<%@ include file="/common/adminHeader.jsp" %>

		<!-- 受注詳細情報コンテンツ部分 -->
		<div id="main" class="container">
		<div style="text-align:center">
		<h2>受注状況詳細</h2>
			<table style="margin:auto ; width:600 ; text-align:center">
				<tr>
					<th style="width:400 ;  background-color:lightgreen">ユーザー</th>
					<td style="width:550">[ユーザー情報]</td>
				</tr>
				<tr>
					<th  style="background-color:lightgreen">商品名</th>
					<td>[商品名]</td>
				</tr>
				<tr>
					<th style=" background-color:lightgreen">価格</th>
					<td>[価格]</td>
				</tr>
				<tr>
					<th style=" background-color:lightgreen">購入数</th>
					<td>[購入数]</td>
				</tr>
				<tr>
					<th style=" background-color:lightgreen">入金状況</th>
					<td>[入金状況]<input type="submit" value="入金完了"></td>
				</tr>
				<tr>
					<th style=" background-color:lightgreen">発送状況</th>
					<td>[発送状況]<input type="submit" value="発送完了"></td>
				</tr>
				<tr>
					<th style="background-color:lightgreen">備考欄</th>
					<td>[備考欄]</td>
				</tr>
			</table>
		</div>
	</body>
</html>