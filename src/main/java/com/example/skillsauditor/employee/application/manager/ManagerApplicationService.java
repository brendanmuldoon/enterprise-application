package com.example.skillsauditor.employee.application.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerJpaToManagerMapper;
import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import com.example.skillsauditor.employee.application.manager.interfaces.IManagerToManagerJpaMapper;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import com.example.skillsauditor.employee.domain.manager.Manager;
import com.example.skillsauditor.employee.domain.manager.ManagerTeam;
import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerTeamJpaValueObject;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.employee.ui.manager.IManagerApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ManagerApplicationService implements IManagerApplicationService {

    private IManagerRepository managerRepository;

    private IStaffRepository staffRepository;

    private IManagerJpaToManagerMapper managerJpaToManagerMapper;

    private IManagerToManagerJpaMapper managerToManagerJpaMapper;

    @Override
    public void addStaffToManagerTeam(IUpdateManagerTeamCommand updateManagerTeamCommand) {
        Optional<ManagerJpa> managerJpa = managerRepository.findById(updateManagerTeamCommand.getManagerId());
        Optional<StaffJpa> staffJpa = staffRepository.findById(updateManagerTeamCommand.getStaffId());
        if(managerJpa.isPresent() && staffJpa.isPresent()) {

            Manager manager = managerJpaToManagerMapper.map(managerJpa.get()); //db manager converted to pojo

            ManagerTeam teamMember = ManagerTeam.managerTeamOf(updateManagerTeamCommand.getStaffId(),
                    updateManagerTeamCommand.getManagerId()); // create a MangerTeam object

            manager.addTeamMember(teamMember); // and add to manager pojo

            ManagerJpa managerJpa1 = managerToManagerJpaMapper.map(manager);

            ManagerTeamJpaValueObject newTeamMember = new ManagerTeamJpaValueObject(teamMember.getId(), staffJpa.get(), managerJpa1.getId());

            managerJpa1.addTeamMember(newTeamMember);

            managerRepository.save(managerJpa1);

        }else {
            throw new IllegalArgumentException("Manager id is not recognised");

        }
    }
}
