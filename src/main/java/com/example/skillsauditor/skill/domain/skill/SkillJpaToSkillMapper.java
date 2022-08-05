package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.skill.domain.common.Identity;
import com.example.skillsauditor.skill.application.skill.interfaces.ISkillJpaToSkillMapper;
import com.example.skillsauditor.skill.infrastructure.skill.SkillJpa;
import org.springframework.stereotype.Component;

@Component

public class SkillJpaToSkillMapper implements ISkillJpaToSkillMapper {

    @Override
    public Skill map(SkillJpa skillJpa) {

        Identity identity = new Identity(skillJpa.getId());

        return Skill.skillOf(identity,
                skillJpa.getDescription(), skillJpa.getCategory().getId());
    }
}
