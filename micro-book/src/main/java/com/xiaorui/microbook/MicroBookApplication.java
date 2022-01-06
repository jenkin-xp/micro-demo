package com.xiaorui.microbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.xiaorui.microbook.mapper")
@EnableFeignClients(basePackages = {"com.xiaorui"})
public class MicroBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroBookApplication.class, args);
    }

}
