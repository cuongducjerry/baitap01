<%@ page import="vn.edu.t3h.employeemanager.dao.EmployeeDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2025
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("employee_id");
    EmployeeDao employeeDao = new EmployeeDaoMysqlImpl();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
    Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
    request.setAttribute("emp", employee);
%>

  <h1>Edit employee</h1>
  <form action="edit-employee-post.jsp" method="post">
    <h2>ID: ${emp.employeeId}</h2>
    <br/>
    <input name="employee_id" type="hidden" value="${emp.employeeId}">

    <h2>Name </h2>
    <input name="name" type="text" placeholder="Name" value="${emp.name}">
    <br/>

    <h2>Position </h2>
    <input name="position" type="text" placeholder="Position" value="${emp.position}">
    <br/>

    <h2>Salary </h2>
    <input name="salary" type="text" placeholder="Salary" value="${emp.salary}">
    <br/>

    <h2>Department ID </h2>
    <input name="department_id" type="text" placeholder="Department ID" value="${emp.departmentID}">
    <br/>

    <h2>Hire Date </h2>
    <input name="hire_date" type="text" placeholder="Hire Date" value="${emp.hireDate}">
    <br/>

    <input type="submit" value="Edit">

  </form>

</body>
</html>
