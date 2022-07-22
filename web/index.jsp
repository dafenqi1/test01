<%--
  Created by IntelliJ IDEA.
  User: 13578
  Date: 2022/7/19
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <style>
          a{
              text-decoration: none;
          }
      </style>
  </head>
  <body>
      <h1><a href="addBook.jsp">添加书籍</a></h1>
      <h1><a href="BookServlet?method=selectAll">查询全部</a></h1>
      <h1><a href="BookServlet?method=selectByPage&pageNum=1">分页查询</a></h1>
      <h1><a href="condition.jsp">条件查询</a></h1>
  </body>
</html>
