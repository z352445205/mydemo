package com.example.demo.myoopdemo.builddemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 21:29
 */
public class BuildTest {
    public static void main(String[] args) {
        final Builder worker = new Worker();
        final Produce produce = worker.builderA("AA")
                .build();
        System.err.println(produce);
    }
}
