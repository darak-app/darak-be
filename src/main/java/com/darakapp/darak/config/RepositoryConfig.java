package com.darakapp.darak.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.darakapp.darak.repository.jpa")
@EnableMongoRepositories(basePackages = "com.darakapp.darak.repository.mongo")
@EnableRedisRepositories(basePackages = "com.darakapp.darak.repository.redis")
public class RepositoryConfig {
}
