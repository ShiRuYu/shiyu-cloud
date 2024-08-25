package com.shiyu.cloud.order.service.impl;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.order.model.ShiYuOrder;
import com.shiyu.cloud.order.mapper.ShiYuOrderMapper;
import com.shiyu.cloud.order.service.ShiYuOrderService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * 订单(ShiYuOrder)表服务实现类
 *
 * @author shiyu
 * @since 2024-08-25 10:57:39
 */
@Service("shiYuOrderService")
public class ShiYuOrderServiceImpl implements ShiYuOrderService {
    @Resource
    private ShiYuOrderMapper shiYuOrderMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result<ShiYuOrder> queryById(Long id) {
        return Result.success(this.shiYuOrderMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param shiYuOrder 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultPage<ShiYuOrder> queryAll(ShiYuOrder shiYuOrder) {
        return ResultPage.success(this.shiYuOrderMapper.queryAll(shiYuOrder));
    }

    /**
     * 新增数据
     *
     * @param shiYuOrder 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(ShiYuOrder shiYuOrder) {
        this.shiYuOrderMapper.insert(shiYuOrder);
        return Result.success();
    }

    /**
     * 修改数据
     *
     * @param shiYuOrder 实例对象
     * @return 实例对象
     */
    @Override
    public Result update(ShiYuOrder shiYuOrder) {
        this.shiYuOrderMapper.update(shiYuOrder);
        return Result.success();
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result deleteById(Long id) {
        boolean del = this.shiYuOrderMapper.deleteById(id) > 0;
        return Result.success(del);
    }
}

