package com.shiyu.cloud.user.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户(ShiYuUser)实体类
 *
 * @author shiyu
 * @since 2024-08-25 10:47:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiYuUser implements Serializable {
private static final long serialVersionUID = 424103494527047542L;
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 地址
     */
    private String addr;
    /**
     * 性别 0：保密 1：男 2：女
     */
    private Integer gender;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 密码
     */
    private String password;
    /**
     * 其他信息
     */
    private String extInfo;
    /**
     * 0:活跃
     */
    private Integer status;
    /**
     * 0：删除 1：正常
     */
    private Integer delStatus;
}


