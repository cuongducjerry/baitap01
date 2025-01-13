package vn.edu.t3h.employeemanager.dao;

import vn.edu.t3h.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployee();

    List<Employee> searchEmployees(String name, double salary, String fromDate, String toDate, String position);

    Employee getEmployeeById(int id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

}