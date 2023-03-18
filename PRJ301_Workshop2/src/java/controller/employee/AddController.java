/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.employee;

import controller.authentication.BaseRequiredAuthenticatedController;
import dal.DepartmentDBContext;
import dal.EmployeeDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Department;
import model.Employee;
import model.User;


/**
 *
 * @author Nguyen Hoang Minh
 */
public class AddController extends BaseRequiredAuthenticatedController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response,User user)
    throws ServletException, IOException {
        DepartmentDBContext db = new DepartmentDBContext();
        ArrayList<Department> depts = db.all();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("view/add.jsp").forward(request, response);
    } 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response,User user)
    throws ServletException, IOException {
        String raw_name = request.getParameter("name");
        String raw_gender = request.getParameter("gender");
        String raw_dob = request.getParameter("dob");
        String raw_did = request.getParameter("did");

        Employee s = new Employee();
        s.setName(raw_name);
        s.setGender(raw_gender.equals("male"));
        s.setDob(Date.valueOf(raw_dob));
        Department d = new Department();
        d.setId(Integer.parseInt(raw_did));
        s.setDept(d);
        EmployeeDBContext db = new EmployeeDBContext();
        db.insert(s);
    }
      // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
