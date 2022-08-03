package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.application.skill.events.DeleteCategoryDomainEvent;
import com.example.skillsauditor.skill.application.skill.events.EditCategoryDomainEvent;
import com.example.skillsauditor.skill.application.skill.events.NewCategoryAddedDomainEvent;
import com.example.skillsauditor.skill.domain.common.Entity;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class Category extends Entity {

    private String description;

    protected Category(Identity id, String description) {
        super(id);
        setDescription(description);
        this.addDomainEvent(new NewCategoryAddedDomainEvent(this, id.id(), description));
    }



    public static Category categoryOf(Identity id, String description) {
        return new Category(id, description);
    }

    public Category(Identity id, String description, String task) {
        super(id);
        if(task.equalsIgnoreCase("EDIT")) {
            setDescription(description);
            this.addDomainEvent(new EditCategoryDomainEvent(this, id.id(), description));
        } else {
            this.addDomainEvent(new DeleteCategoryDomainEvent(this, id.id()));
        }
    }

    public static Category ModifyCategoryOf(Identity identity, String description) {
        return new Category(identity, description);
    }

    public static Category DeleteCategoryOf(Identity identity) {
        return new Category(identity);
    }

    public Category(Identity id) {
        super(id);
        this.addDomainEvent(new DeleteCategoryDomainEvent(this, id.id()));
    }


    private void setDescription(String description) {
        assertArgumentNotEmpty(description, "Category description must not be null");
        this.description=description;
    }

    public Identity id() {
        return this.id;
    }

    public String description(){
        return this.description;
    }
}
