<%@page contentType="text/html;charset=UTF-8"%>

<html>
    <head>
        <title></title>
        <style>
            tr td:first-child {
                background-color: skyblue;
            }
        </style>
    </head>
    <body>
        <!-- ヘッダー -->
        <%@include file="/common/header.jsp" %>
        <!-- ページタイトル -->
        <h2 style="text-align: center;">商品更新</h2>
        <hr size="5" style="width: 950px;">
        <!-- 商品更新フォーム -->
        <form action="" style="margin: 50px;">
            <table style="margin: 0 auto;">
                <tr>
                    <td>商品名</td>
                    <td><input type="text" name="" id="" value="[商品名]"></td>
                </tr>
                <tr>
                    <td>価格</td>
                    <td><input type="text" name="" id="" value="[価格]"></td>
                </tr>
                <tr>
                    <td>在庫数</td>
                    <td><input type="number" name="" id="" value="[在庫数]"></td>
                </tr>
                <tr>
                    <td>商品画像</td>
                    <td><input type="file" name="" id=""></td>
                </tr>
            </table>
            <div style="text-align: center; margin: 20px;"">
                <input type="submit" value="更新" name="">
            </div>
        </form>
    </body>
</html>