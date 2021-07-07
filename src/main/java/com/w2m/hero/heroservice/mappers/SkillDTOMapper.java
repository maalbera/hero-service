package com.w2m.hero.heroservice.mappers;

import com.w2m.hero.heroservice.dto.SkillDTO;
import com.w2m.hero.heroservice.entities.Skill;
import lombok.Data;

import java.util.function.Function;

public class SkillDTOMapper implements Function<Skill, SkillDTO> {

    @Override
    public SkillDTO apply(Skill skill) {
        SkillDTO skillDTO = null;
        if (skill != null) {
            skillDTO = new SkillDTO();
            skillDTO.setId(skill.getId());
            skillDTO.setDescription(skill.getDescription());
            skillDTO.setName(skill.getName());
        }
        return skillDTO;
    }
}
