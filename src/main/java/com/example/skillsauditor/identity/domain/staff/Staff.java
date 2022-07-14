package com.example.skillsauditor.identity.domain.staff;

import com.example.skillsauditor.common.Entity;
import com.example.skillsauditor.common.Identity;
import com.example.skillsauditor.identity.domain.common.Address;
import com.example.skillsauditor.identity.domain.common.FullName;
import com.example.skillsauditor.identity.domain.common.Role;
import com.example.skillsauditor.identity.domain.common.SecurityCredentials;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Staff extends Entity { // Aggregate

    private FullName fullName;

    private Address address;

    private List<StaffSkill> skills;

    private Role role;

    private SecurityCredentials securityCredentials;

    protected Staff(Identity id, FullName fullName, Address address, Role role, SecurityCredentials securityCredentials) {
        super(id);
        this.fullName = fullName;
        this.address = address;
        this.role = role;
        this.securityCredentials = securityCredentials;
        this.skills = new ArrayList<>();
    }

    public FullName fullName() {
        return fullName;
    }

    public Address address() {
        return address;
    }

    public Role role() {
        return role;
    }

    public SecurityCredentials securityCredentials() {
        return securityCredentials;
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
