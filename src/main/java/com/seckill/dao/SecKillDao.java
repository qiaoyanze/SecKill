package com.seckill.dao;

import com.seckill.model.SecKill;

import java.util.Date;
import java.util.List;

/**
 * Created by QYANZE on 2016/7/24.
 */
public interface SecKillDao {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(long seckillId, Date killTime);

    /**
     * 根据id查询秒杀对象
     *
     * @param seckillId
     * @return
     */
    SecKill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<SecKill> queryAll(int offset,int limit);
}
