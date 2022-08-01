package com.example.skillsauditor.skill.application.category;

import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryRepository;
import com.example.skillsauditor.skill.application.category.interfaces.ICategoryToCategoryJpaMapper;
import com.example.skillsauditor.skill.application.skill.events.NewCategoryAddedDomainEvent;
import com.example.skillsauditor.skill.domain.skill.Category;
import com.example.skillsauditor.skill.infrastructure.skill.CategoryJpaValueObject;
import com.example.skillsauditor.skill.ui.skill.ICategoryApplicationService;
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
public class CategoryApplicationService implements ICategoryApplicationService {

    private ICategoryRepository categoryRepository;

    private ICategoryToCategoryJpaMapper categoryToCategoryJpaMapper;

    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)//default phase
    @Transactional(propagation = Propagation.REQUIRES_NEW)//creates new transaction
    public void handleCreateNewCategorySkill(NewCategoryAddedDomainEvent event) {
        Optional<CategoryJpaValueObject> categoryJpa = categoryRepository.findByDescription(event.getDescription());

        if (categoryJpa.isPresent()) {

            LOG.info("Category already exists");

        }

        else {

            Identity identity = new Identity(event.getId());

            Category category = Category.categoryOf(identity, event.getDescription());
            categoryRepository.save(categoryToCategoryJpaMapper.map(category));
            LOG.info("New Category added");

        }

    }
}
