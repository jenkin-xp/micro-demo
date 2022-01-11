package com.xiaorui;

import com.xiaorui.common.annotation.ScanIgnore;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.xiaorui.mapper")
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ScanIgnore.class)})
@EnableFeignClients(basePackages = {"com.xiaorui.api"})
public class MicroBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroBookApplication.class, args);
    }

}
