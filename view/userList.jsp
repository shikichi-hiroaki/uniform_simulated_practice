<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,bean.User"%>

<%
	ArrayList<User> user_list = (ArrayList<User>) request.getAttribute("user_list");
%>

<html>
	<head>
		<title>ユーザー一覧</title>
	</head>
	<body>
		<div style="text-align:center">
			<%@include file="/common/adminHeader.jsp" %>
			<table style="margin:auto ; width:950">
				<tr>
					<td style="width:250"></td>
					<td align="center" style="width:450"><h3>ユーザー情報一覧</h3></td>
					<td style="width:250"><a href="<%=request.getContextPath()%>/view/adminMenu.jsp">管理者メニュー</a></td>
				<tr>
			</table>
			<hr style="width:950 ; color:black ; size:2 "/>

			<!-- ユーザー情報一覧を表示 -->
			<table style="margin:auto ; width:950">
				<tr>
					<td style="width:100 ; background-color:lightgreen">氏名</td>
					<td style="width:150 ; background-color:lightgreen">メールアドレス</td>
					<td align="left" style="width:300; background-color:lightgreen">住所</td>
					<td style="width:150 ; background-color:lightgreen">電話番号</td>
					<td style="width:100 ; background-color:lightgreen">注文履歴</td>
				</tr>

				<%
				ArrayList<User> list = (ArrayList<User>)request.getAttribute("user_list");
				if(user_list != null){
					for(int i=0;i<list.size();i++){
						User user = (User)list.get(i);
				%>

				<tr>
					<td align="center" width="100"><%=user.getUser_name() %></td>
					<td align="center" width="100"><%=user.getMail_adress() %></td>
					<td align="center" width="100"><%=user.getPlace() %></td>
					<td align="center" width="100"><%=user.getPhone_number() %></td>
						<td style="width:100">
							<a href="<%=request.getContextPath()%>/productOrder?mail_adress=<%=user.getMail_adress()%>">注文履歴</a>
						</td>
				</tr>
				<%
					}
				}
				%>

			</table>
		</div>
	</body>
</html>
