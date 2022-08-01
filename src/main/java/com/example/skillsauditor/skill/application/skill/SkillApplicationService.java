package com.example.skillsauditor.skill.application.skill;

import com.example.skillsauditor.employee.application.manager.commands.DeleteSkillCommand;
import com.example.skillsauditor.employee.application.manager.commands.EditSkillCommand;
import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.employee.domain.manager.interfaces.ICreateSkillCommand;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryRepository;
import com.example.skillsauditor.skill.application.skill.events.DeleteSkillDomainEvent;
import com.example.skillsauditor.skill.application.skill.events.EditSkillDomainEvent;
import com.example.skillsauditor.skill.application.skill.events.NewSkillAddedDomainEvent;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillJpaToSkillMapper;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillRepository;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillToSkillJpaMapper;
import com.example.skillsauditor.skill.domain.common.UniqueIDFactory;
import com.example.skillsauditor.skill.domain.skill.Skill;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;
import com.example.skillsauditor.skill.ui.skill.ISkillApplicationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Optional;

@AllArgsConstructor
@Service
public class SkillApplicationService implements ISkillApplicationService {

    private ISkillRepository skillRepository;
    private ICategoryRepository categoryRepository;
    private ISkillToSkillJpaMapper skillToSkillJpaMapper;
    private ISkillJpaToSkillMapper skillJpaToSkillMapper;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

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

//    @Override
//    public void editSkill(EditSkillCommand editSkillCommand) {
//        Optional<SkillJpa> skillJpa = skillRepository.findById(editSkillCommand.getSkillId());
//        Optional<CategoryJpaValueObject> categoryJpaValueObject = categoryRepository.findById(editSkillCommand.getCategoryId());
//        if(skillJpa.isPresent() && categoryJpaValueObject.isPresent()) {
//            Skill skill = skillJpaToSkillMapper.map(skillJpa.get());
//            skill.update(editSkillCommand);
//            skillRepository.save(skillToSkillJpaMapper.map(skill, categoryJpaValueObject.get()));
//        } else {
//            throw new IllegalArgumentException("Category not found");
//        }
//    }

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


    @Override
    public void deleteSkill(DeleteSkillCommand deleteSkillCommand) {
        Optional<SkillJpa> skillJpa = skillRepository.findById(deleteSkillCommand.getSkillId());
        if (skillJpa.isPresent()) {
            skillRepository.delete(skillJpa.get());
        }else {
            throw new IllegalArgumentException("Category not found");
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


}
