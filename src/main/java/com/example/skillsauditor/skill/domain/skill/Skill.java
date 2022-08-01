package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.employee.domain.common.Entity;
import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.application.skill.events.DeleteSkillDomainEvent;
import com.example.skillsauditor.skill.application.skill.events.EditSkillDomainEvent;
import com.example.skillsauditor.skill.application.skill.events.NewSkillAddedDomainEvent;
import lombok.ToString;

@ToString
public class Skill extends Entity { // Aggregate

    private String description;
    private String category;

    public Skill(Identity id, String description, String category) {
        super(id);
        setDescription(description);
        this.category = category;
        this.addDomainEvent(new NewSkillAddedDomainEvent(this, id.id(), description, category));
    }

    public static Skill skillOf(Identity newId, String description, String category) {
        return new Skill(newId, description, category);
    }

    public Skill(Identity id, String description) {
        super(id);
        setDescription(description);
        this.addDomainEvent(new EditSkillDomainEvent(this, id.id(),description));
    }

    public static Skill updateOf(Identity id, String description) {
        return new Skill(id, description);
    }

    public Skill(Identity id) {
        super(id);
        this.addDomainEvent(new DeleteSkillDomainEvent(this, id.id()));
    }


    public static Skill deleteOf(Identity identity) {
        return new Skill(identity);
    }


    private void setDescription(String description) {
        assertArgumentNotEmpty(description, "Skill description must not be empty");
        this.description=description;
    }

    public Identity id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public String category() {
        return this.category;
    }

    public void update(String description) {
        this.description = description;
    }
}
