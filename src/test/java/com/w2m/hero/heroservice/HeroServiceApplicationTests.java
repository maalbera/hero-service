package com.w2m.hero.heroservice;

import static org.hamcrest.Matchers.*;
import com.google.gson.Gson;
import com.w2m.hero.heroservice.dto.HeroDTO;
import com.w2m.hero.heroservice.repository.HeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = HeroServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application.yml")
class HeroServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private HeroRepository heroRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void post_create_superhero()
			throws Exception {

		Gson gson = new Gson();
		String json = gson.toJson(HeroDTO.builder().heroName("Spiderman").hiddenLastName("Parker").hiddenName("Perter").build());

		mvc.perform(post("/hero-service/hero")
				.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("heroName", is("Spiderman")));
	}

}
