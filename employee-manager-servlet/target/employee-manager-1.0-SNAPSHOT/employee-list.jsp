<%@ page import="vn.edu.t3h.employeemanager.dao.EmployeeDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2025
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Employee List</h1>
<table>
  <thead>
  <tr>
    <th>Employee Id</th>
    <th>Name</th>
    <th>Position</th>
    <th>Salary</th>
    <th>Department Name</th>
    <th>Hire Date</th>
    <th>Select</th>
  </tr>
  </thead>
  <tbody>
  <%
    EmployeeDao employeeDao = new EmployeeDaoMysqlImpl();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
    List<Employee> employees = employeeService.getAllEmployee();
    request.setAttribute("employeeData",employees);
  %>

  <c:forEach var="employee" items="${employeeData}">
    <tr>
      <td>${employee.employeeId}</td>
      <td>${employee.name}</td>
      <td>${employee.position}</td>
      <td>${employee.salary}</td>
      <td>${employee.departmentID}</td>
      <td>${employee.hireDate}</td>
      <th>
        <a href="edit-employee.jsp?employee_id=${employee.employeeId}">Update</a> |
        <a href="delete-employee.jsp?employee_id=${employee.employeeId}">Delete</a>
      </th>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
