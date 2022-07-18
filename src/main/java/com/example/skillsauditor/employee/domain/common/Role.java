package com.example.skillsauditor.employee.domain.common;

public enum Role {

    MANAGER("Manager"),
    STAFF("Staff");

    private final String employeeRole;

    Role(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }
}
