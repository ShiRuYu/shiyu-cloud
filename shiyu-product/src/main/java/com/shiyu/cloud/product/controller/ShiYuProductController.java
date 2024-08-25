package com.shiyu.cloud.product.controller;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.product.model.ShiYuProduct;
import com.shiyu.cloud.product.service.ShiYuProductService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * 商品表(ShiYuProduct)表控制层
 *
 * @author shiyu
 * @since 2024-08-25 10:53:14
 */
@RestController
@RequestMapping("shiYuProduct")
public class ShiYuProductController {
    /**
     * 服务对象
     */
    @Resource
    private ShiYuProductService shiYuProductService;

    /**
     * 全查询
     *
     * @param shiYuProduct 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResultPage<ShiYuProduct> queryAll(ShiYuProduct shiYuProduct) {
        return this.shiYuProductService.queryAll(shiYuProduct);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<ShiYuProduct> queryById(@PathVariable("id") Long id) {
        return this.shiYuProductService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param shiYuProduct 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(@RequestBody ShiYuProduct shiYuProduct) {
        return this.shiYuProductService.insert(shiYuProduct);
    }

    /**
     * 编辑数据
     *
     * @param shiYuProduct 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(@RequestBody ShiYuProduct shiYuProduct) {
        return this.shiYuProductService.update(shiYuProduct);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Long id) {
        return this.shiYuProductService.deleteById(id);
    }

}


