package com.shiyu.cloud.user.mapper;

import com.shiyu.cloud.user.model.ShiYuUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户(ShiYuUser)表数据库访问层
 *
 * @author shiyu
 * @since 2024-08-25 10:43:16
 */
@Mapper
public interface ShiYuUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShiYuUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param shiYuUser 查询条件
     * @return 对象列表
     */
    List<ShiYuUser> queryAll(ShiYuUser shiYuUser);

    /**
     * 统计总行数
     *
     * @param shiYuUser 查询条件
     * @return 总行数
     */
    long count(ShiYuUser shiYuUser);

    /**
     * 新增数据
     *
     * @param shiYuUser 实例对象
     * @return 影响行数
     */
    int insert(ShiYuUser shiYuUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiYuUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShiYuUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiYuUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShiYuUser> entities);

    /**
     * 修改数据
     *
     * @param shiYuUser 实例对象
     * @return 影响行数
     */
    int update(ShiYuUser shiYuUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}


