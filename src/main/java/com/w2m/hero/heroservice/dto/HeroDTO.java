package com.w2m.hero.heroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HeroDTO {

    private Long id;
    private String heroName;
    private String hiddenName;
    private String hiddenLastName;
    private List<SkillDTO> skills;
}
