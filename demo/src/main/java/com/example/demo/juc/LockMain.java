package com.example.demo.juc;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/4 21:17
 */
public class LockMain {
    public static void main(String[] args) {
        final LockTest lockTest = new LockTest();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lockTest.decrease();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lockTest.increase();
            }
        }, "b").start();

    }
}
