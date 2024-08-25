package com.shiyu.cloud.product.service;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.product.model.ShiYuProduct;

/**
 * 商品表(ShiYuProduct)表服务接口
 *
 * @author shiyu
 * @since 2024-08-25 10:53:14
 */
public interface ShiYuProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Result<ShiYuProduct> queryById(Long id);

    /**
     * 全查询
     *
     * @param shiYuProduct 筛选条件
     * @return 查询结果
     */
    ResultPage<ShiYuProduct> queryAll(ShiYuProduct shiYuProduct);

    /**
     * 新增数据
     *
     * @param shiYuProduct 实例对象
     * @return 实例对象
     */
    Result insert(ShiYuProduct shiYuProduct);

    /**
     * 修改数据
     *
     * @param shiYuProduct 实例对象
     * @return 实例对象
     */
    Result update(ShiYuProduct shiYuProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Result deleteById(Long id);

}

