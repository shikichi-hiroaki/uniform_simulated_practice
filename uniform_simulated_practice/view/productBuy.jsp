<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>商品購入</title>
</head>
<body>
	<div style="text-align: center">
<%@ include file="/common/userHeader.jsp"%>

		<!-- メッセージ表示 -->
		<h2>商品購入</h2>

		<!-- 注文内容を表示 -->
		<table align="center">

			<tr>
				<th style="background-color: skyblue; text-align: center">ユーザーID</th>
				<th>[ログインした場合、IDを表示]<th>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">氏名</th>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">電話番号</th>
				<td><input type="text" name="denwa" value=""></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">住所</th>
				<td><textarea name="adress" rows="2" cols="50"></textarea></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">mail</th>
				<td><input type="text" name="email" value=""></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">商品</th>
				<td><select name="product">
						<option value="1">ユニフォームA</option>
						<option value="2">ユニフォームB</option>
						<option value="3">ユニフォームC</option>
						<option value="4">ユニフォームD</option>
						<option value="5">ユニフォームE</option>
				</select></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">個数</th>
				<td><input type="text" name="quantity" value=""></td>
			</tr>
			<tr>
				<th style="background-color: skyblue; text-align: center">備考</th>
				<td><textarea name="bikou" rows="4" cols="50"></textarea></td>
			</tr>
		</table>
		<br> <br> <br> <a
			href="<%=request.getContextPath()%>"></a><td width="220" align="center">購入確認</a></td><br>
			 <a
			href="<%=request.getContextPath()%>"></a><td width="220" align="center">商品一覧画面へ戻る</a></td><br>
		</div>
	</body>
</html>