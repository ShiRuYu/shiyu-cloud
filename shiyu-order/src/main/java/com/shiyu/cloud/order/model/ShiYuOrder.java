package com.shiyu.cloud.order.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单(ShiYuOrder)实体类
 *
 * @author shiyu
 * @since 2024-08-25 10:57:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiYuOrder implements Serializable {
private static final long serialVersionUID = -15262780059838323L;
    /**
     * 自增长主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 订单单号 唯一值，供客户查询
     */
    private Long orderNo;
    /**
     * 商店编号
     */
    private Long shopId;
    /**
     * 未付款,已付款,已发货,已签收,退货申请,退货中,已退货,取消交易
     */
    private Integer orderStatus;
    /**
     * 商品项目数量，不是商品
     */
    private Integer productCount;
    /**
     * 商品总价
     */
    private Integer productAmountTotal;
    /**
     * 实际付款金额
     */
    private Double orderAmountTotal;
    /**
     * 运费金额
     */
    private Double logisticsFee;
    /**
     * 收货地址表自动编号
     */
    private Long addressId;
    /**
     * 订单物流表自动编号
     */
    private Long orderlogisticsId;
    /**
     * 订单支付渠道 
     */
    private String payChannel;
    /**
     * 第三方支付流水号
     */
    private String outTradeNo;
    /**
     * 用户ID
     */
    private String userId;
    /**
     *  客户备注
     */
    private String remork;
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 发货时间
     */
    private Date deliveryTime;
    /**
     * 订单结算时间
     */
    private Date orderSettlementTime;
}


