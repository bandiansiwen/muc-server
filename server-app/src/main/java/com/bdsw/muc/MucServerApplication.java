package com.bdsw.muc;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MucServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MucServerApplication.class, args);
    }

}
