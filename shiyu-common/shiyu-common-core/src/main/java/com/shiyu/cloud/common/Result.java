package com.shiyu.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 返回结果集
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> extends ResultBase implements Serializable {

    @Serial
    private static final long serialVersionUID = -8910857116930393244L;

    /**
     * 数据
     */
    private T data;

    /**
     * 全参数方法
     *
     * @param code    状态码
     * @param success  状态
     * @param message 返回信息
     * @param data    返回数据
     * @param <T>     泛型
     * @return {@link Result<T>}
     */
    private static <T> Result<T> response(Integer code, Boolean success, String message, T data) {
        Result<T> Result = new Result<>();
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
     * @return {@link Result<T>}
     */
    private static <T> Result<T> response(Integer code, Boolean success, String message) {
        Result<T> Result = new Result<>();
        Result.setCode(code);
        Result.setSuccess(success);
        Result.setMessage(message);
        return Result;
    }

    /**
     * 成功返回（无参）
     *
     * @param <T> 泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success() {
        return response(ResultEnum.SUCCESS.getCode(), true, ResultEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回（枚举参数）
     *
     * @param httpResponseEnum 枚举参数
     * @param <T>              泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success(ResultEnum httpResponseEnum) {
        return response(httpResponseEnum.getCode(), true, httpResponseEnum.getMessage());
    }

    /**
     * 成功返回（状态码+返回信息）
     *
     * @param code    状态码
     * @param message 返回信息
     * @param <T>     泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success(Integer code, String message) {
        return response(code, true, message);
    }

    /**
     * 成功返回（返回信息 + 数据）
     *
     * @param message 返回信息
     * @param data    数据
     * @param <T>     泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success(String message, T data) {
        return response(ResultEnum.SUCCESS.getCode(), true, message, data);
    }

    /**
     * 成功返回（状态码+返回信息+数据）
     *
     * @param code    状态码
     * @param message 返回信息
     * @param data    数据
     * @param <T>     泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success(Integer code, String message, T data) {
        return response(code, true, message, data);
    }

    /**
     * 成功返回（数据）
     *
     * @param data 数据
     * @param <T>  泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success(T data) {
        return response(ResultEnum.SUCCESS.getCode(), true, ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回（返回信息）
     *
     * @param message 返回信息
     * @param <T>  泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success(String message) {
        return response(ResultEnum.SUCCESS.getCode(), true, message, null);
    }


    /**
     * 失败返回（无参）
     *
     * @param <T> 泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> fail() {
        return response(ResultEnum.ERROR.getCode(), false, ResultEnum.ERROR.getMessage(), null);
    }

    /**
     * 失败返回（枚举）
     *
     * @param httpResponseEnum 枚举
     * @param <T>              泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> fail(ResultEnum httpResponseEnum) {
        return response(httpResponseEnum.getCode(), false, httpResponseEnum.getMessage());
    }

    /**
     * 失败返回（状态码+返回信息）
     *
     * @param code    状态码
     * @param message 返回信息
     * @param <T>     泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> fail(Integer code, String message) {
        return response(code, false, message);
    }

    /**
     * 失败返回（返回信息+数据）
     *
     * @param message 返回信息
     * @param data    数据
     * @param <T>     泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> fail(String message, T data) {
        return response(ResultEnum.ERROR.getCode(), false, message, data);
    }

    /**
     * 失败返回（状态码+返回信息+数据）
     *
     * @param code    状态码
     * @param message 返回消息
     * @param data    数据
     * @param <T>     泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> fail(Integer code, String message, T data) {
        return response(code, false, message, data);
    }

    /**
     * 失败返回（数据）
     *
     * @param data 数据
     * @param <T>  泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> fail(T data) {
        return response(ResultEnum.ERROR.getCode(), false, ResultEnum.ERROR.getMessage(), data);
    }

    /**
     * 失败返回（返回信息）
     *
     * @param message 返回信息
     * @param <T>  泛型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> fail(String message) {
        return response(ResultEnum.ERROR.getCode(), false, message, null);
    }

}
