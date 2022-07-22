<%--
  Created by IntelliJ IDEA.
  User: 13578
  Date: 2022/7/19
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="BookServlet?method=updateById" method="post">
        <input type="hidden" name="id" value="${requestScope.book.id}">
        <table border="1px" cellspacing="0" width="400px" height="500px" align="center">
            <caption>修改书籍</caption>
            <tr>
                <td>编号</td>
                <td><input type="text" name="booknum" placeholder="编号" value="${requestScope.book.booknum}"></td>
            </tr>
            <tr>
                <td>书名</td>
                <td><input type="text" name="bookname" placeholder="书名" value="${requestScope.book.bookname}"></td>
            </tr>
            <tr>
                <td>作者</td>
                <td><input type="text" name="bookauthor" placeholder="作者" value="${requestScope.book.bookauthor}"></td>
            </tr>
            <tr>
                <td>出版社</td>
                <td><input type="text" name="bookpublish" placeholder="出版社" value="${requestScope.book.bookpublish}"></td>
            </tr>
            <tr>
                <td>出版日期</td>
                <td><input type="date" name="bookdate" value="${requestScope.book.bookdate}"></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" name="bookprice" placeholder="价格" value="${requestScope.book.bookprice}"></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="更新"></td>
            </tr>
        </table>
    </form>
</body>
</html>
