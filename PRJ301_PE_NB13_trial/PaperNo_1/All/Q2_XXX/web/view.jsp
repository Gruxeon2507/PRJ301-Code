<%-- 
    Document   : view
    Created on : Mar 7, 2023, 2:05:12 PM
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
        <table>
            <thead>
            <td>sid</td>
            <td>name</td>
            <td>gender</td>
            <td>dob</td>
            </thead>
            <c:forEach items="${requestScope.students}" var="s">
                <tr>
                <td>${s.sid}</td>
                <td>${s.name}</td>
                <td>
                <c:if test="${s.gender}">1</c:if>
                 <c:if test="${s.gender ne true}">0</c:if>
                
                </td>
                <td>${s.dob}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
