package com.example.demo.abstractdemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 20:37
 */
public abstract class Cat extends Animal{
    @Override
    void eat() {
        System.err.println("cat eat");
    }

    @Override
    void drink() {
        System.err.println("cat drink");
    }
}
