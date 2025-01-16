<%@ page import="vn.edu.t3h.employeemanager.dao.DepartmentDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.DepartmentDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Department" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/12/2025
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

  <h1>Find employee by name</h1>
  <form action="find-employee-post.jsp" method="post">

    <h2>Name </h2>
    <input name="department_name" type="text" placeholder="Name" >
    <br/>

    <input type="submit" value="Find">

  </form>
</body>
</html>
