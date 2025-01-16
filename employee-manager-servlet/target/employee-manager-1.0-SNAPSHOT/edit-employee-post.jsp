<%@ page import="vn.edu.t3h.employeemanager.model.Employee" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.EmployeeDao" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeService" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2025
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String id = request.getParameter("employee_id");
    String name = request.getParameter("name");
    String position = request.getParameter("position");
    String salary = request.getParameter("salary");
    String departmentID = request.getParameter("department_id");
    String hireDate = request.getParameter("hire_date");
    Employee employee = new Employee();
    employee.setEmployeeId(Integer.parseInt(id));
    employee.setName(name);
    employee.setPosition(position);
    employee.setSalary(Double.parseDouble(salary));
    employee.setDepartmentID(Integer.parseInt(departmentID));
    employee.setHireDate(hireDate);


    EmployeeDao employeeDao = new EmployeeDaoMysqlImpl();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
    employeeService.updateEmployee(employee);

    response.sendRedirect("employee-list.jsp");

%>