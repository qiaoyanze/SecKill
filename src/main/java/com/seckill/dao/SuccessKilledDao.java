package com.seckill.dao;

import com.seckill.model.SuccessKilled;
import org.apache.ibatis.annotations.Param;

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
    int insertSuccessKilled(@Param("secKillId") long secKillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询秒杀明细，带有秒杀商品对象
     *
     * @param secKillId
     * @return
     */
    SuccessKilled queryByIdWithSecKill(@Param("secKillId") long secKillId, @Param("userPhone") long userPhone);
}
