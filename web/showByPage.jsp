
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王志民
  Date: 2022/7/20
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" cellspacing="0" width="70%" align="center">
    <tr>
        <td>图书编号</td>
        <td>图书名称</td>
        <td>作者</td>
        <td>出版社</td>
        <td>出版日期</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="b">
        <tr>
            <td>${b.booknum}</td>
            <td>${b.bookname}</td>
            <td>${b.bookauthor}</td>
            <td>${b.bookpublish}</td>
            <td>${b.bookdate}</td>
            <td>${b.bookprice}</td>
            <td>
                <a href="BookServlet?method=preUpdate&id=${b.id}">更新</a>
                    <%--                    <a href="BookServlet?method=del&id=${b.id}">删除</a>--%>
                <a href="javascript:deleteById(${b.id})">删除</a>
            </td>
        </tr>
    </c:forEach>

           <%-- 分页--%>
    <tr align="center">
        <td colspan="7" >
            <a href="BookServlet?method=selectByPage&pageNum=1">首页</a>
            <c:if test="${requestScope.page.pageNum != 1}">
                <a href="BookServlet?method=selectByPage&pageNum=${
                requestScope.page.pageNum-1} ">
                    上一页</a>
            </c:if>
            <c:if test="${requestScope.page.pageNum!=requestScope.page.totalPage}">
                <a href="BookServlet?method=selectByPage&pageNum=${ requestScope.page.pageNum+1} ">
                    下一页</a>
            </c:if>
            <a href="BookServlet?method=selectByPage&pageNum=${requestScope.page.totalPage}" >
                尾页</a>
            共${requestScope.page.totalPage}页
            共 ${requestScope.page.totalCount}条数据</td>
    </tr>

</table>
<script>
    //确认框  删除
    function deleteById(id){
        var b = confirm("确认删除吗？");   //true确认   false取消
        if(b){  //true  确认删除
            location = "BookServlet?method=del&id=" + id;
        }
    }
</script>
</body>
</html>
