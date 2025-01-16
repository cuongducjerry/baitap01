package vn.edu.t3h.employeemanager.model;

public class Department {
    private Integer departmentID;
    private String departmentName;
    private String location;

    public Department(){}

    public Department(Integer departmentID, String departmentName, String location) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;

    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
