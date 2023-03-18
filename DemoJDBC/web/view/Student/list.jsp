<%-- 
    Document   : list
    Created on : Feb 10, 2023, 5:24:02 PM
    Author     : Nguyen Hoang Minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>StudentList</title>
    </head>
    <body>
        <table>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Gender</td>
                <td>DoB</td>
            </tr>
            <c:forEach items="${requestScope.students}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.gender}</td>
                    <td>${s.dob}</td>
                </tr>      
            </c:forEach>
        </table>

    </body>
</html>
