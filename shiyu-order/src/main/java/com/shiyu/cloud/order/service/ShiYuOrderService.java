package com.shiyu.cloud.order.service;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.order.model.ShiYuOrder;

/**
 * 订单(ShiYuOrder)表服务接口
 *
 * @author shiyu
 * @since 2024-08-25 10:57:39
 */
public interface ShiYuOrderService {

        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        Result<ShiYuOrder> queryById(Long id);

        /**
         * 全查询
         *
         * @param shiYuOrder 筛选条件
         * @return 查询结果
         */
        ResultPage<ShiYuOrder> queryAll(ShiYuOrder shiYuOrder);

        /**
         * 新增数据
         *
         * @param shiYuOrder 实例对象
         * @return 实例对象
         */
        Result insert(ShiYuOrder shiYuOrder);

        /**
         * 修改数据
         *
         * @param shiYuOrder 实例对象
         * @return 实例对象
         */
        Result update(ShiYuOrder shiYuOrder);

        /**
         * 通过主键删除数据
         *
         * @param id 主键
         * @return 是否成功
         */
        Result deleteById(Long id);

        }

