package com.w2m.hero.heroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class HeroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroServiceApplication.class, args);
	}

}
