<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/10/2025
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert here title</title>
</head>
<body>
    <h1>Thêm người dùng</h1>
    <form action="add-employee-post.jsp" method="post">
        <h2>ID </h2>
        <input name="employee_id" type="text" placeholder="Nhập vào mã id">
        <br/>

        <h2>Name </h2>
        <input name="name" type="text" placeholder="Nhập vào họ tên">
        <br/>

        <h2>Position </h2>
        <input name="position" type="text" placeholder="Nhập vào vị trí">
        <br/>

        <h2>Salary </h2>
        <input name="salary" type="text" placeholder="Nhập vào lương">
        <br/>

        <h2>Department ID </h2>
        <input name="department_id" type="text" placeholder="Nhập vào mã phòng ban">
        <br/>

        <h2>Hire Date </h2>
        <input name="hire_date" type="text" placeholder="Nhập ngày vào làm">
        <br/>

        <input type="submit" value="Add">

    </form>
</body>
</html>
