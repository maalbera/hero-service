package com.w2m.hero.heroservice.dto;

import com.w2m.hero.heroservice.entities.Skill;
import lombok.Data;

import java.util.List;


@Data
public class HeroDTO {

    private Long id;
    private String heroName;
    private String hiddenName;
    private String hiddenLastName;
    private List<SkillDTO> skills;
}
