package com.example.skillsauditor.skill.application.category;

import com.example.skillsauditor.skill.application.skill.events.SkillCategoryDeleteEvent;
import com.example.skillsauditor.skill.domain.common.Identity;
import com.example.skillsauditor.skill.application.category.events.SkillCreateCategoryEvent;
import com.example.skillsauditor.skill.application.category.events.SkillEditCategoryEvent;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryRepository;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryToCategoryJpaMapper;
import com.example.skillsauditor.skill.application.skill.events.DeleteCategoryDomainEvent;
import com.example.skillsauditor.skill.domain.skill.Category;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import com.example.skillsauditor.skill.ui.skill.ICategoryApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Optional;

@AllArgsConstructor
@Service
@EnableJms
public class CategoryApplicationService implements ICategoryApplicationService {

    private ICategoryRepository categoryRepository;

    private ICategoryToCategoryJpaMapper categoryToCategoryJpaMapper;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper;


    @JmsListener(destination = "CATEGORY.CREATE.QUEUE")
    public void createNewCategoryListener(Message message) {

        LOG.info("Received message from CATEGORY.CREATE.QUEUE");

        try {

            if (message instanceof TextMessage) {

                String messageBody = ((TextMessage) message).getText();

                SkillCreateCategoryEvent event = objectMapper.readValue(messageBody, SkillCreateCategoryEvent.class);

                Optional<CategoryJpaValueObject> categoryJpa = categoryRepository.findByDescription(event.getDescription());

                if (categoryJpa.isPresent()) {

                    LOG.info("Category already exists");

                }

                else {

                    Identity identity = new Identity(event.getId());

                    Category category = Category.categoryOf(identity, event.getDescription());
                    categoryRepository.save(categoryToCategoryJpaMapper.map(category));
                    LOG.info("New Category successfully added");

                }

            }

        } catch (Exception e) {

            LOG.error(e.getMessage());

        }

    }

    @JmsListener(destination = "CATEGORY.EDIT.QUEUE")
    public void editCategoryListener(Message message) {

        LOG.info("Received message from CATEGORY.EDIT.QUEUE");

        try {

            if (message instanceof TextMessage) {

                String messageBody = ((TextMessage) message).getText();

                SkillEditCategoryEvent event = objectMapper.readValue(messageBody, SkillEditCategoryEvent.class);

                Optional<CategoryJpaValueObject> categoryJpa = categoryRepository.findById(event.getId());

                if (categoryJpa.isEmpty()) {

                    LOG.info("Category does not exist");

                }

                else {

                    Identity identity = new Identity(event.getId());

                    Category category = Category.categoryOf(identity, event.getDescription());
                    categoryRepository.save(categoryToCategoryJpaMapper.map(category));
                    LOG.info("Category successfully updated");

                }

            }

        } catch (Exception e) {

            LOG.error(e.getMessage());

        }
        
    }

    @JmsListener(destination = "CATEGORY.DELETE.QUEUE")
    public void handleDeleteCategory(Message message) {

        try {

            if (message instanceof TextMessage) {

                String messageBody = ((TextMessage) message).getText();

                SkillCategoryDeleteEvent event = objectMapper.readValue(messageBody, SkillCategoryDeleteEvent.class);

                Optional<CategoryJpaValueObject> categoryJpa = categoryRepository.findById(event.getId());

                if (categoryJpa.isPresent()) {

                    categoryRepository.delete(categoryJpa.get());

                    LOG.info("Category successfully deleted");

                }

                else {

                    LOG.info("Category doesn't exist");

                }
            }

        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }

    }

}
