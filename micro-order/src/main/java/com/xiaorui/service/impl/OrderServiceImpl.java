package com.xiaorui.service.impl;

import com.xiaorui.model.Order;
import com.xiaorui.mapper.OrderMapper;
import com.xiaorui.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 夏鹏
 * @since 2022-01-10
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public Order selectById(int id) {
        return this.baseMapper.selectOrderById(id);
    }
}
