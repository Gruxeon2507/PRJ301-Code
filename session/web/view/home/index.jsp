<%-- 
    Document   : index
    Created on : Feb 23, 2023, 9:17:25 AM
    Author     : sonnt
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
        <c:if test="${sessionScope.user ne null}">
            <h1>Hello ${sessionScope.user.displayname}</h1>
        </c:if>
        <c:if test="${sessionScope.user eq null}">
            You are not yet logged in.
        </c:if>
    </body>
</html>
