package org.cm.demo;

import org.cm.demo.entity.ChooseQuestion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("TEST", "Hello Fucker");
        Assert.assertEquals("Hello Fucker", stringRedisTemplate.opsForValue().get("TEST"));
    }

    @Test
    public void testObj() {
        ChooseQuestion chooseQuestion = new ChooseQuestion("TEST Question", "TEST Desc");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("question", chooseQuestion);
        Boolean hasKey = redisTemplate.hasKey("question");
        System.out.println("has key: " + hasKey);
    }
}
