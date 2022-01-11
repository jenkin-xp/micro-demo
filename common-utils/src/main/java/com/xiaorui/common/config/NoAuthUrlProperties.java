package com.xiaorui.common.config;

import com.xiaorui.common.annotation.ScanIgnore;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Author ：XP
 * @Date ：Created in 2020/6/11
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @Description:
 **/
@Data
@ConfigurationProperties(prefix = "user.auth")
@ScanIgnore
public class NoAuthUrlProperties {

    private LinkedHashSet<String> skipUrls;
    private List<String> crossDomains;

}
