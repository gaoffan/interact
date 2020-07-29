package org.sacc.interact;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.sacc.interact.mapper")
@SpringBootApplication
public class InteractApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteractApplication.class, args);
    }

}
