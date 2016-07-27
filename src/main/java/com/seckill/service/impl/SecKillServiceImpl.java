package com.seckill.service.impl;

import com.seckill.Exception.RepeatKillException;
import com.seckill.Exception.SecKillClosedException;
import com.seckill.Exception.SecKillException;
import com.seckill.dao.SecKillDao;
import com.seckill.dao.SuccessKilledDao;
import com.seckill.dto.Exposer;
import com.seckill.dto.SecKillExcution;
import com.seckill.enums.SecKillStateEnum;
import com.seckill.model.SecKill;
import com.seckill.model.SuccessKilled;
import com.seckill.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * 秒杀接口实现
 * <p>
 * Created by QYANZE on 2016/7/26.
 */
@Service("secKillService")
public class SecKillServiceImpl implements SecKillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillDao secKillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;

    /**
     * 盐值字符串-用来混淆MD5加密
     */
    private final String slat = "KDSOFdkjfadjlDLKFFKDSF35434*&^&fdsfs";

    @Override
    public List<SecKill> getSecKillList() {
        return this.secKillDao.queryAll(0, 4);
    }

    @Override
    public SecKill getBySecKillId(long secKillId) {
        return this.secKillDao.queryById(secKillId);
    }

    @Override
    public Exposer exportSecKillUrl(long secKillId) {
        SecKill secKill = this.getBySecKillId(secKillId);
        if (secKill == null) {
            return new Exposer(false, secKillId);
        }

        Date startTime = secKill.getStartTime();
        Date endTime = secKill.getEndTime();
        Date nowTime = new Date();
        if (startTime.getTime() > nowTime.getTime()
                || endTime.getTime() < nowTime.getTime()) {
            return new Exposer(false, secKillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        String md5 = this.getMd5(secKillId);
        return new Exposer(true, md5, secKillId);
    }

    /**
     * 生成MD5
     *
     * @param secKillId
     * @return
     */
    private String getMd5(long secKillId) {
        String baseStr = secKillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(baseStr.getBytes());
        return md5;
    }

    @Override
    @Transactional
    public SecKillExcution executeSecKill(long secKillId, long userPhone, String md5)
            throws SecKillException, RepeatKillException, SecKillClosedException {
        try {
            if (md5 == null || !md5.equals(getMd5(secKillId))) {
                throw new SecKillException("secKill data rewrite");
            }
            // 执行秒杀，记录秒杀结果
            Date nowTime = new Date();
            // 减库存
            int updateCounts = this.secKillDao.reduceNumber(secKillId, nowTime);
            if (updateCounts <= 0) {
                // 没有更新记录，说明秒杀结束
                throw new SecKillClosedException("secKill is closed");
            } else {
                // 记录秒杀结果
                int insertCounts = this.successKilledDao.insertSuccessKilled(secKillId, userPhone);
                if (insertCounts <= 0) {
                    // 重复秒杀
                    throw new RepeatKillException("secKill repeated");
                } else {
                    // 秒杀成功
                    SuccessKilled successKilled = this.successKilledDao.queryByIdWithSecKill(secKillId, userPhone);
                    return new SecKillExcution(secKillId, SecKillStateEnum.SUCCESS, successKilled);
                }
            }
        } catch (SecKillClosedException e) {
            throw e;
        } catch (RepeatKillException e) {
            throw e;
        } catch (Exception e) {
            throw new SecKillException("secKill inner error" + e.getMessage());
        }
    }
}
