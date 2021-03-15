package com.example.demo.redis.testPackage.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/10 11:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student {

    private Integer id;
    private String name;
    private Integer sex;
    private Integer age;
}
