package com.example.skillsauditor.skill.application.skill;

import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.application.category.events.SkillCreateCategoryEvent;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryRepository;
import com.example.skillsauditor.skill.application.skill.events.*;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillJpaToSkillMapper;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillToSkillJpaMapper;
import com.example.skillsauditor.skill.domain.skill.Category;
import com.example.skillsauditor.skill.domain.skill.Skill;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;
import com.example.skillsauditor.skill.ui.skill.ISkillApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@EnableJms
public class SkillApplicationService implements ISkillApplicationService {

    private ISkillRepository skillRepository;
    private ICategoryRepository categoryRepository;
    private ISkillToSkillJpaMapper skillToSkillJpaMapper;
    private ISkillJpaToSkillMapper skillJpaToSkillMapper;

    private ApplicationEventPublisher eventPublisher;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private JmsTemplate jmsTemplate;

    private ObjectMapper objectMapper;

    private void manageDomainEvents(List<ApplicationEvent> events) {
        for (ApplicationEvent event : events){
            LOG.info("event " + event);
            eventPublisher.publishEvent(event);
            //eventStoreService.append(events);
        }
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)//default phase
    @Transactional(propagation = Propagation.REQUIRES_NEW)//creates new transaction
    public void handleCreateNewSkill(NewSkillAddedDomainEvent event) {
        Optional<SkillJpa> skillJpa = skillRepository.findByDescription(event.getDescription());
        Optional<CategoryJpaValueObject> category = categoryRepository.findById(event.getCategoryId());
        Skill skill;
        if (skillJpa.isPresent()) {

            LOG.info("Skill already exists");
            skill = skillJpaToSkillMapper.map(skillJpa.get());
        }

        else {

            Identity identity = new Identity(event.getAggregateID());

            skill = Skill.skillOf(identity, event.getDescription(), event.getCategoryId());
            skillRepository.save(skillToSkillJpaMapper.map(skill, category.get()));
            LOG.info("New skill added");

        }

        if (category.isPresent()) {
            skillRepository.save(skillToSkillJpaMapper.map(skill, category.get()));
        }


    }

    @JmsListener(destination = "SKILL.CREATE.QUEUE")
    public void createNewSkillListener(Message message) {

        LOG.info("Received message from SKILL.CREATE.QUEUE");

        try {

            if (message instanceof TextMessage) {

                String messageBody = ((TextMessage) message).getText();

                SkillCreateSkillEvent event = objectMapper.readValue(messageBody, SkillCreateSkillEvent.class);

                Optional<SkillJpa> skillJpa = skillRepository.findByDescription(event.getDescription());

                if (skillJpa.isPresent()) {

                    LOG.info("Skill already exists");

                }

                else {

                    Optional<CategoryJpaValueObject> category = categoryRepository.findById(event.getCategory());

                    if ( category.isPresent()) {
                        Identity identity = new Identity(event.getId());

                        Skill skill = Skill.skillOf(identity, event.getDescription(), event.getId());
                        skillRepository.save(skillToSkillJpaMapper.map(skill, category.get()));
                        LOG.info("New Skill successfully added");

                    } else {

                        LOG.error("Invalid category");

                    }




                }

            }

        } catch (Exception e) {

            LOG.error(e.getMessage());

        }

    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)//default phase
    @Transactional(propagation = Propagation.REQUIRES_NEW)//creates new transaction
    public void handleEditSkill(EditSkillDomainEvent event) {

        Optional<SkillJpa> skillJpa = skillRepository.findById(event.getAggregateID());

        Skill skill;

        if(skillJpa.isEmpty()) {

            LOG.info("Skill does not exist");

        }

        else {

            skill = skillJpaToSkillMapper.map(skillJpa.get());

            skill.update(event.getDescription());

            Optional<CategoryJpaValueObject> category = categoryRepository.findById(skill.category());

            skillRepository.save(skillToSkillJpaMapper.map(skill, category.get()));

            LOG.info("Skill updated");

        }

    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)//default phase
    @Transactional(propagation = Propagation.REQUIRES_NEW)//creates new transaction
    public void handleDeleteSkill(DeleteSkillDomainEvent event) {
        Optional<SkillJpa> skillJpa = skillRepository.findById(event.getAggregateID());

        if(skillJpa.isEmpty()) {

            LOG.info("Skill does not exist");

        }

        else {

            skillRepository.delete(skillJpa.get());

            LOG.info("Skill deleted");

        }

    }

    @JmsListener(destination = "CATEGORY.DELETE.QUEUE")
    public void handleDeleteCategoryEvent(Message message) {

        LOG.info("Received message from CATEGORY.DELETE.QUEUE");

        try {

            if (message instanceof TextMessage) {

                String messageBody = ((TextMessage) message).getText();

                SkillCategoryDeleteEvent event = objectMapper.readValue(messageBody, SkillCategoryDeleteEvent.class);

                if(!skillRepository.findByCategoryId(event.getId()).isEmpty()) {

                    LOG.info("Cannot delete, Category is in use");

                } else {

                    Identity identity = new Identity(event.getId());

                    Category category = Category.delete(identity);

                    manageDomainEvents(category.getListOfEvents());

                }

            }

        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }

    }




}
