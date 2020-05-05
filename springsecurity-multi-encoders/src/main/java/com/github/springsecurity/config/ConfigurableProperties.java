package com.github.springsecurity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
public class ConfigurableProperties {

    private String encodingScheme = "bcrypt";

    public String getEncodingScheme() {
        return encodingScheme;
    }

    public void setEncodingScheme(String encodingScheme) {
        this.encodingScheme = encodingScheme;
    }
}
