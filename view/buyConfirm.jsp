<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.Product,bean.Purchase,dao.PurchaseDAO"%>

<%
	Purchase purchase = (Purchase) request.getAttribute("purchase");
	Purchase purchases = new Purchase();
%>
<html>
<head>
<title>購入確認</title>
</head>
<body>
	<div style="text-align: center">
		<%@ include file="/common/userHeader.jsp"%>

		<!-- メッセージ表示 -->
		<h2>以下の商品を購入しますか。</h2>

		<!-- 注文内容を表示 -->
		<table align="center">
			<tr>
				<th style="background-color: skyblue; width: 100">商品名</th>
				<td><%=purchase.getProduct_id() %></td>
			</tr>
			<tr>
				<th style="background-color: skyblue">個数</th>
				<td><%=purchase.getCount() %></td>
			</tr>
			<tr>
				<th style="background-color: skyblue">金額(合計)</th>
				<td><%=purchase.getAmount_money() %></td>
			</tr>
		</table>
		<br> <br> <br> <a
			href="<%=request.getContextPath()%>/buyCompleted">
			<td width="220"align="center">購入</td></a>
		</td>
		<br> <a href="<%=request.getContextPath()%>/productBuy">
		<tdwidth="220" align="center">商品購入画面へ戻る</tdwidth></a>
		</td>
		<br>
	</div>
</body>
</html>