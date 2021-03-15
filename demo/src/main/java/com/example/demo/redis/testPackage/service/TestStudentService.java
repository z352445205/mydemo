package com.example.demo.redis.testPackage.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.redis.testPackage.entry.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/10 11:08
 */
@Service
public class TestStudentService {

    @Cacheable(value = "getCache",key = "#root.targetClass.simpleName+':'+#root.methodName+':'+#integer")
    public List<Student> get(Integer integer) {
        System.err.println("-------缓存未命中，进入方法-------");
        final Student a = new Student(1, "A一", 0, 11);
        final Student b = new Student(2, "B二", 1, 22);
        final Student c = new Student(3, "C三", 0, 33);
        final Student d = new Student(4, "D四", 1, 44);

        return Arrays.asList(a, b, c, d);
    }

    @CacheEvict(value = "getCache",allEntries = true)
    public boolean put(List<Student> students) {
        return CollectionUtil.isNotEmpty(students);
    }

}
