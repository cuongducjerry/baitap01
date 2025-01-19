<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Employee</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .form-container {
      max-width: 600px;
      margin: 50px auto;
      background: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>
<body>
<div class="container">
  <div class="form-container">
    <h2 class="mb-4 text-center">Edit Employee</h2>
    <form action="update-employee" method="GET">
      <%
        String id = request.getParameter("id");
        request.setAttribute("ID", id);
      %>
      <input type="hidden" name="id" value="${ID}">
      <div class="mb-3">
        <label for="name" class="form-label">Edit Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Enter employee name" required>
      </div>
      <div class="mb-3">
        <label for="position" class="form-label">Edit Position</label>
        <input type="text" class="form-control" id="position" name="position" placeholder="Enter position" required>
      </div>
      <div class="mb-3">
        <label for="salary" class="form-label">Edit Salary</label>
        <input type="number" class="form-control" id="salary" name="salary" placeholder="Enter salary" step="0.01" required>
      </div>
      <div class="mb-3">
        <label for="department_id" class="form-label">Edit Department (Enter department id)</label>
        <select class="form-select" id="department_id" name="department_id" required>
          <option value="">Select Department</option>
          <!-- Dynamically populated options -->
          <option value="1">1 (IT)</option>
          <option value="2">2 (HR)</option>
          <option value="3">3 (Finance)</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="hire_date" class="form-label">Edit Hire Date</label>
        <input type="date" class="form-control" id="hire_date" name="hire_date" required>
      </div>
      <div class="d-grid">
        <button type="submit" class="btn btn-primary">Update Employee</button>
      </div>
    </form>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>