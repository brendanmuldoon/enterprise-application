package com.example.skillsauditor.employee.domain.manager;

import com.example.skillsauditor.employee.domain.common.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Manager extends Employee { // Aggregate

    private List<String> team;

    public Manager(Identity id, FullName fullName, Address address, Role role, SecurityCredentials securityCredentials) {
        super(id, fullName, address, role, securityCredentials);
        this.team = new ArrayList<>();
    }

    public List<String> team() {
        return team;
    }

    // add to team

    // remove team member

    // get single team member
}
