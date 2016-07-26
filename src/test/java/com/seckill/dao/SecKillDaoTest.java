package com.seckill.dao;

import com.seckill.model.SecKill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by QYANZE on 2016/7/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class SecKillDaoTest {
    @Autowired
    private SecKillDao secKillDao;

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int i = this.secKillDao.reduceNumber(1000L, killTime);
        System.out.println(i);
    }

    @Test
    public void queryById() throws Exception {
        SecKill secKill = this.secKillDao.queryById(1000L);
        System.out.println(secKill.getSeckillId());
        System.out.println(secKill);
    }

    @Test
    public void queryAll() throws Exception {
        List<SecKill> secKills = this.secKillDao.queryAll(0, 10);
        System.out.println(secKills.size());
        for (SecKill kill : secKills) {
            System.out.println(kill.getSeckillId());
        }
    }
}