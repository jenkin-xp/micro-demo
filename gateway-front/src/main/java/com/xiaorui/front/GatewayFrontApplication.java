package com.xiaorui.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/7 17:17
 * @Version V1.0
 **/
@SpringBootApplication(scanBasePackages = "com.xiaorui", exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients("com.xiaorui.api")
public class GatewayFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayFrontApplication.class);
    }

}
