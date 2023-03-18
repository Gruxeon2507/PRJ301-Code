<%-- 
    Document   : add
    Created on : Feb 14, 2023, 2:50:13 PM
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
        <form action="add" method="POST">
            Name: <input type="text" name="name"> <br>
            Gender:
            <input type = "radio" name = "gender" checked value = "male"> male
            <input type = "radio" name = "gender"  value = "female"> female <br>
            Dob:<input type = "date" name ="dob"><br>
            Department: <select name="did">
            <c:forEach items="${requestScope.depts}" var="d">
                <option value="${d.id}">${d.name}</option>
            </c:forEach>
            </select><br>
            <input type="submit" value="save" onclick="window.location.href='list'">
        </form>
        <input type="button" value="save" onclick="window.location.href='list'">
    </body>
</html>
 