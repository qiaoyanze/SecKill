package com.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        System.out.println("==========");
    }

    @Test
    public void queryById() throws Exception {

    }

    @Test
    public void queryAll() throws Exception {

    }
}