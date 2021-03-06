package com.e.labor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan(basePackages = "com.e.labor")
@EnableMongoRepositories("com.e.labor")
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class BasicApplication {

    private final static Logger LOG = LoggerFactory.getLogger(BasicApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    

}
