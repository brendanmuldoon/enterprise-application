package com.example.skillsauditor.employee.application.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.ui.manager.IManagerApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ManagerApplicationService implements IManagerApplicationService {

    private IManagerRepository managerRepository;

    @Override
    public void addStaffToManagerTeam(IUpdateManagerTeamCommand updateManagerTeamCommand) {
        Optional<ManagerJpa> managerJpa = managerRepository.findById(updateManagerTeamCommand.getManagerId());
        if(managerJpa.isPresent()) {
            
        }

    }
}
