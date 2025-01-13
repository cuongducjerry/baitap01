package vn.edu.t3h.employeemanager.dao;

import vn.edu.t3h.employeemanager.model.Department;
import vn.edu.t3h.employeemanager.model.Employee;

import java.util.List;

public interface DepartmentDao {

    List<Department> getAllDepartment();

    Department getDepartmentByName(String name);

}
