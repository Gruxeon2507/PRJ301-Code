<%-- 
    Document   : circle
    Created on : Jan 31, 2023, 1:18:03 PM
    Author     : Nguyen Hoang Minh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Circle"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                text-align: center;
            }
            #canvas {
                position: relative;
                background-color: #ccddcc;
                margin: 1em auto;
            }
            .ball {
                background-color: black;
                position: absolute;
                display: inline-block;
                border-radius: 50%;
            }
        </style>

    </head>
    <body>
        <h1>Bouncing Balls</h1>


        <div id="canvas"></div>

        
        <script>
            var canvas = {
                element: document.getElementById('canvas'),
                width: 500,
                height: 500,
                initialize: function () {
                    this.element.style.width = this.width + 'px';
                    this.element.style.height = this.height + 'px';
                    document.body.appendChild(this.element);
                }
            };

            var Ball = {
                create: function (color, dx, dy) {
                    var newBall = Object.create(this);
                    newBall.dx = dx;
                    newBall.dy = dy;
                    newBall.width = 40;
                    newBall.height = 40;
                    newBall.element = document.createElement('div');
                    newBall.element.style.backgroundColor = color;
                    newBall.element.style.width = newBall.width + 'px';
                    newBall.element.style.height = newBall.height + 'px';
                    newBall.element.className += ' ball';
                    newBall.width = parseInt(newBall.element.style.width);
                    newBall.height = parseInt(newBall.element.style.height);
                    canvas.element.appendChild(newBall.element);
                    return newBall;
                },
                moveTo: function (x, y) {
                    this.element.style.left = x + 'px';
                    this.element.style.top = y + 'px';
                },
                changeDirectionIfNecessary: function (x, y) {
                    if (x < 0 || x > canvas.width - this.width) {
                        this.dx = -this.dx;
                    }
                    if (y < 0 || y > canvas.height - this.height) {
                        this.dy = -this.dy;
                    }
                },
                draw: function (x, y) {
                    this.moveTo(x, y);
                    var ball = this;
                    setTimeout(function () {
                        ball.changeDirectionIfNecessary(x, y);
                        ball.draw(x + ball.dx, y + ball.dy);
                    }, 1000 / 60);
                }
            };

            canvas.initialize();
            
            <c:forEach items="${requestScope.circles}" var="r" varStatus="loop">
            var ball =  Ball.create("rgb(${r.red},${r.blue},${r.green})",${r.x/50}, ${r.y/50});
            ball.draw(${r.x}, ${r.y});
            console.log("<fmt:formatNumber value="${r.red}"/>")
            </c:forEach>
            <c:if test=<fmt:formatNumber type="percent" value="3.5"/>/>
        </script> 

    </body>
</html>
