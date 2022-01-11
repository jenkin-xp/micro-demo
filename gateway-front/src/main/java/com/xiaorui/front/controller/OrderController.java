package com.xiaorui.front.controller;

import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.api.order.feign.OrderFeign;
import com.xiaorui.api.order.vo.OrderListVO;
import com.xiaorui.common.vo.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/7 17:31
 * @Version V1.0
 **/
@RestController
@RequestMapping(ServiceId.MODEL_ID_ORDER)
public class OrderController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("getOrderById")
    public ResponseDTO<OrderListVO> getOrderById(@RequestParam("id") int id) {
        return new ResponseDTO<>(orderFeign.getOrderById(id));
    }

}
