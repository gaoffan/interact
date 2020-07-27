package org.sacc.interact;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.sacc.interact.mapper")
public class InteractApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteractApplication.class, args);
    }

}
