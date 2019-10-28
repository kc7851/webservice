package com.skc.webservice;

import io.micrometer.core.instrument.util.JsonUtils;
import org.apache.coyote.AbstractProcessorLight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.File;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

    public static String APPLICATION_LOCATION = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/springboot-webservice/real-application.yml";

    public static void main(String[] args) {
        if (System.getProperty("os.name").contains("Windows")) {
            APPLICATION_LOCATION = "spring.config.location="
                    + "classpath:application.yml,"
                    + System.getProperty("user.home") + File.separator + "real-application.yml";
        }
        new SpringApplicationBuilder(Application.class)
                .properties(APPLICATION_LOCATION)
                .run(args);
    }

}
