package com.seckill.Exception;

/**
 * 秒杀异常
 * <p>
 * Created by QYANZE on 2016/7/26.
 */
public class SecKillException extends RuntimeException {
    public SecKillException(String message) {
        super(message);
    }

    public SecKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
