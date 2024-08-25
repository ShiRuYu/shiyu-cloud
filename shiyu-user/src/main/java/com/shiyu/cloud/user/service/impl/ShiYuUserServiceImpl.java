package com.shiyu.cloud.user.service.impl;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.user.mapper.ShiYuUserMapper;
import com.shiyu.cloud.user.model.ShiYuUser;
import com.shiyu.cloud.user.service.ShiYuUserService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * 用户(ShiYuUser)表服务实现类
 *
 * @author shiyu
 * @since 2024-08-25 10:43:16
 */
@Service("shiYuUserService")
public class ShiYuUserServiceImpl implements ShiYuUserService {
    @Resource
    private ShiYuUserMapper shiYuUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result<ShiYuUser> queryById(Long id) {
        return Result.success(this.shiYuUserMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param shiYuUser 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultPage<ShiYuUser> queryAll(ShiYuUser shiYuUser) {
        return ResultPage.success(this.shiYuUserMapper.queryAll(shiYuUser));
    }

    /**
     * 新增数据
     *
     * @param shiYuUser 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(ShiYuUser shiYuUser) {
        this.shiYuUserMapper.insert(shiYuUser);
        return Result.success();
    }

    /**
     * 修改数据
     *
     * @param shiYuUser 实例对象
     * @return 实例对象
     */
    @Override
    public Result update(ShiYuUser shiYuUser) {
        this.shiYuUserMapper.update(shiYuUser);
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
        boolean del = this.shiYuUserMapper.deleteById(id) > 0;
        return Result.success(del);
    }
}

