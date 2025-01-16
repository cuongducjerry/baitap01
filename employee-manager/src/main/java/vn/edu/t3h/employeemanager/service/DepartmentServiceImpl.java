package vn.edu.t3h.employeemanager.service;

import vn.edu.t3h.employeemanager.dao.DepartmentDao;
import vn.edu.t3h.employeemanager.model.Department;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentDao.getDepartmentByName(name);
    }
}
