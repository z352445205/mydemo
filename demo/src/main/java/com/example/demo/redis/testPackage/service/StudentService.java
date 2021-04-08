package com.example.demo.redis.testPackage.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.redis.testPackage.entity.Student;
import com.example.demo.redis.testPackage.mapper.StudentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhengyn
 * @since 2021-03-15
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> implements IService<Student> {
    @Cacheable(value = "getCache",key = "#root.targetClass.simpleName+':'+#root.methodName+':'+#integer")
    public List<Student> get(Integer integer) {
        System.err.println("-------缓存未命中，进入方法-------");
        final Student a = new Student(1L, "A一", 0, 11);
        final Student b = new Student(2L, "B二", 1, 22);
        final Student c = new Student(3L, "C三", 0, 33);
        final Student d = new Student(4L, "D四", 1, 44);
        saveOrUpdateBatch(Arrays.asList(a, b, c, d));

        return list();
    }

    @CacheEvict(value = "getCache",allEntries = true)
    public boolean put(List<Student> students) {
        return CollectionUtil.isNotEmpty(students);
    }

}
