package com.seckill.service;

import com.seckill.Exception.RepeatKillException;
import com.seckill.Exception.SecKillClosedException;
import com.seckill.Exception.SecKillException;
import com.seckill.dto.Exposer;
import com.seckill.dto.SecKillExcution;
import com.seckill.model.SecKill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by QYANZE on 2016/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SecKillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillService secKillService;

    @Test
    public void testGetSecKillList() throws Exception {
        List<SecKill> secKillList = this.secKillService.getSecKillList();
        logger.info("list:" + secKillList);
    }

    @Test
    public void testGetBySecKillId() throws Exception {
        long secKillId = 1000L;
        SecKill secKill = this.secKillService.getBySecKillId(secKillId);
        logger.info("secKill:" + secKill);
    }

    @Test
    public void testSecKillLogic() throws Exception {
        long secKillId = 1000L;
        Exposer exposer = this.secKillService.exportSecKillUrl(secKillId);
        if (exposer.isExposed()) {
            logger.info("exposer:" + exposer);
            long userPhone = 15902326678L;
            String md5 = exposer.getMd5();
            try {
                SecKillExcution secKillExcution = this.secKillService.executeSecKill(secKillId, userPhone, md5);
                logger.info("execution:" + secKillExcution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SecKillClosedException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer:" + exposer);
        }
    }
}