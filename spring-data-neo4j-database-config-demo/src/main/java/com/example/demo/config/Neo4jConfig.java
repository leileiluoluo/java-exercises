package com.example.demo.config;

import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "com.example.demo.repository")
public class Neo4jConfig {

    @Value("${spring.data.neo4j.database}")
    private String database;

    @Bean
    public DatabaseSelectionProvider databaseSelectionProvider() {
        return () -> DatabaseSelection.byName(database);
    }

    @Bean
    public Neo4jClient neo4jClient(Driver driver, DatabaseSelectionProvider provider) {
        return Neo4jClient.with(driver)
                .withDatabaseSelectionProvider(provider)
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(Driver driver, DatabaseSelectionProvider provider) {
        return Neo4jTransactionManager.with(driver)
                .withDatabaseSelectionProvider(provider)
                .build();
    }

}
