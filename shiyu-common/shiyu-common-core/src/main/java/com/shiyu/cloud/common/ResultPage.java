package com.shiyu.cloud.common;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 返回分页结果集
 **/
@AllArgsConstructor
@NoArgsConstructor
public class ResultPage<T> extends ResultBase implements Serializable {
    @Serial
    private static final long serialVersionUID = 7589048900820007216L;

    @Getter
    @Setter
    private int totalCount = 0;

    private int pageSize = 10;

    private int pageIndex = 1;

    private Collection<T> data;

    public int getPageSize() {
        if (pageSize < 1) {
            return 1;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    public int getPageIndex() {
        if (pageIndex < 1) {
            return 1;
        }
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public List<T> getData() {
        if (null == data) {
            return Collections.emptyList();
        }
        if (data instanceof List<T> dataList) {
            return dataList;
        }
        return new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return this.totalCount % this.pageSize == 0 ? this.totalCount
                / this.pageSize : (this.totalCount / this.pageSize) + 1;
    }

    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    /**
     * 全参数方法
     *
     * @param code    状态码
     * @param success  状态
     * @param message 返回信息
     * @param data    返回数据
     * @param <T>     泛型
     * @return {@link ResultPage<T>}
     */
    private static <T> ResultPage<T> response(Integer code, Boolean success, String message, Collection<T> data) {
        ResultPage<T> Result = new ResultPage<>();
        Result.setCode(code);
        Result.setSuccess(success);
        Result.setMessage(message);
        Result.setData(data);
        return Result;
    }

    /**
     * 全参数方法
     *
     * @param code    状态码
     * @param success  状态
     * @param message 返回信息
     * @param <T>     泛型
     * @return {@link ResultPage<T>}
     */
    private static <T> ResultPage<T> response(Integer code, Boolean success, String message) {
        ResultPage<T> Result = new ResultPage<>();
        Result.setCode(code);
        Result.setSuccess(success);
        Result.setMessage(message);
        Result.setData(new ArrayList<>());
        return Result;
    }

    /**
     * 成功返回（返回信息 + 数据）
     *
     * @param message 返回信息
     * @param data    数据
     * @param <T>     泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> success(String message, Collection<T> data) {
        return response(ResultEnum.SUCCESS.getCode(), true, message, data);
    }

    /**
     * 成功返回（枚举参数+数据）
     *
     * @param httpResponseEnum 枚举参数
     * @param <T>              泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> success(ResultEnum httpResponseEnum,Collection<T> data) {
        return response(httpResponseEnum.getCode(), true, httpResponseEnum.getMessage(),data);
    }

    /**
     * 成功返回（状态码+返回信息+数据）
     *
     * @param code    状态码
     * @param message 返回信息
     * @param data    数据
     * @param <T>     泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> success(Integer code, String message, Collection<T> data) {
        return response(code, true, message, data);
    }

    /**
     * 成功返回（数据）
     *
     * @param data 数据
     * @param <T>  泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> success(Collection<T> data) {
        return response(ResultEnum.SUCCESS.getCode(), true, ResultEnum.SUCCESS.getMessage(), data);
    }


    /**
     * 失败返回（无参）
     *
     * @param <T> 泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> fail() {
        return response(ResultEnum.ERROR.getCode(), false, ResultEnum.ERROR.getMessage());
    }

    /**
     * 失败返回（枚举）
     *
     * @param httpResponseEnum 枚举
     * @param <T>              泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> fail(ResultEnum httpResponseEnum) {
        return response(httpResponseEnum.getCode(), false, httpResponseEnum.getMessage());
    }

    /**
     * 失败返回（状态码+返回信息）
     *
     * @param code    状态码
     * @param message 返回信息
     * @param <T>     泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> fail(Integer code, String message) {
        return response(code, false, message);
    }

    /**
     * 失败返回（返回信息）
     *
     * @param message 返回信息
     * @param <T>  泛型
     * @return {@link ResultPage<T>}
     */
    public static <T> ResultPage<T> fail(String message) {
        return response(ResultEnum.ERROR.getCode(), false, message);
    }

}
