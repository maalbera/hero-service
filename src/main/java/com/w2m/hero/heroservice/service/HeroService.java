package com.w2m.hero.heroservice.service;

import com.w2m.hero.heroservice.dto.HeroDTO;
import com.w2m.hero.heroservice.dto.SkillDTO;
import com.w2m.hero.heroservice.entities.Hero;
import com.w2m.hero.heroservice.entities.Skill;
import com.w2m.hero.heroservice.mappers.HeroDTOMapper;
import com.w2m.hero.heroservice.mappers.HeroMapper;
import com.w2m.hero.heroservice.mappers.SkillMapper;
import com.w2m.hero.heroservice.repository.HeroRepository;
import com.w2m.hero.heroservice.repository.SkillRepository;
import com.w2m.hero.heroservice.util.TimedOut;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private SkillRepository skillRepository;

    @TimedOut
    public HeroDTO create(HeroDTO heroDTO) {
        return new HeroDTOMapper().apply(heroRepository.save(new HeroMapper().apply(heroDTO)));
    }

    @TimedOut
    public HeroDTO retrieveHeroById(Long id) {
        return new HeroDTOMapper().apply(heroRepository.findById(id).orElse(null));
    }

    @TimedOut
    public List<HeroDTO> retrieveHeroByName(String heroName) {
        List<HeroDTO> heroDTOList = null;
        List<Hero> heroList = heroRepository.findByHeroNameIgnoreCaseContaining(heroName);

        if (heroList != null && !heroList.isEmpty()) {
            heroDTOList = heroList.stream().map(new HeroDTOMapper()).collect(Collectors.toList());
        }
        return heroDTOList;
    }

    @TimedOut
    public HeroDTO update(Long id, HeroDTO heroDTO) {
        HeroDTO heroTemp = null;
        Hero heroFound = heroRepository.findById(id).orElse(null);
        if (heroFound != null) {
            heroFound.setHeroName(heroDTO.getHeroName());
            heroFound.setHiddenName(heroDTO.getHiddenName());
            heroFound.setHiddenLastName(heroDTO.getHiddenLastName());
            List<Skill> skillsUpdated = heroDTO.getSkills().stream().map(new SkillMapper(heroFound)).collect(Collectors.toList());
            heroFound.setSkills(skillsUpdated);
            heroTemp = new HeroDTOMapper().apply(heroRepository.save(heroFound));
        } else {
            log.info("Not Found Hero with Id: " + id);
        }
        return heroTemp;
    }

    @TimedOut
    public void delete(Long id) {
        heroRepository.deleteById(id);
    }


}
