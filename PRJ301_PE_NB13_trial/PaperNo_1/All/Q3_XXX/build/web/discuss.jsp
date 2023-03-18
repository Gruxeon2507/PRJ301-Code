<%-- 
    Document   : forward.jsp
    Created on : Mar 7, 2023, 2:55:33 PM
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
        <c:forEach items="${requestScope.threads}" var="t">
            Thread: ${t.comment}<br>
            <c:forEach items="${requestScope.comments}" var="c">
                <c:if test="${t.id eq c.thread.id}">
                    ${c.account.displayname}: ${c.title}<br>
                </c:if>
            </c:forEach>
                    <form action="discuss" method="POST">
                        <input type="text" name="comment" >
                        <input type="text" name="threadid" value="${t.id}" hidden>
                        <input type="submit" value="Save">
                    </form>
                    <br>
        </c:forEach>
    </body>
</html>
