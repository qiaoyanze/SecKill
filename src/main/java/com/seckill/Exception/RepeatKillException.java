package com.seckill.Exception;

/**
 * 重复秒杀异常
 * <p>
 * Created by QYANZE on 2016/7/26.
 */
public class RepeatKillException extends SecKillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
