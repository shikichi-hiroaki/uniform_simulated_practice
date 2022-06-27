<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,bean.*" %>

<%Purchase purchase = (Purchase)request.getAttribute("purchase");
Product product = (Product)request.getAttribute("product");
User user = (User)request.getAttribute("user");

%>

<html>
	<head>
		<title>商品受注状況詳細</title>
		<link rel ="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ヘッダー部分 -->
		<%@ include file="/common/adminHeader.jsp" %>

		<table style="margin: auto; width: 950">
			<tr>
				<td style="width: 250"></td>
				<td align="center" style="width: 450"><h3>受注管理一覧</h3></td>
				<td><a href="<%=request.getContextPath()%>/productOrder">商品受注一覧</a></td>
			</tr>
		</table>
		<hr style="width: 950; color: black; size: 2" />

		<!-- 受注詳細情報コンテンツ部分 -->
		<div id="main" class="container">
		<div style="text-align:center">
		<h2>受注状況詳細</h2>

			<form action = "<%=request.getContextPath()%>/orderDetailConfirm?purchase_id=<%=purchase.getPurchase_id()%>">
				<input type="hidden" name= "purchase_id" value= "<%=purchase.getPurchase_id()%>" >

				<table style="margin:auto ; width:600 ; text-align:center">
					<tr>
						<th style="width:400 ;  background-color:lightgreen">ユーザー名</th>
						<td style="width:550"><%= user.getUser_name() %></td>
					</tr>
					<tr>
						<th style="background-color:lightgreen">商品名</th>
						<td><%= product.getProduct_name() %></td>
					</tr>
					<tr>
						<th style=" background-color:lightgreen">価格</th>
						<td><%= product.getPrice() %></td>
					</tr>
					<tr>
						<th style=" background-color:lightgreen">購入数</th>
						<td><%= purchase.getCount() %></td>
					</tr>

						<tr>
							<th style=" background-color:lightgreen">入金状況</th>

							<% if(purchase.getPayment_date() != null){ %>
							<td>
								<%=purchase.getPayment_date() %>
							</td>
							<%} else{%>
							<td>
								<input type="hidden" name= "cmd" value= "conpletePayment" >
								<input type="submit" value="入金完了">
							</td>
							<%} %>
						</tr>

						<tr>
							<th style=" background-color:lightgreen">発送状況</th>

							<% if(purchase.getShopping_date() != null){ %>
							<td>
								<%= purchase.getShopping_date() %>
							</td>
							<%} else{%>
							<td>
								<input type="submit" value="発送完了">
								<input type="hidden" name= "cmd" value= "conpleteShopping" >
							</td>
							<%} %>
						</tr>
					<tr>
						<th style="background-color:lightgreen">備考欄</th>
						<td><%= purchase.getOthers() %></td>
					</tr>

				</table>
			</form>
		</div>
	</body>
</html>