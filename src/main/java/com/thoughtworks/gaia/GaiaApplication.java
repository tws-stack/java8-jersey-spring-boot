package com.thoughtworks.gaia;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GaiaApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(GaiaApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
    }
}
