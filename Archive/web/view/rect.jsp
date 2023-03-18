<%-- 
    Document   : newjsp
    Created on : Jan 30, 2023, 10:44:30 AM
    Author     : ngotungson
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MyRect"%>


<!DOCTYPE html>
<html>
    <body>
    
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
            Your browser does not support the HTML5 canvas tag.</canvas>
       
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
                    <c:forEach items="${requestScope.rects}" var="r" varStatus="loop">
                <c:if test="${loop.index mod 2 eq 0}">
                    ctx.fillStyle = "rgb(${r.red},${r.green},${r.blue})";
                    ctx.fillRect(${r.x}, ${r.y}, ${r.w}, ${r.h});
                </c:if>
            </c:forEach>
        </script>

    </body>
</html>

