package com.example.skillsauditor.skill.application.skill.events;

import com.example.skillsauditor.skill.domain.skill.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@ToString
public class DeleteCategoryDomainEvent extends ApplicationEvent {

    private String id;
    public DeleteCategoryDomainEvent(Object source, String id) {
        super(source);
        this.id = id;
    }
}
