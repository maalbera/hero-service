package com.w2m.hero.heroservice.repository;

import com.w2m.hero.heroservice.entities.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends CrudRepository<Hero,Long> {

    List<Hero> findByHeroNameIgnoreCaseContaining(String heroName);

}
