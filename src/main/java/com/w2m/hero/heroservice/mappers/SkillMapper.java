package com.w2m.hero.heroservice.mappers;


import com.w2m.hero.heroservice.dto.SkillDTO;
import com.w2m.hero.heroservice.entities.Hero;
import com.w2m.hero.heroservice.entities.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Function;

@AllArgsConstructor
@Data
public class SkillMapper implements Function<SkillDTO, Skill> {

    private Hero hero;

    @Override
    public Skill apply(SkillDTO skillDTO) {
        Skill skill = null;
        if (skillDTO != null) {
            skill = new Skill();
            skill.setId(skillDTO.getId());
            skill.setDescription(skillDTO.getDescription());
            skill.setName(skillDTO.getName());
            skill.setHero(hero);
        }
        return skill;
    }


}
