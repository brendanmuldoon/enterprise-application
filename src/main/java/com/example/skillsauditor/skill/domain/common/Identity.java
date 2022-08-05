package com.example.skillsauditor.skill.domain.common;

import com.example.skillsauditor.employee.domain.common.ValueObject;
import lombok.ToString;

@ToString
public class Identity extends ValueObject {
    protected String id;

    public Identity(String id){
       setID(id);
    }

    private void setID(String id){
        this.assertArgumentNotEmpty(id,"id cannot be empty");
        this.id = id;
    }

    public String id(){
        return id;
    }
}
