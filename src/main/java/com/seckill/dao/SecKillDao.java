package com.seckill.dao;

import com.seckill.model.SecKill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by QYANZE on 2016/7/24.
 */
public interface SecKillDao {

    /**
     * 减库存
     *
     * @param secKillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("secKillId") long secKillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     *
     * @param secKillId
     * @return
     */
    SecKill queryById(long secKillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<SecKill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
