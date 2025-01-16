<%@ page import="vn.edu.t3h.employeemanager.dao.DepartmentDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.DepartmentDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.controller.DepartmentServlet" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2025
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Department List</h1>
<table>
    <thead>
    <tr>
        <th>Department Id</th>
        <th>Department Name</th>
        <th>Location</th>
    </tr>
    </thead>
    <tbody>
    <%
        DepartmentDao departmentDao = new DepartmentDaoMysqlImpl();
        DepartmentService departmentService = new DepartmentServiceImpl(departmentDao);
        List<Department> departments = departmentService.getAllDepartment();
        request.setAttribute("departmentData", departments);
    %>

    <c:forEach var="department" items="${departmentData}">
        <tr>
            <td>${department.departmentID}</td>
            <td>${department.departmentName}</td>
            <td>${department.location}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
