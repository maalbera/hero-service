package com.w2m.hero.heroservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hero_name")
    private String heroName;

    @Column(name = "hidden_name")
    private String hiddenName;

    @Column(name = "hero_last_name")
    private String hiddenLastName;

    @OneToMany(mappedBy = "hero", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("skills")
    private List<Skill> skills;

}
