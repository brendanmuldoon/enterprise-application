package com.example.skillsauditor.skill.application.skill.events;

import com.example.skillsauditor.skill.domain.skill.Skill;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class EditSkillDomainEvent extends ApplicationEvent {

    private String aggregateID;
    private String description;

    public EditSkillDomainEvent(Object source, String aggregateID, String description) {
        super(source);
        this.aggregateID=aggregateID;
        this.description=description;
    }
}
