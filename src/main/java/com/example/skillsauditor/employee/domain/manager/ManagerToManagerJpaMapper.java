package com.example.skillsauditor.employee.domain.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerToManagerJpaMapper;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerTeamJpaValueObject;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerToManagerJpaMapper implements IManagerToManagerJpaMapper {
    @Override
    public ManagerJpa map(Manager manager) {
        ManagerJpa managerJpa = ManagerJpa.managerJpaOf(
                manager.id().id(),
                manager.fullName().firstName(),
                manager.fullName().surname(),
                manager.address().houseNumber(),
                manager.address().streetName(),
                manager.address().postcode(),
                manager.role().getEmployeeRole(),
                manager.securityCredentials().username(),
                manager.securityCredentials().password()
        );


        return managerJpa;
    }
}
