package com.example.demo.demo.redis.testPackage.service;

import com.example.demo.redis.testPackage.entry.Student;
import com.example.demo.redis.testPackage.service.TestStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/10 11:19
 */
@SpringBootTest
class TestStudentServiceTest {

    @Autowired
    TestStudentService testStudentService;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Test
    void get() {
        final List<Student> students = testStudentService.get(2);
        System.err.println(students);
    }

    @Test
    void put() {
        final Student a = new Student(1, "A一", 0, 12);

        testStudentService.put(Collections.singletonList(a));
    }

    @Test
    void testRedis() {
        final HashMap<String, Student> map = new HashMap<>();
        map.put("1",new Student(1, "A一", 0, 11));
        redisTemplate.opsForHash().putAll("key1", map);
    }
}