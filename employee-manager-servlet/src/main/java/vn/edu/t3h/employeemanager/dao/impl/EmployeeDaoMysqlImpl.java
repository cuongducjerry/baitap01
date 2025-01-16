package vn.edu.t3h.employeemanager.dao.impl;

import vn.edu.t3h.employeemanager.dao.EmployeeDao;
import vn.edu.t3h.employeemanager.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoMysqlImpl implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployee() {

        // tạo connection đến database
        Connection connection = getConnection();
        List<Employee> employeesResult = new ArrayList<>();
        // tạo câu query
        String sql = "select * from employees emp " +
                "inner join departments dept on emp.department_id = dept.department_id;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // thực thi câu query
            ResultSet resultSet = statement.executeQuery();
            // lấy ra dữ liệu từ câu query đưa vào object java
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDepartmentID(resultSet.getInt("department_id"));
                employee.setHireDate(resultSet.getString("hire_date"));

                employeesResult.add(employee);
            }
            System.out.println("get employee success");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // trả về kết quả là danh sach employee
        return employeesResult;
    }

    @Override
    public List<Employee> searchEmployees(String name, double salary, String fromDate, String toDate, String position) {
        Connection connection = getConnection();
        List<Employee> employeesResult = new ArrayList<>();
        try{
            String sql = "SELECT * "
                    + "FROM employees e INNER JOIN departments d ON e.department_id = d.department_id WHERE 1=1";

            // Thêm các điều kiện vào câu lệnh SQL nếu các tham số không null
            if (name != null && !name.isEmpty()) {
                sql += " AND e.name LIKE ?";
            }
            if (salary >= 0) {
                sql += " AND e.salary >= ?";
            }
            if (fromDate != null && !fromDate.isEmpty()) {
                sql += " AND e.hire_date >= ?";
            }
            if (toDate != null && !toDate.isEmpty()) {
                sql += " AND e.hire_date <= ?";
            }
            if (position != null && !position.isEmpty()) {
                sql += " AND e.position LIKE ?";
            }
            sql += ";";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int paramIndex = 1;
            if (name != null && !name.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + name + "%");
            }
            if (salary >= 0) {
                preparedStatement.setDouble(paramIndex++, salary);
            }
            if (fromDate != null && !fromDate.isEmpty()) {
                preparedStatement.setDate(paramIndex++, Date.valueOf(fromDate));
            }
            if (toDate != null && !toDate.isEmpty()) {
                preparedStatement.setDate(paramIndex++, Date.valueOf(toDate));
            }
            if (position != null && !position.isEmpty()) {
                preparedStatement.setString(paramIndex++, "%" + position + "%");
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Search Employee: " + resultSet);
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDepartmentID(resultSet.getInt("department_id"));
                employee.setHireDate(resultSet.getString("hire_date"));

                employeesResult.add(employee);
            }

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return employeesResult;
    }


    @Override
    public Employee getEmployeeById(int id) {
        Connection connection = getConnection();
        String sql = "select * from employees emp " +
                "inner join departments dept on emp.department_id = dept.department_id" +
                " where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Employee employee = new Employee();

                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setPosition(rs.getString("position"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartmentID(rs.getInt("department_id"));
                employee.setHireDate(rs.getString("hire_date"));

                return employee;

            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        Connection connection = getConnection();
        String sql = "insert into employees(employee_id, name, position, salary, department_id, hire_date) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getDepartmentID());
            preparedStatement.setString(6, employee.getHireDate());

            int rs = preparedStatement.executeUpdate();
            System.out.println("Thêm nhân viên mới: " + rs);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection connection = getConnection();
        String sql = "update employees set name = ?, position = ?, salary = ?,department_id = ?, hire_date = ? where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getDepartmentID());
            preparedStatement.setString(5, employee.getHireDate());
            preparedStatement.setInt(6, employee.getEmployeeId());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Connection connection = getConnection();
        String sql = "delete from employees where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println("Xóa nhân viên: " + rs);

        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/quanlynhansu";
        String username = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("get connection success");
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}