/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Rectangle;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class RectView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Rectangle> list = (ArrayList<Rectangle>) req.getAttribute("rectangle");
        resp.getWriter().println("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>"
                + "<style>"
                + "body {\n"
                + "    text-align: center;\n"
                + "}\n"
                + "#canvas {\n"
                + "    position: relative;\n"
                + "    background-color: #ccddcc;\n"
                + "    margin: 1em auto;\n"
                + "}\n"
                + ".ball {\n"
                + "    background-color: black;\n"
                + "    position: absolute;\n"
                + "    display: inline-block;\n"
                + "    border-radius: 50%;\n"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<a href='/Rectangle/'>back to home page</a>"
                + "<div id='canvas'></div>"
                + "<script>\n"
                + "var canvas = {\n"
                + "    element: document.getElementById('canvas'),\n"
                + "    width: 600,\n"
                + "    height: 400,\n"
                + "    initialize: function () {\n"
                + "        this.element.style.width = this.width + 'px';\n"
                + "        this.element.style.height = this.height + 'px';\n"
                + "        document.body.appendChild(this.element);\n"
                + "    }\n"
                + "};\n"
                + "\n"
                + "var Ball = {\n"
                + "    create: function (color, dx, dy) {\n"
                + "        var newBall = Object.create(this);\n"
                + "        newBall.dx = dx;\n"
                + "        newBall.dy = dy;\n"
                + "        newBall.width = 40;\n"
                + "        newBall.height = 40;\n"
                + "        newBall.element = document.createElement('div');\n"
                + "        newBall.element.style.backgroundColor = color;\n"
                + "        newBall.element.style.width = newBall.width + 'px';\n"
                + "        newBall.element.style.height = newBall.height + 'px';\n"
                + "        newBall.element.className += ' ball';\n"
                + "        newBall.width = parseInt(newBall.element.style.width);\n"
                + "        newBall.height = parseInt(newBall.element.style.height);\n"
                + "        canvas.element.appendChild(newBall.element);\n"
                + "        return newBall;\n"
                + "    },\n"
                + "    moveTo: function (x, y) {\n"
                + "        this.element.style.left = x + 'px';\n"
                + "        this.element.style.top = y + 'px';\n"
                + "    },\n"
                + "    changeDirectionIfNecessary: function (x, y) {\n"
                + "        if (x < 0 || x > canvas.width - this.width) {\n"
                + "            this.dx = -this.dx;\n"
                + "        }\n"
                + "        if (y < 0 || y > canvas.height - this.height) {\n"
                + "            this.dy = -this.dy;\n"
                + "        }\n"
                + "    },\n"
                + "    draw: function (x, y) {\n"
                + "        this.moveTo(x, y);\n"
                + "        var ball = this;\n"
                + "        setTimeout(function () {\n"
                + "            ball.changeDirectionIfNecessary(x, y);\n"
                + "            ball.draw(x + ball.dx, y + ball.dy);\n"
                + "        }, 1000 / 60);\n"
                + "    }\n"
                + "};"
                + "canvas.initialize();"
        );
        for (int i = 0; i < list.size(); i++) {
            resp.getWriter().println("var ball" + i + " =  Ball.create(\"blue\", " + list.get(i).getX()/50 + ", " + list.get(i).getY()/50 + ");\n");
            resp.getWriter().println("ball" + i + ".draw(50,0);");
        }
        resp.getWriter().println("</script>"
                + "</body>\n"
                + "</html> ");
    }

}
