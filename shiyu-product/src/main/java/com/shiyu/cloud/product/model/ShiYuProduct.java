package com.shiyu.cloud.product.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品表(ShiYuProduct)实体类
 *
 * @author shiyu
 * @since 2024-08-25 10:53:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiYuProduct implements Serializable {
private static final long serialVersionUID = 728700102876948267L;
    private Long id;
    private Date createTime;
    private Date updateTime;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品型号
     */
    private String marque;
    /**
     * 仓库条码 
     */
    private String barcode;
    /**
     * 类型编号
     */
    private Long typeId;
    /**
     * 类别编号
     */
    private Long categoryId;
    /**
     * 品牌编号
     */
    private Long brandId;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 市场价格
     */
    private Double marketPrice;
    /**
     * 成本价格
     */
    private Double costPrice;
    /**
     * 库存量
     */
    private Long stock;
    /**
     * 告警库存 
     */
    private Integer warningStock;
    /**
     *  商品积分
     */
    private Double integral;
    /**
     *  商品图片url
     */
    private String pictureUrl;
    /**
     * 0:下架,1:上架,2:预售
     */
    private Integer status;
    /**
     * 0：删除  1：正常
     */
    private Integer delStatus;
}


