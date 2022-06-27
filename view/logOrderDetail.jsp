<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.PurchaseDetail,java.util.*" %>

<%
//リクエストスコープから購入情報の受け取り
PurchaseDetail purchaseDetail = (PurchaseDetail)request.getAttribute("purchaseDetail");

%>

<html>
<head>
<title>過去の注文詳細</title>
</head>
<body>
	<div style="text-align: center">
		<%@ include file="/common/userHeader.jsp"%>

		<!-- メッセージ表示 -->
		<h2>過去の注文詳細</h2>

		<img src="uniform.jpg" alt="ユニフォーム">

		<table align="center">
			<tr>
				<th style="background-color: skyblue; width: 100">商品名</th>
				<td><%=purchaseDetail.getProduct_name() %></td>
			</tr>
			<tr>
				<th style="background-color: skyblue">金額（単価）</th>
				<td><%=purchaseDetail.getPrice()%></td>
			</tr>
			<tr>
				<th style="background-color: skyblue">在庫数</th>
				<td><%=purchaseDetail.getExist_products()%></td>
			</tr>
			<tr>
				<th style="background-color: skyblue">発売状況</th>
				<%if(purchaseDetail.getOn_sale() == 0){ %>
					<td>販売中</td>
				<%} else { %>
					<td>販売終了</td>
				<%} %>
			</tr>
		</table>
		<br> <br> <br>
		<table align="center">

			<tr width="220" align="center">
				<td><a href="<%=request.getContextPath()%>/productBuy">もう一度購入</a></td>
			</tr>
			<tr width="220" align="center">
				<td><a href="<%=request.getContextPath()%>/logOrder">注文履歴</a></td>
			</tr>

		</table>
	</div>
</body>
</html>