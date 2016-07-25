package com.seckill.model;

import java.util.Date;

/**
 * Created by QYANZE on 2016/7/24.
 */
public class SuccessKilled {
    /**
     * 秒杀商品id
     */
    private long seckillId;

    /**
     * 用户手机号码
     */
    private long userPhone;

    /**
     * 状态标识- -1:无效,0:成功,1:已付款
     */
    private int state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 秒杀对象
     */
    private SecKill secKill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SecKill getSecKill() {
        return secKill;
    }

    public void setSecKill(SecKill secKill) {
        this.secKill = secKill;
    }
}
