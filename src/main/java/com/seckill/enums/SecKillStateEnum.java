package com.seckill.enums;

/**
 * 定义状态枚举常量
 * <p>
 * Created by QYANZE on 2016/7/26.
 */
public enum SecKillStateEnum {

    SUCCESS(0, "秒杀成功"),
    END(1, "秒杀成功"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改");

    private int state;

    private String stateInfo;

    SecKillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SecKillStateEnum stateOf(int index) {
        for (SecKillStateEnum stateEnum : values()) {
            if (stateEnum.getState() == index) {
                return stateEnum;
            }
        }
        return null;
    }
}

