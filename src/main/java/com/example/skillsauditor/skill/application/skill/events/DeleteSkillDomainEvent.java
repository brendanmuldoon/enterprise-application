package com.example.skillsauditor.skill.application.skill.events;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class DeleteSkillDomainEvent extends ApplicationEvent {

    private String aggregateID;
    public DeleteSkillDomainEvent(Object source, String aggregateID) {
        super(source);
        this.aggregateID=aggregateID;
    }
}
