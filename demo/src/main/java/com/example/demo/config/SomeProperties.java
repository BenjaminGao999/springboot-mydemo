package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author benjamin
 * created at 2019/11/19
 */
@Component
@ConfigurationProperties(prefix = "some-config")
@EnableConfigurationProperties
@Data
public class SomeProperties {
    private String p1;
    private String p2;


}
