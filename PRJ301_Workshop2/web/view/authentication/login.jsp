<%-- 
    Document   : login.jsp
    Created on : Feb 27, 2023, 9:56:06 PM
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
        <form action="login" method="POST">
            username: <input type="text" name="username"> <br>
            password: <input type="password" name="password"> <br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
