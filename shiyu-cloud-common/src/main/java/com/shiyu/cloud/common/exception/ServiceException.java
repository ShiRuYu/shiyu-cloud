package com.shiyu.cloud.common.exception;

/**
 * @ClassName: BusinessException
 * @Description: 自定义业务异常
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int errorCode = -1;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(int errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}