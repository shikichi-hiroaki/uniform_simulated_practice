<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*" %>

<html>
	<head>
		<title>受注状況一覧</title>
	</head>
	<body>
		<div style="text-align:center">
			<%@include file="/common/header.jsp" %>
			<h3>受注管理一覧</h3>
			<hr style="width:950 ; color:black ; size:2 "/>

			<!-- 直近の売上合計を表示 -->
			<table style="margin:auto ; width:950" >
				<tr>
					<td style="text-align:end">
					[リクエストスコープから受け取った今の月]月の売上(発送完了分)  [リクエストスコープで受け取った売上合計]
					</td>
				</tr>
				<tr>
					<td style="text-align:end">
					[リクエストスコープから受け取った今の月]月の売上(発送完了分)  [リクエストスコープで受け取った売上合計]
					</td>
				</tr>
			</table>
			<!-- 受注状況を表示 -->
			<table style="margin:auto ; width:950">
				<tr>
					<td style="width:50 ;  background-color:skyblue">No</td>
					<td style="width:100 ; background-color:skyblue">氏名</td>
					<td style="width:130 ; background-color:skyblue">種類</td>
					<td style="width:70 ; background-color:skyblue">個数</td>
					<td style="width:100 ; background-color:skyblue">合計金額</td>
					<td style="width:200 ; background-color:skyblue">発注日</td>
					<td style="width:100 ; background-color:skyblue">入金状況</td>
					<td style="width:100 ; background-color:skyblue">発送状況</td>
					<td style="width:100 ; background-color:skyblue"></td>
				</tr>
				<tr>
					<td>[リクエストスコープから受け取ったNo]</td>
					<td>[リクエストスコープから受け取った氏名]</td>
					<td>[リクエストスコープから受け取った種類]</td>
					<td>[リクエストスコープから受け取った個数]</td>
					<td>[リクエストスコープから受け取った合計金額]</td>
					<td>[リクエストスコープから受け取った発注日]</td>
					<td>[リクエストスコープから受け取った入金状況]</td>
					<td>[リクエストスコープから受け取った発送状況]</td>
					<td><a href="リンク?No= &&cmd=">詳細</a>/<a href="リンク?No= &&cmd=">更新</a></td>
				</tr>
			</table>
		</div>
	</body>
</html>



