<%@ page import="vn.edu.t3h.employeemanager.dao.EmployeeDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.EmployeeServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.DepartmentDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.DepartmentDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Department" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.TreeSet" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/13/2025
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Search Employee</h1>
    <form action="search-employee-post.jsp" method="post">
        <table>
            <tr>
                <td>Name:
                    <input name="name" type="text" placeholder="name">
                </td>
                <td>Salary:
                    <input name="salary" type="text" placeholder="salary">
                </td>
                <td>From Hire Date:
                    <input name="from_hire_date" type="date" placeholder="">
                </td>
                <td>To Hire Date:
                    <input name="to_hire_date" type="date" placeholder="">
                </td>
                <td>Position
                    <input name="position" type="text" placeholder="position">
                </td>
                <td>
                    <input type="submit" value="Search">
                </td>
            </tr>
        </table>

        <table>
            <thead>
            <tr>
                <th>Employee Id</th>
                <th> | </th>
                <th>Name</th>
                <th> | </th>
                <th>Position</th>
                <th> | </th>
                <th>Salary</th>
                <th> | </th>
                <th>Department Name</th>
                <th> | </th>
                <th>Hire Date</th>
            </tr>

            <%
                List<Employee> emps = (List<Employee>) request.getAttribute("searchEmployees");
            %>

            <c:forEach var="employee" items="<%=emps%>">
            <tr>
                <td>${employee.employeeId}</td>
                <td> | </td>
                <td>${employee.name}</td>
                <td> | </td>
                <td>${employee.position}</td>
                <td> | </td>
                <td>${employee.salary}</td>
                <td> | </td>
                <td>${employee.departmentID}</td>
                <td> | </td>
                <td>${employee.hireDate}</td>
            </tr>
            </c:forEach>
            </thead>

        </table>

    </form>
</body>
</html>
