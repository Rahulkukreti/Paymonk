package com.paymonk;

import com.paymonk.config.PersistenceUnit;
import org.hibernate.SessionFactory;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.io.IOException;

@SpringBootApplication
public class Application {

    @Bean
    public SessionFactory getSessionFactory() throws IOException {
        return new PersistenceUnit().getSessionFactory();
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
