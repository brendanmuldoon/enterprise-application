package com.example.skillsauditor.employee.application.manager;

import com.example.skillsauditor.employee.application.manager.commands.*;
import com.example.skillsauditor.employee.application.manager.events.EmployeeCreateCategoryEvent;
import com.example.skillsauditor.employee.application.manager.events.EmployeeEditCategoryEvent;
import com.example.skillsauditor.employee.application.manager.interfaces.IManagerJpaToManagerMapper;
import com.example.skillsauditor.employee.application.manager.interfaces.IManagerRepository;
import com.example.skillsauditor.employee.application.manager.interfaces.IManagerToManagerJpaMapper;
import com.example.skillsauditor.employee.application.staff.interfaces.IStaffRepository;
import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.employee.domain.manager.Manager;
import com.example.skillsauditor.employee.domain.manager.ManagerTeam;
import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.employee.infrastructure.manager.ManagerTeamJpaValueObject;
import com.example.skillsauditor.employee.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.employee.ui.manager.IManagerApplicationService;
import com.example.skillsauditor.skill.domain.common.UniqueIDFactory;
import com.example.skillsauditor.skill.domain.skill.Skill;
import com.example.skillsauditor.employee.domain.manager.interfaces.ICreateCategoryCommand;
import com.example.skillsauditor.skill.domain.skill.interfaces.IDeleteCategoryCommand;
import com.example.skillsauditor.employee.domain.manager.interfaces.IEditCategoryCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ManagerApplicationService implements IManagerApplicationService {

    private IManagerRepository managerRepository;

    private IStaffRepository staffRepository;

    private IManagerJpaToManagerMapper managerJpaToManagerMapper;

    private IManagerToManagerJpaMapper managerToManagerJpaMapper;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher eventPublisher;

    private JmsTemplate jmsTemplate;

    private ObjectMapper objectMapper;



    private void manageDomainEvents(List<ApplicationEvent> events) {
        for (ApplicationEvent event : events){
            LOG.info("event " + event);
            eventPublisher.publishEvent(event);
            //eventStoreService.append(events);
        }
    }

    @Override
    public void addStaffToManagerTeam(IUpdateManagerTeamCommand updateManagerTeamCommand) {
        Optional<ManagerJpa> managerJpa = managerRepository.findById(updateManagerTeamCommand.getManagerId());
        Optional<StaffJpa> staffJpa = staffRepository.findById(updateManagerTeamCommand.getStaffId());
        if(managerJpa.isPresent()) {

            if (staffJpa.isPresent()) {

                Manager manager = managerJpaToManagerMapper.map(managerJpa.get());

                ManagerTeam teamMember = ManagerTeam.managerTeamOf(updateManagerTeamCommand.getStaffId(),
                        updateManagerTeamCommand.getManagerId());

                manager.addTeamMember(teamMember);

                ManagerJpa managerJpa1 = managerToManagerJpaMapper.map(manager);

                managerJpa1.setTeam(managerJpa.get().getTeam());

                ManagerTeamJpaValueObject newTeamMember = new ManagerTeamJpaValueObject(teamMember.getId(), staffJpa.get(), managerJpa1.getId());

                managerJpa1.addTeamMember(newTeamMember);

                managerRepository.save(managerJpa1);

            } else {
                throw new IllegalArgumentException("Staff id is not recognised");
            }
        } else {
            throw new IllegalArgumentException("Manager id is not recognised");
        }
    }

    @Override
    public void createSkill(CreateSkillCommand createSkillCommand) {

        Identity identity = UniqueIDFactory.createID();

        Skill skill = Skill.skillOf(identity, createSkillCommand.getDescription(), createSkillCommand.getCategoryId());

        manageDomainEvents(skill.getListOfEvents());

    }

    @Override
    public void editSkill(EditSkillCommand editSkillCommand) {

        Identity identity = new Identity(editSkillCommand.getSkillId());

        Skill skill = Skill.updateOf(identity, editSkillCommand.getDescription());

        manageDomainEvents(skill.getListOfEvents());

    }

    @Override
    public void deleteSkill(DeleteSkillCommand deleteSkillCommand) {

        Iterable<StaffJpa> staffWithSkills = staffRepository.findAll();

        boolean inUse = false;

        if( staffWithSkills != null) {
            for(StaffJpa staff : staffWithSkills) {

                if (staff.retrieveSkill(deleteSkillCommand.getSkillId()) != null) {

                    inUse = true;

                    break;

                }
            }
        }

        if(inUse) {

            LOG.info("Cannot delete, Skill is in use");
        }

        else {

            Identity identity = new Identity(deleteSkillCommand.getSkillId());

            Skill skill = Skill.deleteOf(identity);

            manageDomainEvents(skill.getListOfEvents());

        }

    }

    @Override
    public void createCategory(ICreateCategoryCommand createCategoryCommand) {

        Identity identity = UniqueIDFactory.createID();

        EmployeeCreateCategoryEvent event = new EmployeeCreateCategoryEvent();
        event.setId(identity.id());
        event.setDescription(createCategoryCommand.getDescription());

        try {
            String eventToJson = objectMapper.writeValueAsString(event);

            jmsTemplate.convertAndSend("CATEGORY.CREATE.QUEUE", eventToJson);

        } catch (JsonProcessingException ex) {
            LOG.error(ex.getMessage());
        }

    }

    @Override
    public void editCategory(IEditCategoryCommand editCategoryCommand) {

        EmployeeEditCategoryEvent event = new EmployeeEditCategoryEvent();
        event.setId(editCategoryCommand.getId());
        event.setDescription(editCategoryCommand.getDescription());

        try {
            String eventToJson = objectMapper.writeValueAsString(event);

            jmsTemplate.convertAndSend("CATEGORY.EDIT.QUEUE", eventToJson);

        } catch (JsonProcessingException ex) {
            LOG.error(ex.getMessage());
        }

    }

    @Override
    public void deleteCategory(IDeleteCategoryCommand editCategoryCommand) {

//        Identity identity = new Identity(editCategoryCommand.getId());
//
//        String URL = String.format("http://localhost:8080/skill/findAllSkillsByCategory/%s", editCategoryCommand.getId());
//
//        URI uri = new URI(URL);
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        SkillDTO[] skillsByCategory = restTemplate.getForObject(uri, SkillDTO[].class);
//
//        if(skillsByCategory.length>0) {
//
//            LOG.info("Cannot delete. Category in use by '"+skillsByCategory.length+"' skills");
//
//        } else {
//
//            Category category = Category.DeleteCategoryOf(identity);
//
//            manageDomainEvents(category.getListOfEvents());
//
//        }

        String destination = "";




    }


}
