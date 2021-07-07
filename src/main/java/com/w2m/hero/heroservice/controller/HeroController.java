package com.w2m.hero.heroservice.controller;

import com.w2m.hero.heroservice.dto.HeroDTO;
import com.w2m.hero.heroservice.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hero-service")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @PostMapping("/hero")
    public HeroDTO create(@RequestBody HeroDTO request) {
        return heroService.create(request);
    }

    @GetMapping("/hero/{id}")
    public HeroDTO retrieve(@PathVariable Long id) {
        return heroService.retrieveHeroById(id);
    }

    @GetMapping("/hero/name/{heroName}")
    public List<HeroDTO> retrieve(@PathVariable String heroName) {
        return heroService.retrieveHeroByName(heroName);
    }

    @PutMapping("/hero/{id}")
    public HeroDTO update(@PathVariable Long id, @RequestBody HeroDTO request) {
        return heroService.update(id, request);
    }

    @DeleteMapping("/hero/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        heroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
