package com.example.skillsauditor.identity.domain.common;

import com.example.skillsauditor.common.ValueObject;

public class Role extends ValueObject {

    enum eRole {
        MANAGER("Manager"),
        STAFF("Staff");

        eRole(String manager) {
        }
    }
}
