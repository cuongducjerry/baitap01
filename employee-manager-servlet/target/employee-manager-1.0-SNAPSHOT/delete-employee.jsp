<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.EmployeeDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoMysqlImpl" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2025
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("employee_id");
    EmployeeDao employeeDao = new EmployeeDaoMysqlImpl();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
    employeeService.deleteEmployee(Integer.parseInt(id));

    response.sendRedirect("employee-list.jsp");

%>
