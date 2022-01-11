package com.xiaorui.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * ========================
 * @Author: xp_sh
 * @Description: 拦截器配置
 * @Date：2020/06/08 18:20
 * Version: v1.0
 * ========================
 */
@EnableConfigurationProperties(NoAuthUrlProperties.class)
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private NoAuthUrlProperties noAuthUrlProperties;

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径可自行配置多个 可用 ，分隔开
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**").excludePathPatterns(new ArrayList<>(noAuthUrlProperties.getSkipUrls()));
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        List<String> crossDomains = noAuthUrlProperties.getCrossDomains();
        if (crossDomains != null) {
            if (crossDomains.size() == 1 && "all".equals(crossDomains.get(0))) {
                config.addAllowedOrigin("*");
            } else {
                config.setAllowedOrigins(crossDomains);
            }
        }
        config.setAllowCredentials(true);
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }


}
