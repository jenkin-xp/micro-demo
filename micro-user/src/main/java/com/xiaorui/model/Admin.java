package com.xiaorui.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 后台用户管理
 * </p>
 *
 * @author 夏鹏
 * @since 2022-01-11
 */
@Data
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 用户姓名
     */
	private String fullName;
    /**
     * 密码
     */
	private String password;
    /**
     * 手机号
     */
	private String phone;
    /**
     * 图像路径
     */
	private String headUrl;
    /**
     * 外键，角色ID
     */
	private Integer roleId;
    /**
     * 账号状态 1：已启用  0：未启用
     */
	private Boolean accountStatus;
    /**
     * 备注
     */
	private String remark;
    /**
     * 密码是否更改 1：已改  0：未更改
     */
	private Boolean passwdChanged;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 更新时间
     */
	private Date updateTime;
    /**
     * 是否有效  1：无效  0：有效
     */
	private Boolean invalid;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
