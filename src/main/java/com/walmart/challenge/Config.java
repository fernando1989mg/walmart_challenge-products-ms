package com.walmart.challenge;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan({"com.walmart.challenge"})
@EnableMongoRepositories(basePackages = "com.walmart.challenge.repositories")
public class Config {
}
