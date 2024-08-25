package com.shiyu.cloud.common;

import lombok.Data;

@Data
public class ResultBase {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private Boolean success;

    /**
     * 返回信息
     */
    private String message;
}
