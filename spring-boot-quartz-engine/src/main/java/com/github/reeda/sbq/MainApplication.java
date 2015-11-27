package com.github.reeda.sbq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by andrew on 11/27/15.
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(MainApplication.class)
                .headless(true)
                .run(args);
    }
}
