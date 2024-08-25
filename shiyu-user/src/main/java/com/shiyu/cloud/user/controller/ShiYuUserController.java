package com.shiyu.cloud.user.controller;

import com.shiyu.cloud.common.Result;
import com.shiyu.cloud.common.ResultPage;
import com.shiyu.cloud.user.model.ShiYuUser;
import com.shiyu.cloud.user.service.ShiYuUserService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * 用户(ShiYuUser)表控制层
 *
 * @author shiyu
 * @since 2024-08-25 10:43:16
 */
@RestController
@RequestMapping("shiYuUser")
public class ShiYuUserController {
    /**
     * 服务对象
     */
    @Resource
    private ShiYuUserService shiYuUserService;

    /**
     * 全查询
     *
     * @param shiYuUser 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResultPage<ShiYuUser> queryAll(ShiYuUser shiYuUser) {
        return this.shiYuUserService.queryAll(shiYuUser);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<ShiYuUser> queryById(@PathVariable("id") Long id) {
        return this.shiYuUserService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param shiYuUser 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(@RequestBody ShiYuUser shiYuUser) {
        return this.shiYuUserService.insert(shiYuUser);
    }

    /**
     * 编辑数据
     *
     * @param shiYuUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(@RequestBody ShiYuUser shiYuUser) {
        return this.shiYuUserService.update(shiYuUser);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Long id) {
        return this.shiYuUserService.deleteById(id);
    }

}


