package com.xiaorui.api.order.feign;

import com.xiaorui.api.config.FeignClientErrorDecoder;
import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.api.order.vo.OrderListVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ServiceId.SERVICE_ID_ORDER, path = ServiceId.MODEL_ID_ORDER, configuration = FeignClientErrorDecoder.class)
public interface OrderFeign {

    @GetMapping("getOrderById")
    OrderListVO getOrderById(@RequestParam("id") int id);

}
