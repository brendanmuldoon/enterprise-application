package com.example.skillsauditor.skill.infrastructure.skill;

import com.example.skillsauditor.skill.domain.skill.interfaces.ISkillJpa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "skill")
@Table(name = "skill")
@ToString
@Getter
@Setter
public class SkillJpa implements ISkillJpa {

    @Id
    @Column
    private String id;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "category", referencedColumnName = "id")
    private CategoryJpaValueObject category;

    protected SkillJpa () {}

    public SkillJpa(String id,
                    String description,
                    CategoryJpaValueObject category) {
        this.id = id;
        this.description = description;
        this.category=category;
    }


}
