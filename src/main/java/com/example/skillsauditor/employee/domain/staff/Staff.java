package com.example.skillsauditor.employee.domain.staff;

import com.example.skillsauditor.employee.domain.common.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Staff extends Employee { // Aggregate
    private List<StaffSkill> skills;

    public Staff(Identity id, FullName fullName, Address address, Role role, SecurityCredentials securityCredentials) {
        super(id, fullName, address, role, securityCredentials);
        this.skills = new ArrayList<>();
    }

    public List<StaffSkill> retrieveAllSkills() {
        return skills;
    }

    public StaffSkill addSkill() { // do nothing
        return null;
    }

    public List<StaffSkill> removeASkill() { // do nothing
        return null;
    }

    public StaffSkill updateASkill() { // do nothing
        return null;
    }
}
