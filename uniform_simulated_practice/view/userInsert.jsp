<%@page contentType="text/html;charset=UTF-8"%>


<html>
	<head>
		<title>会員登録画面</title>
	</head>
	<body>
		<div style="text-align:center">
			<%@include file="/common/userHeader.jsp" %>
			<!-- 会員情報入力 -->
			<br>
			<br>

			<h2>新規会員登録</h2>
			<form action="[ユーザー情報登録サーブレットへ]">
				<table style="margin:auto ; text-align:center ; width:700">
					<tr>
						<td width="200">名前</td>
						<td width="500"><input type="text" name="name" size="40"></td>
					</tr>
					<tr>
						<td width="200">住所</td>
						<td width="500"><input type="text" name="name" size="40"></td>
					</tr>
					<tr>
						<td width="200">電話番号</td>
						<td width="500"><input type="text" name="name" size="40"></td>
					</tr>
					<tr>
						<td width="200">メールアドレス</td>
						<td width="500"><input type="text" name="name" size="40"></td>
					</tr>
				</table>
				<br>
				<table style="margin:auto ; text-align:center ; width:700">
					<tr>
						<td width="200">ID</td>
						<td width="500"><input type="text" name="name"></td>
					</tr>
					<tr>
						<td width="200">パスワード</td>
						<td width="500"><input type="password" name="name"></td>
					</tr>
				</table>
				<br>

				<input type="submit" value="登録">
			</form>
		</div>
	</body>
</html>