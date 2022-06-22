<%@page contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<title>ログイン画面</title>
	</head>

	<body>
		<div style="text-align:center">
		<%@include file="/common/header.jsp" %>
			<form action="<%=request.getContextPath()%>/login" method="POST">
			<br>
			<br>
				<table style="margin:auto ; width:600 ; text-align:center">
					<tr>
						<td style="width:200 ; background-color:slyblue">ID</td>
						<td>
							<input type="text" size="25" name="id" value="//ユーザーID">
						</td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td>
							<input type="password" size="25" name="password" value="//パスワード">
						</td>
					</tr>
				</table>
				<br>
				<br>
				<input type="submit" value="ログイン">
			</form>
		</div>
	</body>
</html>