package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 技术沟通信息
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChatInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 企业编号
     */
    private String pharmacyCode;

    /**
     * 发送类型（1.用户发企业收 2企业发用户收）
     */
    private Integer type;

    /**
     * 内容
     */
    private String content;

    @TableField(exist = false)
    private Integer expertId;

    /**
     * 发送时间
     */
    private String createDate;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = true)
    private String pharmacyName;

    @TableField(exist = true)
    private String abbreviation;
}
