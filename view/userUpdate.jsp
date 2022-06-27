<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.User"%>
<%
	//セッションからユーザー情報を取得
	User user = (User) session.getAttribute("user");
%>

<html>
<head>
<title>会員情報確認・更新</title>
</head>
<body>
	<div style="text-align: center">
		<%@include file="/common/userHeader.jsp"%>
		<!-- 会員情報入力 -->
		<br> <br>

		<h2>会員情報確認・更新</h2>
		<form action="<%=request.getContextPath()%>/userUpdate">
			<table style="margin: auto; text-align: center; width: 700">
				<tr>
					<td width="200">メールアドレス</td>
					<td width="500"><%=user.getMail_adress()%></td>
				</tr>
				<tr>
					<td width="200">名前</td>
					<td width="500"><input type="text" name="user_name" size="40"
						value="<%=user.getUser_name()%>"></td>
				</tr>
				<tr>
					<td width="200">住所</td>
					<td width="500"><input type="text" name="place" size="40"
						value="<%=user.getPlace()%>"></td>
				</tr>
				<tr>
					<td width="200">電話番号</td>
					<td width="500"><input type="text" name="phone_number"
						size="40" value="<%=user.getPhone_number()%>"></td>
				</tr>

			</table>
			<br>
			<table style="margin: auto; text-align: center; width: 700">
				<tr>
					<td width="200">パスワード</td>
					<td width="500"><input type="password" name="password"></td>
				</tr>
			</table>
			<br> <input type="submit" value="更新">
		</form>
	</div>
</body>
</html>