<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*" %>

<html>
    <head>
        <title>商品登録</title>
        <style>
            tr td:first-child {
                background-color: skyblue;
            }
        </style>
    </head>
    <body>
        <!-- ヘッダー -->
		<%@include file="/common/header.jsp" %>

        <h2 style="text-align: center;">商品登録</h2>
        <hr style="width: 950;">
        <!-- 商品登録フォーム -->
        <form action="" style="margin: 50px;">
            <table style="margin:auto;">
                <tr>
                    <td>商品名</td>
                    <td><input type="text" name="" id=""></td>
                </tr>
                <tr>
                    <td>価格</td>
                    <td><input type="text" name="" id=""></td>
                </tr>
                <tr>
                    <td>在庫数</td>
                    <td><input type="number" name="" id=""></td>
                </tr>
                <tr>
                    <td>商品画像</td>
                    <td><input type="file" name="" id=""></td>
                </tr>
            </table>
            <div style="text-align: center; margin: 20px;">
                <input type="submit" value="登録" name="">
            </div>
        </form>
    </body>
</html>