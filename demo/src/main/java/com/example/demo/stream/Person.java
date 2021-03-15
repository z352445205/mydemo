package com.example.demo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhengyn
 * @description
 * @create 20/11/16 10:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区


}
