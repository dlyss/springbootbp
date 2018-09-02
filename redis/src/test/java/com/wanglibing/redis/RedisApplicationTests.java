package com.wanglibing.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {


    @Autowired
    RedisUtils redisUtils1;
    @Test
    public void contextLoads() {
    }

    @Test
    public void test2(){
        redisUtils1.cacheValue("key2","value2");
    }

}
