package com.xiaorui.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/25 16:12
 * @Version V1.0
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class);
    }

}
