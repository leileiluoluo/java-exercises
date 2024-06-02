package com.example.tests.conf;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApplicationConf {

    @Value("${github.repo}")
    private String githubRepo;
    @Value("${github.username}")
    private String githubUsername;
    @Value("${github.password}")
    private String githubPassword;
    @Value("${github.totp-secret}")
    private String githubTotpSecret;

}
