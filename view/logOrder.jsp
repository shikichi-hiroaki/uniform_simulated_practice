<%@page contentType="text/html;charset=UTF-8"%>


<html>
	<head>
		<title>過去の注文履歴</title>
	</head>
	<body>
		<div style="text-align:center">
			<%@include file="/common/userHeader.jsp" %>
			<!-- 過去の注文状況一覧画面 -->
			<h2>過去の注文履歴</h2>
			<hr color="black" width="950" size="3"/>
			<br>
			<table style="margin:auto ; width:950 ; text-align:center">
				<tr>
					<td style="width:200 ; background-color:skyblue">商品名</td>
					<td style="width:100 ; background-color:skyblue">購入個数</td>
					<td style="width:400 ; background-color:skyblue">備考欄</td>
					<td style="width:150 ; background-color:skyblue">購入日</td>
					<td style="width:100 ; background-color:skyblue">詳細</td>
				</tr>
				<tr valign="top">
					<td style="width:200">[商品名]</td>
					<td style="width:100">[購入個数]</td>
					<td align="left" style="width:400">[備考欄(200文字)]</td>
					<td style="width:150">[購入日]</td>
					<td style="width:100"><a href="過去の注文詳細画面へのリンク">[詳細]</a></td>
				</tr>
				<tr valign="top">
					<td style="width:200">[商品名]</td>
					<td style="width:100">[購入個数]</td>
					<td align="left" style="width:400">[備考欄(200文字)]</td>
					<td style="width:150">[購入日]</td>
					<td style="width:100"><a href="過去の注文詳細画面へのリンク">[詳細]</a></td>
				</tr>
			</table>
			<br>
			<p align="center"><a href="ユーザーメニューへのリンク">ユーザーメニュー</a></p>
		</div>
	</body>
</html>
