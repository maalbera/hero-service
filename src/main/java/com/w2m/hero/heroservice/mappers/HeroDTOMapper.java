package com.w2m.hero.heroservice.mappers;

import com.w2m.hero.heroservice.dto.HeroDTO;
import com.w2m.hero.heroservice.entities.Hero;

import java.util.function.Function;
import java.util.stream.Collectors;

public class HeroDTOMapper implements Function<Hero, HeroDTO> {


    @Override
    public HeroDTO apply(Hero hero) {
        HeroDTO heroDTO = null;
        if (hero != null) {
            heroDTO = new HeroDTO();
            heroDTO.setId(hero.getId());
            heroDTO.setHeroName(hero.getHeroName());
            heroDTO.setHiddenName(hero.getHiddenName());
            heroDTO.setHiddenLastName(hero.getHiddenLastName());
            heroDTO.setSkills(hero.getSkills() != null ? hero.getSkills().stream().map(new SkillDTOMapper()).collect(Collectors.toList()) : null);
        }
        return heroDTO;
    }
}
