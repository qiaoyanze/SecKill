package com.seckill.dao;

import com.seckill.model.SuccessKilled;

/**
 * Created by QYANZE on 2016/7/24.
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细,可过滤重复（联合主键）
     *
     * @param secKillId
     * @param userPhone
     * @return
     */
    int add(long secKillId,long userPhone);

    /**
     * 根据id查询秒杀明细，带有秒杀商品对象
     *
     * @param secKillId
     * @return
     */
    SuccessKilled queryByIdWithSecKill(long secKillId);
}
