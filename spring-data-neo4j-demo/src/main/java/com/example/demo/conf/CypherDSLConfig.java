package com.example.demo.conf;

import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class CypherDSLConfig {

    @Bean
    public Configuration cypherDSLConfiguration() {
        return Configuration.newConfig()
                .withDialect(Dialect.NEO4J_5).build();
    }

}
