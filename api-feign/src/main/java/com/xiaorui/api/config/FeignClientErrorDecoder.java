package com.xiaorui.api.config;

import com.alibaba.fastjson.JSONObject;
import com.xiaorui.common.exception.BizException;
import com.xiaorui.common.exception.ExceptionCode;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * @Description feign调用异常处理
 * @Author xp
 * @Date 2022/1/7 11:39
 * @Version V1.0
 **/
@Configuration
@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        try {
            // 获取异常信息
            String message = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            log.error(message); //记录日志
            JSONObject jsonObject = JSONObject.parseObject(message);
            //直接上抛自定义异常
            return new BizException(ExceptionCode.FEIGN_ERROR.getCode()
                    , jsonObject.get("message")!=null?jsonObject.get("message").toString():message);
        }  catch (Exception ex) {
            return new BizException(ExceptionCode.SERVICE_ERROR);
        }
    }

}
