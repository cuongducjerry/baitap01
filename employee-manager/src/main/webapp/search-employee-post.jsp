<%@ page import="java.util.Date" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.EmployeeDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/13/2025
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String salary = request.getParameter("salary");
    double salary1 = 0;
    if (salary != null && !salary.isEmpty()) {
        try {
            salary1 = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salary1 = 0;
        }
    }
    String fromDate = request.getParameter("from_hire_date");
    String toDate = request.getParameter("to_hire_date");
    String position = request.getParameter("position");

    EmployeeDao employeeDao = new EmployeeDaoMysqlImpl();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
    List<Employee> employees = employeeService.searchEmployees(name, salary1, fromDate, toDate, position);
    request.setAttribute("searchEmployees",employees);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("search-employee.jsp");
    requestDispatcher.forward(request,response);
%>

</body>
</html>
