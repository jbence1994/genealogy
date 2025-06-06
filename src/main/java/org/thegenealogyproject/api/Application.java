package org.thegenealogyproject.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.thegenealogyproject.api.config.FileExtensionsConfig;

@SpringBootApplication
@EnableConfigurationProperties(value = {FileExtensionsConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
