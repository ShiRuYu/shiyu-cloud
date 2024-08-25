package com.shiyu.cloud.user.service;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.user.model.ShiYuUser;

/**
 * 用户(ShiYuUser)表服务接口
 *
 * @author shiyu
 * @since 2024-08-25 10:43:16
 */
public interface ShiYuUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Result<ShiYuUser> queryById(Long id);

    /**
     * 全查询
     *
     * @param shiYuUser 筛选条件
     * @return 查询结果
     */
    ResultPage<ShiYuUser> queryAll(ShiYuUser shiYuUser);

    /**
     * 新增数据
     *
     * @param shiYuUser 实例对象
     * @return 实例对象
     */
    Result insert(ShiYuUser shiYuUser);

    /**
     * 修改数据
     *
     * @param shiYuUser 实例对象
     * @return 实例对象
     */
    Result update(ShiYuUser shiYuUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Result deleteById(Long id);

}

