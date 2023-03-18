<%-- 
    Document   : search
    Created on : Feb 20, 2023, 8:17:47 PM
    Author     : Nguyen Hoang Minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="dept" method="POST">
            Dept:<select name="deptid">
                <option value="-1">all</option>
                <c:forEach items="${requestScope.depts}" var="d">
                    <option value="${d.id}">${d.name}</option>
                </c:forEach>
            </select><br><br>
            <input type="submit" value="search">
        </form>
    </body>
</html>
