/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.employee;

import controller.authentication.BaseRequiredAuthenticatedController;
import dal.DBContext;
import dal.EmployeeDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Employee;

import model.User;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class ListController extends BaseRequiredAuthenticatedController{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp,User user) throws ServletException, IOException {
        processRequest(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        processRequest(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        DBContext<Employee> db = new EmployeeDBContext();
        ArrayList<Employee> students = db.all();
        req.setAttribute("students", students);
        req.getRequestDispatcher("../view/employee/list.jsp").forward(req, resp);
        
    }
    
}
