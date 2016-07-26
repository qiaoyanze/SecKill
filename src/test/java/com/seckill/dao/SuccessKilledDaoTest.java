package com.seckill.dao;

import com.seckill.model.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by QYANZE on 2016/7/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long secKillId = 1000L;
        long userPhone = 13902328978L;
        int insertCount = this.successKilledDao.insertSuccessKilled(secKillId, userPhone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void queryByIdWithSecKill() throws Exception {
        long secKillId = 1000L;
        long userPhone = 13902328978L;
        SuccessKilled successKilled = this.successKilledDao.queryByIdWithSecKill(secKillId, userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSecKill());
    }
}