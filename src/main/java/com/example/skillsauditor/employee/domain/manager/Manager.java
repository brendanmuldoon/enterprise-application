package com.example.skillsauditor.employee.domain.manager;

import com.example.skillsauditor.employee.domain.common.*;
import com.example.skillsauditor.employee.domain.staff.Staff;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Manager extends Employee { // Aggregate

    private List<ManagerTeam> team;

    public Manager(Identity id, FullName fullName, Address address, Role role, SecurityCredentials securityCredentials) {
        super(id, fullName, address, role, securityCredentials);
        this.team = new ArrayList<>();
    }

    public static Manager managerOf(Identity identity, FullName fullName, Address address, Role role, SecurityCredentials securityCredentials) {
        return new Manager(identity, fullName, address, role, securityCredentials);

    }

    public List<ManagerTeam> team() {
        return team;
    }

    public void addTeamMember(ManagerTeam teamMember) {
        if(!team.contains(teamMember)) {
            this.team.add(teamMember);
        }
    }

    // add to team

    // remove team member

    // get single team member
}
