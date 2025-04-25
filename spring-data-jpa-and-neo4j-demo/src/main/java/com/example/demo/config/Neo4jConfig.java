package com.example.demo.config;

import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(
        basePackages = "com.example.demo.repository.graph",
        transactionManagerRef = "neo4jTransactionManager"
)
public class Neo4jConfig {

    @Bean(name = "neo4jTransactionManager")
    public PlatformTransactionManager transactionManager(Driver driver) {
        return Neo4jTransactionManager.with(driver)
                .build();
    }

}
