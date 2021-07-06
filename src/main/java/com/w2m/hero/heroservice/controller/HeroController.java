package com.w2m.hero.heroservice.controller;

import com.w2m.hero.heroservice.dto.HeroDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hero")
public class HeroController {


    @PostMapping("/")
    public HeroDTO create(@RequestBody HeroDTO request){
        return null;
    }

    @GetMapping("/{id}")
    public HeroDTO retrieve(@PathVariable Long id){
        return null;
    }

    @GetMapping("/name/{heroName}")
    public HeroDTO retrieve(@PathVariable String heroName){
        return null;
    }

    @PutMapping("/{id}")
    public HeroDTO update(@PathVariable Long id, @RequestBody HeroDTO request){
        return null;
    }

    @DeleteMapping("/{id}")
    public HeroDTO delete(@PathVariable Long id){
        return null;
    }
}
