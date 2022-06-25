package com.example.gdg_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GdgProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdgProjectApplication.class, args);
    }

}
