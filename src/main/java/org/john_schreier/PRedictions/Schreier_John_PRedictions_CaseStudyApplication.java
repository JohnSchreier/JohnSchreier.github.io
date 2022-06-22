package org.john_schreier.PRedictions;

import org.john_schreier.PRedictions.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Schreier_John_PRedictions_CaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Schreier_John_PRedictions_CaseStudyApplication.class, args);
    }

}
