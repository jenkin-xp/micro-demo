package com.xiaorui.mapper;

import com.xiaorui.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 夏鹏
 * @since 2022-01-10
 */
public interface OrderMapper extends BaseMapper<Order> {

    Order selectOrderById(@Param("id") int id);

}
