package com.yanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        String tmpDir = System.getProperty("java.io.tmpdir");
        System.out.println("临时路径：" + tmpDir);
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
