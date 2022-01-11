package com.xiaorui.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/11 17:35
 * @Version V1.0
 **/
@SpringBootApplication(scanBasePackages = "com.xiaorui", exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients("com.xiaorui.api")
public class GatewayAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayAdminApplication.class, args);
    }

}
