package com.example.skillsauditor.employee.domain.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerJpaToManagerMapper;
import com.example.skillsauditor.employee.domain.common.*;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import org.springframework.stereotype.Component;

@Component
public class ManagerJpaToManagerMapper implements IManagerJpaToManagerMapper  {
    @Override
    public Manager map(ManagerJpa managerJpa) {
        Identity identity = new Identity(managerJpa.getId());
        FullName fullName = new FullName(managerJpa.getFullname_firstname(), managerJpa.getFullname_surname());
        Address address = new Address(managerJpa.getAddress_housenumber(), managerJpa.getAddress_streetname(), managerJpa.getAddress_postcode());
        Role role = Role.valueOf(managerJpa.getRole().toUpperCase());
        SecurityCredentials securityCredentials = new SecurityCredentials(managerJpa.getSecuritycredentials_username(), managerJpa.getSecuritycedentials_password());

        Manager manager = Manager.managerOf(identity, fullName, address, role, securityCredentials);

        for (ManagerTeam mt : manager.team()) {

            ManagerTeam managerTeam = ManagerTeam.managerTeamOf(mt.staffId(), mt.managerId());
            manager.addTeamMember(managerTeam);

        }

        return manager;
    }
}
