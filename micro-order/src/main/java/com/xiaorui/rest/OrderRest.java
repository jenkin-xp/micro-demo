package com.xiaorui.rest;

import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.common.exception.BizException;
import com.xiaorui.common.exception.ExceptionCode;
import com.xiaorui.api.order.vo.OrderListVO;
import com.xiaorui.model.Order;
import com.xiaorui.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/10 11:25
 * @Version V1.0
 **/
@RestController
@RequestMapping(ServiceId.MODEL_ID_ORDER)
public class OrderRest {

    @Autowired
    private IOrderService orderService;

    @GetMapping("getOrderById")
    public OrderListVO getOrderById(@RequestParam("id") int id) {
        Order order = orderService.selectById(id);
        if (order == null) throw new BizException(ExceptionCode.ORDER_NOT_EXIST);
        OrderListVO orderListVO = new OrderListVO();
        BeanUtils.copyProperties(order, orderListVO);
        return orderListVO;
    }

}
