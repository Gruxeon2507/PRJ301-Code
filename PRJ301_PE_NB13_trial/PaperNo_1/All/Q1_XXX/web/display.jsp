<%-- 
    Document   : display.jsp
    Created on : Mar 7, 2023, 1:37:44 PM
    Author     : Nguyen Hoang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Student Name: ${requestScope.name}<br>
        Financial Source: ${requestScope.financial}<br>
        Level: ${requestScope.level}<br>
        DOE: ${requestScope.doe}
    </body>
</html>
