package com.shiyu.cloud.order.mapper;

import com.shiyu.cloud.order.model.ShiYuOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单(ShiYuOrder)表数据库访问层
 *
 * @author shiyu
 * @since 2024-08-25 10:57:39
 */
@Mapper
public interface ShiYuOrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShiYuOrder queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param shiYuOrder 查询条件
     * @return 对象列表
     */
    List<ShiYuOrder> queryAll(ShiYuOrder shiYuOrder);

    /**
     * 统计总行数
     *
     * @param shiYuOrder 查询条件
     * @return 总行数
     */
    long count(ShiYuOrder shiYuOrder);

    /**
     * 新增数据
     *
     * @param shiYuOrder 实例对象
     * @return 影响行数
     */
    int insert(ShiYuOrder shiYuOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiYuOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShiYuOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiYuOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShiYuOrder> entities);

    /**
     * 修改数据
     *
     * @param shiYuOrder 实例对象
     * @return 影响行数
     */
    int update(ShiYuOrder shiYuOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}


