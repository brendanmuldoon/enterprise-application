package com.example.skillsauditor.skill.domain.skill.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CategoryDTO {

    private String id;
    private String description;

    public CategoryDTO(){}

    public CategoryDTO(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
