<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.User"%>

<%
	String mail_adress = "";
	String password = "";
	String error = (String) request.getAttribute("error");
	Cookie[] cookieList = request.getCookies();

	//クッキーがあるか判定
		if (cookieList != null) {
			for (Cookie cookie : cookieList) {
				//クッキーからユーザー情報の取得
				if (cookie.getName().equals("mail_adress")) {
					mail_adress = cookie.getValue();
				}
				//クッキーからパスワード情報の取得
				if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
		}
		if (error == null) {
			error = "";
		}
%>

<html>
	<head>
		<title>ログイン画面</title>
	</head>

	<body>
		<div style="text-align:center">
		<%@include file="/common/userHeader.jsp" %>
			<form action="<%=request.getContextPath()%>/login" method="POST">
			<br>
			<br>
				<table style="margin:auto ; width:600 ; text-align:center">
					<tr>
						<td style="width:200 ; background-color:slyblue">メールアドレス</td>
						<td>
							<input type="text" size="25" name="mailadress" value="<%=mail_adress %>">
						</td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td>
							<input type="password" size="25" name="password" value="<%=password %>">
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