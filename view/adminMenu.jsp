<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/adminstyle.css">


<html>
	<head>
		<title>管理者メニュー</title>
	</head>


	<body>
		<div style="text-align:center">
			<%@include file="/common/adminHeader.jsp" %>
			<h2>メニュー</h2>
			<hr style="width: 950; color: black; size: 2" />

			<table style="margin:auto ; width:950 ; text-align:center">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/adminProductList" >商品一覧</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/productOrder">商品受注状況一覧</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/view/productInsert.jsp" >商品登録画面</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/logout" class="mb50">ログアウト</a>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>