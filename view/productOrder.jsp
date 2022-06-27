<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,bean.*"%>

<%
	ArrayList<Purchase> purchase_list = (ArrayList<Purchase>) request.getAttribute("purchase_list");
	User user = (User) request.getAttribute("user");
	int month = (int) request.getAttribute("month");
	int sum = (int) request.getAttribute("sum");
%>


<html>
<head>
<title>受注状況一覧</title>
</head>
<body>
	<div style="text-align: center">
		<%@include file="/common/adminHeader.jsp"%>
		<table style="margin: auto; width: 950">
			<tr>
				<td style="width: 250"></td>
				<td align="center" style="width: 450"><h3>受注管理一覧</h3></td>
				<td><a href="<%=request.getContextPath()%>/view/adminMenu.jsp">管理者メニュー</a></td>
				<td><a href="<%=request.getContextPath()%>/userList">ユーザー一覧</a></td>
			</tr>
		</table>
		<hr style="width: 950; color: black; size: 2" />

		<!-- 直近の売上合計を表示 -->
		<table style="margin: auto; width: 950">
			<tr>
				<td style="text-align: end"><%=month%>月の売上 &emsp;<%=sum%>円</td>
			</tr>
		</table>
		<!-- 受注状況を表示 -->
		<table style="margin: auto; width: 950">
			<tr>
				<td style="width: 50; background-color: lightgreen">No</td>
				<td style="width: 100; background-color: lightgreen">氏名</td>
				<td style="width: 130; background-color: lightgreen">種類</td>
				<td style="width: 70; background-color: lightgreen">個数</td>
				<td style="width: 100; background-color: lightgreen">合計金額</td>
				<td style="width: 200; background-color: lightgreen">発注日</td>
				<td style="width: 100; background-color: lightgreen">入金状況</td>
				<td style="width: 100; background-color: lightgreen">発送状況</td>
				<td style="width: 100; background-color: lightgreen"></td>
			</tr>

			<%
				if (purchase_list != null) {
					for (Purchase purchase : purchase_list) {
			%>
			<tr>
				<td><%=purchase.getPurchase_id()%></td>
				<td><%=user.getUser_name()%></td>
				<td><%=purchase.getProduct_id()%></td>
				<td><%=purchase.getCount()%></td>
				<td><%=purchase.getAmount_money()%></td>
				<td><%=purchase.getBuy_date()%></td>
				<td><%=purchase.getPayment_date()%></td>
				<td><%=purchase.getShopping_date()%></td>
				<td><a href="<%=request.getContextPath()%>/orderDetailConfirm?purchase_id=<%=purchase.getPurchase_id()%>">詳細/更新</a></td>
			</tr>
			<%
				}
				}
			%>

		</table>
	</div>
</body>
</html>



