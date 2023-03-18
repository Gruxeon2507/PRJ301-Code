<%-- 
    Document   : studentManager
    Created on : Feb 3, 2023, 3:41:57 PM
    Author     : Nguyen Hoang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Manager</title>
        <style>
            body{
                display: flex;
                justify-content: center;
            }
            .box h1{
                text-align: center;
            }
            table, th, td {
                border:1px solid black;
            }
            td{
                padding: 0px 40px;
            }
        </style>
    </head>
    <body>
        <% ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");%>
        <div class="box">
        <h1>STUDENT LIST</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
            </tr>
            <% for(Student s:students){%>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <% if(s.isGender()==true){%>
                <td><input type="checkbox" checked /></td>
                    <%}else{%>
                <td><input type="checkbox"/></td>
                    <%}%>
            </tr>
            <%}%>
        </table>
        </div>
    </body>
</html>
