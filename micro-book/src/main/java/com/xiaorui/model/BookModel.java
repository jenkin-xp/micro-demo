package com.xiaorui.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 书籍基本信息
 * </p>
 *
 * @author 蒋伟
 * @since 2021-04-09
 */
@Data
@TableName("book_basic_info")
public class BookModel extends Model<BookModel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 书籍ID(RAYS自动生成的唯一标识)
     */
	@TableField("rays_book_id")
	private Long raysBookId;
    /**
     * 书籍ISBN码
     */
	private String isbn;
    /**
     * 书籍名称
     */
	@TableField("book_name")
	private String bookName;
    /**
     * 书籍图片
     */
	@TableField("book_picture")
	private String bookPicture;
    /**
     * 特定发行区域
     */
	@TableField("specific_distribution_area")
	private String specificDistributionArea;
    /**
     * 出版社/书商
     */
	private String publisher;
    /**
     * 录入时间
     */
	@TableField("entry_time")
	private Date entryTime;
    /**
     * 书籍二维码类型
     */
	@TableField("book_qrcode_type")
	private String bookQrcodeType;
    /**
     * 题目是否完全匹配
     */
	@TableField("is_matched")
	private Integer isMatched;
    /**
     * 是否免费  1：免费  0：收费
     */
	@TableField("is_free")
	private Boolean isFree;
    /**
     * 免费使用次数
     */
	@TableField("free_times")
	private Integer freeTimes;
    /**
     * 整书价格
     */
	private BigDecimal price;
    /**
     * 单题价格
     */
	@TableField("each_price")
	private BigDecimal eachPrice;
    /**
     * 折扣
     */
	private BigDecimal rebate;
    /**
     * 是否可咨询
     */
	@TableField("can_consult")
	private Boolean canConsult;
    /**
     * 咨询价格
     */
	@TableField("consult_price")
	private BigDecimal consultPrice;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 视频课Id
     */
	@TableField("video_id")
	private Integer videoId;
    /**
     * 状态 1：正常， 0：已撤销
     */
	private Integer status;
    /**
     * 扫码跳转地址
     */
	@TableField("scan_jump")
	private String scanJump;
    /**
     * 发行量
     */
	private Integer circulation;
    /**
     * 项目经理
     */
	@TableField("project_manager")
	private String projectManager;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
