<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,bean.*,java.util.*"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/adminstyle.css">

<%
	ArrayList<Purchase> purchase_list = (ArrayList<Purchase>) request.getAttribute("purchase_list");
	ArrayList<String> userNameList = (ArrayList<String>) request.getAttribute("userNameList");
	String month = (String) request.getAttribute("month");
	int thisMonthlySales = (int) request.getAttribute("thisMonthlySales");
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
				<td align="center" style="width: 450"><h3>受注状況一覧</h3></td>
				<td><a href="<%=request.getContextPath()%>/view/adminMenu.jsp">管理者メニュー</a></td>
				<td><a href="<%=request.getContextPath()%>/userList">ユーザー一覧</a></td>
			</tr>
		</table>
		<hr style="width: 950; color: black; size: 2" />

		<!-- 直近の売上合計を表示 -->
		<table style="margin: auto; width: 950">
			<tr>
				<td style="text-align: end">今月(<%=month%>月)の売上 &emsp;<%=thisMonthlySales%>円
				</td>
			</tr>
		</table>
		<!-- 受注状況を表示 -->
		<table style="margin: auto; width: 950">
			<tr>
				<td style="width: 50; color: white; background-color: #006600">No</td>
				<td style="width: 100; color: white; background-color: #006600">氏名</td>
				<td style="width: 130; color: white; background-color: #006600">種類</td>
				<td style="width: 70; color: white; background-color: #006600">個数</td>
				<td style="width: 100; color: white; background-color: #006600">合計金額</td>
				<td style="width: 200; color: white; background-color: #006600">発注日</td>
				<td style="width: 100; color: white; background-color: #006600">入金状況</td>
				<td style="width: 100; color: white; background-color: #006600">発送状況</td>
				<td style="width: 100; color: white; background-color: #006600"></td>
			</tr>

			<%
				if (purchase_list != null) {
					for (int i = 0; i < purchase_list.size(); i++) {
			%>
			<tr>
				<td><%=purchase_list.get(i).getPurchase_id()%></td>
				<td><%=userNameList.get(i)%></td>
				<td><%=purchase_list.get(i).getProduct_id()%></td>
				<td><%=purchase_list.get(i).getCount()%></td>
				<td><%=purchase_list.get(i).getAmount_money()%></td>
				<td><%=purchase_list.get(i).getBuy_date()%></td>
				<%
					if (purchase_list.get(i).getPayment_date() == null) {
				%>
				<td>未入金</td>
				<%
					} else {
				%>
				<td><%=purchase_list.get(i).getPayment_date()%></td>
				<%
					}
				%>
				<%
					if (purchase_list.get(i).getShopping_date() == null) {
				%>
				<td>未発送</td>
				<%
					} else {
				%>
				<td><%=purchase_list.get(i).getShopping_date()%></td>
				<%
					}
				%>
				<td><a
					href="<%=request.getContextPath()%>/orderDetailConfirm?purchase_id=<%=purchase_list.get(i).getPurchase_id()%>&user_name=<%=userNameList.get(i)%>">詳細/更新</a></td>
			</tr>
			<%
				}
				}
			%>

		</table>
	</div>
</body>
</html>



