package com.example.demo.stream;

import java.util.stream.Stream;

/**
 * @author Zhengyn
 * @description
 * @create 20/12/29 16:50
 */
public class TestStream1 {
    public static void main(String[] args) {
        Stream.of("hello", "world").map(s -> s.split("")).forEach(System.out::println);
        System.out.println("--------------");
        Stream.of("hello", "world").flatMap(s -> Stream.of(s.split(""))).forEach(System.out::println);


    }
}
