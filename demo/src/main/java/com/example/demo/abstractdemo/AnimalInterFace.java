package com.example.demo.abstractdemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 20:48
 */
@FunctionalInterface
public interface AnimalInterFace {

    int CUP = Runtime.getRuntime().availableProcessors();

    void doSome();

    default void a() {
        System.err.println(CUP);
        doSome();
    }

    default void b(){
        System.err.println("father b");
    }
}
