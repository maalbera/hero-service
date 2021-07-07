package com.w2m.hero.heroservice.mappers;

import com.w2m.hero.heroservice.dto.HeroDTO;
import com.w2m.hero.heroservice.entities.Hero;

import java.util.function.Function;

public class HeroMapper implements Function<HeroDTO, Hero> {

    @Override
    public Hero apply(HeroDTO heroDTO) {
        Hero hero = null;
        if (heroDTO != null) {
            hero = new Hero();
            hero.setId(heroDTO.getId());
            hero.setHeroName(heroDTO.getHeroName());
            hero.setHiddenName(heroDTO.getHiddenName());
            hero.setHiddenLastName(heroDTO.getHiddenLastName());
            hero.setSkills(null);
        }
        return hero;
    }

}
