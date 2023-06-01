package com.example.employeeservice;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init(){
        this.employeeService = new EmployeeService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Employee> employees = employeeService.getEmployee(request);
        request.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        employeeService.manageEmployee(request);
        request.setAttribute("employees", employeeService.getEmployee(request));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}