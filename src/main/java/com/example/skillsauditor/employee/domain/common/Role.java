package com.example.skillsauditor.employee.domain.common;

public class Role extends ValueObject {

    enum eRole {
        MANAGER("Manager"),
        STAFF("Staff");

        eRole(String manager) {
        }
    }
}
