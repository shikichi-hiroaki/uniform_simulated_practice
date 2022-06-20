<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>ログイン画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

		<!-- ブラウザ全体 -->
		<div id="wrap">
			<!-- ヘッダー部分 -->
			<%@ include file="/common/header.jsp" %>
			<div style="text-align:center">
				<h1 align="center">受注管理システム</h1>
				<hr align="center" size="5" color="sky blue" width="950"/>
			</div>
	</head>

	<body>
				<form action="<%=request.getContextPath()%>/login" method="POST">
					<table class="input-table">
						<tr>
							<th>ID</th>
							<td>
								<input type="text" size="25" name="id" value="//ユーザーID">
							</td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td>
								<input type="password" size="25" name="password" value="//パスワード">
							</td>
						</tr>
					</table>
					<input type="submit" value="ログイン">
				</form>
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/header.jsp" %>
		</div>
	</body>
</html>