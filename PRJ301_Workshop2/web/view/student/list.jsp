<%-- 
    Document   : list
    Created on : Feb 14, 2023, 1:58:56 AM
    Author     : Nguyen Hoang Minh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                
                <td>Id</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Dob</td>
                <td>Department</td>
                
            </tr>
            <c:forEach items="${requestScope.students}" var="s" varStatus="loop">
                <tr<c:if test="${loop.index mod 2 ne 0}"> style="background-color: gray; "</c:if>
                >
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td><input type="checkbox" <c:if test="${s.gender}">checked</c:if>></td>
                    <td>
                    <fmt:formatDate type="date" value="${s.dob}"/>
                    </td>
                    <td>${s.dept.name}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="add">Create new Student</a>
    </body>
</html>
