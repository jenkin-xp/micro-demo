package com.xiaorui.model;


import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author 夏鹏
 * @since 2022-01-10
 */
@Data
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 外键读者书籍关联表ID
     */
	private Integer readerBookId;
    /**
     * 读者ID
     */
	private Integer readerId;
    /**
     * 书籍ID
     */
	private Integer bookId;
    /**
     * 系统生成订单号
     */
	private String orderCode;
    /**
     * （第三方返回）交易流水号
     */
	private String transactionId;
    /**
     * 订单类型  目前 1：购买  2：打赏 3：咨询 4：畅读卡
     */
	private Integer orderType;
    /**
     * 订单来源
     */
	private String orderSource;
    /**
     * 小程序来源
     */
	private String appSource;
    /**
     * 订单备注
     */
	private String orderDesc;
    /**
     * 订单金额
     */
	private BigDecimal orderAmount;
    /**
     * 订单状态 1：待支付  5：支付失败 8：支付成功  9：关闭
     */
	private Integer orderStatus;
    /**
     * 支付方式  1：微信  
     */
	private Integer paymentMethod;
    /**
     * 订单创建时间
     */
	private Date createTime;
    /**
     * 订单支付时间
     */
	private Date paymentTime;
    /**
     * 退款时间
     */
	private Date refundTime;
    /**
     * 订单更新时间
     */
	private Date updateTime;
    /**
     * 用户下单手机号
     */
	private String phone;
    /**
     * 收货人名称
     */
	private String shippingName;
    /**
     * 收货人手机号
     */
	private String shippingPhone;
    /**
     * 收货人地址
     */
	private String shippingAddress;
    /**
     * 订单页面来源
     */
	private String pageCode;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
