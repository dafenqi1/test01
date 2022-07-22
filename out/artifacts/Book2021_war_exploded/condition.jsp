<%--
  Created by IntelliJ IDEA.
  User: 13578
  Date: 2022/7/19
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="BookServlet?method=selectByCondition" method="post">
    <table border="1px" cellspacing="0" width="400px" height="500px" align="center">
        <caption>查询书籍</caption>
        <tr>
            <td>编号</td>
            <td><input type="text" name="booknum" placeholder="编号"></td>
        </tr>
        <tr>
            <td>书名</td>
            <td><input type="text" name="bookname" placeholder="书名"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="bookauthor" placeholder="作者"></td>
        </tr>
        <tr>
            <td>出版社</td>
            <td><input type="text" name="bookpublish" placeholder="出版社"></td>
        </tr>
        <tr>
            <td>出版日期</td>
            <td><input type="date" name="bookdate"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="bookprice" placeholder="价格"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="查询"></td>
        </tr>
    </table>
</form>
</body>
</html>
