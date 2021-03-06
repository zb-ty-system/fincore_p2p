package com.zb.p2p.paychannel;

import com.zb.p2p.paychannel.service.impl.RedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by limingxin on 2018/3/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisServiceImpl redisService;

    @Test
    public void testINCR() {
        String loginKey = "preErr:12345";
        redisService.setnx(loginKey, "1");//不存在则写入，初始值=1
        redisService.increment(loginKey, 1L, 60 * 5);//每次自增+1，并返回自增后的值
    }

    //
    @Test
    public void testINCR2() {
        String loginKey = "preErr:1234511";
        redisService.setIfAbsent(loginKey, "1", 30);//不存在则写入，初始值=1
        redisService.increment(loginKey, 1L, 60 * 5);//每次自增+1，并返回自增后的值
    }
}
