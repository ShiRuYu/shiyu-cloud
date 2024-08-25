package com.shiyu.cloud.order.controller;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.order.model.ShiYuOrder;
import com.shiyu.cloud.order.service.ShiYuOrderService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * 订单(ShiYuOrder)表控制层
 *
 * @author shiyu
 * @since 2024-08-25 10:57:39
 */
@RestController
@RequestMapping("shiYuOrder")
public class ShiYuOrderController {
    /**
     * 服务对象
     */
    @Resource
    private ShiYuOrderService shiYuOrderService;

    /**
     * 全查询
     *
     * @param shiYuOrder 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResultPage<ShiYuOrder> queryAll(ShiYuOrder shiYuOrder) {
        return this.shiYuOrderService.queryAll(shiYuOrder);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<ShiYuOrder> queryById(@PathVariable("id") Long id) {
        return this.shiYuOrderService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param shiYuOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(@RequestBody ShiYuOrder shiYuOrder) {
        return this.shiYuOrderService.insert(shiYuOrder);
    }

    /**
     * 编辑数据
     *
     * @param shiYuOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(@RequestBody ShiYuOrder shiYuOrder) {
        return this.shiYuOrderService.update(shiYuOrder);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Long id) {
        return this.shiYuOrderService.deleteById(id);
    }

}


