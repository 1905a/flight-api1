package com.fh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.fh.mapper")
public class FlightApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightApiApplication.class, args);
    }

}
