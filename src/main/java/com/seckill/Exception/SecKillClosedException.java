package com.seckill.Exception;

/**
 * 秒杀关闭异常
 * <p>
 * Created by QYANZE on 2016/7/26.
 */
public class SecKillClosedException extends SecKillException {
    public SecKillClosedException(String message) {
        super(message);
    }

    public SecKillClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
