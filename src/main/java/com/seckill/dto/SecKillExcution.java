package com.seckill.dto;

import com.seckill.enums.SecKillStateEnum;
import com.seckill.model.SuccessKilled;

/**
 * 封装秒杀后返回结果
 * <p>
 * Created by QYANZE on 2016/7/26.
 */
public class SecKillExcution {

    /**
     * 秒杀商品id
     */
    private long secKillId;

    /**
     * 返回结果状态
     */
    private int state;

    /**
     * 状态信息
     */
    private String stateInfo;

    /**
     * 秒杀成功对象
     */
    private SuccessKilled successKilled;

    public SecKillExcution(long secKillId, SecKillStateEnum stateEnum, SuccessKilled successKilled) {
        this.secKillId = secKillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SecKillExcution(long secKillId, SecKillStateEnum stateEnum) {
        this.secKillId = secKillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getSecKillId() {
        return secKillId;
    }

    public void setSecKillId(long secKillId) {
        this.secKillId = secKillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SecKillExcution{" +
                "secKillId=" + secKillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}
