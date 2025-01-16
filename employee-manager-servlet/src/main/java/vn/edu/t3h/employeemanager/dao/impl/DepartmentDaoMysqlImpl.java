package vn.edu.t3h.employeemanager.dao.impl;

import vn.edu.t3h.employeemanager.dao.DepartmentDao;
import vn.edu.t3h.employeemanager.model.Department;
import vn.edu.t3h.employeemanager.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoMysqlImpl implements DepartmentDao {
    @Override
    public List<Department> getAllDepartment() {
        Connection connection = getConnection();
        List<Department> departmentsResult = new ArrayList<>();
        String sql = "select * from departments dept " +
                "inner join employees emp on dept.department_id = emp.department_id;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Department department = new Department();
                department.setDepartmentID(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setLocation(resultSet.getString("location"));

                departmentsResult.add(department);
            }
            System.out.println("get department success");
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
        return departmentsResult;
    }

    @Override
    public Department getDepartmentByName(String name) {
        Connection connection = getConnection();
        String sql = "select * from departments where department_name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Department department = new Department();
                department.setDepartmentID(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setLocation(rs.getString("location"));

                return department;

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
