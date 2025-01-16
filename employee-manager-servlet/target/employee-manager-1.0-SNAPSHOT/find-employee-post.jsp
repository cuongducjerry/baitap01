<%@ page import="vn.edu.t3h.employeemanager.dao.DepartmentDao" %>
<%@ page import="vn.edu.t3h.employeemanager.dao.impl.DepartmentDaoMysqlImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentService" %>
<%@ page import="vn.edu.t3h.employeemanager.service.DepartmentServiceImpl" %>
<%@ page import="vn.edu.t3h.employeemanager.model.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/12/2025
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      String name = request.getParameter("department_name");
      String nameLower = name.toLowerCase();
      String nameUpper = name.toUpperCase();
      String nameFormat = "";
      int lengthOfName = name.length();
      for(int i = 0; i < lengthOfName; i++){
          if(i == 0){
            nameFormat += Character.toUpperCase(name.charAt(0));
          }
          else{
            nameFormat += Character.toLowerCase(name.charAt(i));
          }
      }
      DepartmentDao departmentDao = new DepartmentDaoMysqlImpl();
      DepartmentService departmentService = new DepartmentServiceImpl(departmentDao);

      Department department = departmentService.getDepartmentByName(nameLower);
      Department department1 = departmentService.getDepartmentByName(nameUpper);
      Department department2 = departmentService.getDepartmentByName(nameFormat);

      if(department != null){
          request.setAttribute("dept", department);
      }
      else if(department1 != null){
          request.setAttribute("dept", department1);
      }
      else if(department2 != null){
          request.setAttribute("dept", department2);
      }

    %>

    <h1>Department Name</h1>
    <h2>Department ID: ${dept.departmentID}</h2>
    <h2>Department Name: ${dept.departmentName}</h2>
    <h2>Location: ${dept.location}</h2>

</body>
</html>
