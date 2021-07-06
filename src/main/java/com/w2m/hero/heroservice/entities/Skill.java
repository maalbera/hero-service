package com.w2m.hero.heroservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heroId")
    @JsonBackReference("skills")
    private Hero hero;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
