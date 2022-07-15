package com.example.skillsauditor.employee.domain.common;

import lombok.ToString;
@ToString
public class Employee extends Entity {

    private FullName fullName;

    private Address address;

    private Role role;

    private SecurityCredentials securityCredentials;

    public Employee(Identity id, FullName fullName, Address address, Role role, SecurityCredentials securityCredentials) {
        super(id);
        this.fullName = fullName;
        this.address = address;
        this.role = role;
        this.securityCredentials = securityCredentials;
    }

    public FullName fullName() {
        return fullName;
    }

    public void updateFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Address address() {
        return address;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }

    public Role role() {
        return role;
    }

    public SecurityCredentials securityCredentials() {
        return securityCredentials;
    }

    public void updateSecurityCredentials(SecurityCredentials securityCredentials) {
        this.securityCredentials = securityCredentials;
    }


}
