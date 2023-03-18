<%-- 
    Document   : update
    Created on : Feb 13, 2023, 11:02:02 AM
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
        <form action="update" method="POST"> 
            <input type="hidden" name="id" value="${param.id}"/>
            Name: <input type="text" name="name" value="${student.name}"/> <br/>
            Gender: <input type="radio" name="gender" value="male"
                           ${student.gender?"checked=\"checked\"":""}
                           /> Male
            <input type="radio" name="gender" value="female"
                            ${!student.gender?"checked=\"checked\"":""}
                   /> Female <br/>
            Dob : <input type="date" name="dob" value="${student.dob}"/> <br/>
            Department :
            <select name="did">
                <c:forEach items="${requestScope.depts}" var="d">
                    <option value="${d.id}" 
                            <c:if test="${requestScope.student.dept.id eq d.id}">selected="selected"</c:if>
                            >${d.name}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
