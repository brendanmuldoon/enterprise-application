package com.example.skillsauditor.employee.application.manager;

import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import com.example.skillsauditor.employee.application.manager.mappers.ManagerJpaToDTOMapper;
import com.example.skillsauditor.employee.domain.manager.DTO.ManagerDTO;
import com.example.skillsauditor.employee.domain.manager.DTO.ManagerTeamDTO;
import com.example.skillsauditor.employee.domain.manager.interfaces.IGetTeamBySkillIdQuery;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.ui.manager.IManagerQueryHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ManagerQueryHandler implements IManagerQueryHandler {

    private IManagerRepository managerRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher eventPublisher;

    private void manageDomainEvents(List<ApplicationEvent> events) {
        for (ApplicationEvent event : events){
            LOG.info("event " + event);
            eventPublisher.publishEvent(event);
            //eventStoreService.append(events);
        }
    }

    @Override
    public Iterable<ManagerJpa> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<ManagerDTO> findByManagerId(String managerId) {
        Optional<ManagerJpa> response = managerRepository.findById(managerId);
        if(response.isPresent()) {
            return ManagerJpaToDTOMapper.convertManagerDetailsToDTO(response.get());
        }
        return Optional.empty();
    }

    @Override
    public List<ManagerTeamDTO> findTeamByManagerId(String managerId) {
        Optional<ManagerJpa> response = managerRepository.findById(managerId);
        if(response.isPresent()) {
            return ManagerJpaToDTOMapper.convertManagerTeamToDTO(response.get());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ManagerTeamDTO> findTeamBySkillId(IGetTeamBySkillIdQuery getTeamBySkillIdQuery) {
        Optional<ManagerJpa> response = managerRepository.findById(getTeamBySkillIdQuery.getManagerId());
        if(response.isPresent()) {
            List<ManagerTeamDTO> membersWithSkill = new ArrayList<>();
            List<ManagerTeamDTO> team = ManagerJpaToDTOMapper.convertManagerTeamToDTO(response.get());
            team.forEach(t -> t.getSkills().forEach(s -> {
                if(s.getSkillId().equals(getTeamBySkillIdQuery.getSkillId())) {
                    membersWithSkill.add(t);
                }
            } ));

            return membersWithSkill;
        }
        return new ArrayList<>();
    }





    // a method that is subscribed to the skill context and adds data to a var somewhere in here
}
