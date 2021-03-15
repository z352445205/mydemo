package com.example.demo.stream.function;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author Zhengyn
 * @description
 * @create 20/12/23 19:43
 */
@Data
@Accessors(chain = true)
public class Student {
    private String name ;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
