package com.shiyu.cloud.product.service.impl;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.product.model.ShiYuProduct;
import com.shiyu.cloud.product.mapper.ShiYuProductMapper;
import com.shiyu.cloud.product.service.ShiYuProductService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * 商品表(ShiYuProduct)表服务实现类
 *
 * @author shiyu
 * @since 2024-08-25 10:53:14
 */
@Service("shiYuProductService")
public class ShiYuProductServiceImpl implements ShiYuProductService {
    @Resource
    private ShiYuProductMapper shiYuProductMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result<ShiYuProduct> queryById(Long id) {
        return Result.success(this.shiYuProductMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param shiYuProduct 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultPage<ShiYuProduct> queryAll(ShiYuProduct shiYuProduct) {
        return ResultPage.success(this.shiYuProductMapper.queryAll(shiYuProduct));
    }

    /**
     * 新增数据
     *
     * @param shiYuProduct 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(ShiYuProduct shiYuProduct) {
        this.shiYuProductMapper.insert(shiYuProduct);
        return Result.success();
    }

    /**
     * 修改数据
     *
     * @param shiYuProduct 实例对象
     * @return 实例对象
     */
    @Override
    public Result update(ShiYuProduct shiYuProduct) {
        this.shiYuProductMapper.update(shiYuProduct);
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
        boolean del = this.shiYuProductMapper.deleteById(id) > 0;
        return Result.success(del);
    }
}

