package com.xiaorui.service;


import com.xiaorui.model.Order;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author 夏鹏
 * @since 2022-01-10
 */
public interface IOrderService  {

    Order selectById(int id);

}
