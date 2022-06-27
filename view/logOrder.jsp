<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.PurchaseDetail,java.util.*" %>

<%
//リクエストスコープから購入情報の受け取り
ArrayList<PurchaseDetail> list = (ArrayList<PurchaseDetail>)request.getAttribute("list");

%>


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
					<td style="width:100 ; background-color:skyblue">詳細</td>
					<td style="width:150 ; background-color:skyblue">購入日</td>
				</tr>
				<%for(int i = 0 ; i < list.size() ; i++){ %>
				<tr valign="top">
					<td style="width:200"><%=list.get(i).getProduct_name() %></td>
					<td style="width:100"><%=list.get(i).getCount() %></td>
					<td align="left" style="width:400"><%=list.get(i).getOthers() %></td>
					<!-- 注文履歴詳細へ、注文IDと共にGET送信のリンクを表示 -->
					<td style="width:100"><a href="<%=request.getContextPath()%>/logDetail?purchase_id=<%=list.get(i).getPurchase_id()%>">[詳細]</a></td>
					<td style="width:150"><%=list.get(i).getBuy_date() %></td>
				</tr>
				<%
				}
				%>
			</table>
			<br>
			<p align="center"><a href="<%=request.getContextPath()%>/view/userMenu.jsp">ユーザーメニュー</a></p>
		</div>
	</body>
</html>
