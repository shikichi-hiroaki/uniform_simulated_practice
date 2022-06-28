<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.Purchase,bean.Product" %>

<%
Purchase purchase = (Purchase)request.getAttribute("purchase");
String product_name = (String)request.getAttribute("product_name");

%>

<html>
<head>
<title>購入完了</title>
</head>
<body align="center">
	<%@ include file="/common/userHeader.jsp"%>
	<!-- メッセージ表示 -->
	<h3>以下の商品を購入しました。</h3>
	<h3>ご利用ありがとうございました。</h3>
	<h3>購入完了メールを送信いたしました。</h3>


	<!-- 注文内容を表示 -->
	<table align="center">
		<tr>
			<th style="background-color: skyblue; width: 100">商品名</th>
			<td><%=product_name %></td>
		</tr>
		<tr>
			<th style="background-color: skyblue">個数</th>
			<td><%=purchase.getCount() %></td>
		</tr>
		<tr>
			<th style="background-color: skyblue">合計金額</th>
			<td><%=purchase.getAmount_money() %></td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<td width="220" align="center"><a
		href="<%=request.getContextPath()%>/userProductList"> 商品一覧画面</a>
		</td>
	<br>
</body>
</html>