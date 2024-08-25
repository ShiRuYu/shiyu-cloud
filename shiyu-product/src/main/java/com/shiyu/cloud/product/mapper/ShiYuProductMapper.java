package com.shiyu.cloud.product.mapper;

import com.shiyu.cloud.product.model.ShiYuProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品表(ShiYuProduct)表数据库访问层
 *
 * @author shiyu
 * @since 2024-08-25 10:53:13
 */
@Mapper
public interface ShiYuProductMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShiYuProduct queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param shiYuProduct 查询条件
     * @return 对象列表
     */
    List<ShiYuProduct> queryAll(ShiYuProduct shiYuProduct);

    /**
     * 统计总行数
     *
     * @param shiYuProduct 查询条件
     * @return 总行数
     */
    long count(ShiYuProduct shiYuProduct);

    /**
     * 新增数据
     *
     * @param shiYuProduct 实例对象
     * @return 影响行数
     */
    int insert(ShiYuProduct shiYuProduct);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiYuProduct> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShiYuProduct> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiYuProduct> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShiYuProduct> entities);

    /**
     * 修改数据
     *
     * @param shiYuProduct 实例对象
     * @return 影响行数
     */
    int update(ShiYuProduct shiYuProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}


