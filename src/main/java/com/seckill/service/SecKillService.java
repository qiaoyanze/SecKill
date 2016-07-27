package com.seckill.service;

import com.seckill.Exception.RepeatKillException;
import com.seckill.Exception.SecKillClosedException;
import com.seckill.Exception.SecKillException;
import com.seckill.dto.Exposer;
import com.seckill.dto.SecKillExcution;
import com.seckill.model.SecKill;

import java.util.List;

/**
 * Created by QYANZE on 2016/7/26.
 */
public interface SecKillService {

    /**
     * 秒杀商品的列表
     *
     * @return
     */
    List<SecKill> getSecKillList();

    /**
     * 根据商品id查询秒杀商品
     *
     * @param secKillId
     * @return
     */
    SecKill getBySecKillId(long secKillId);

    /**
     * 暴露秒杀接口地址，
     * 秒杀开启输出秒杀地址，否则输出系统时间和秒杀时间
     *
     * @param secKillId
     * @return
     */
    Exposer exportSecKillUrl(long secKillId);

    /**
     * 执行秒杀操作
     *
     * @param secKillId
     * @param userPhone
     * @param md5
     * @return
     */
    SecKillExcution executeSecKill(long secKillId, long userPhone, String md5)
            throws SecKillException, RepeatKillException, SecKillClosedException;
}