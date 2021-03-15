package com.example.demo.juc.ThreadTestPage;

import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhengyn
 * @description
 * @create 2020/9/15 11:15
 */
class MyLockTest implements Runnable {
    public synchronized void get() {
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        //reentrantLock.lock();
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        //reentrantLock.unlock();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
    }

    public synchronized void set() {
        //reentrantLock.lock();
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
        //reentrantLock.unlock();
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }





}

public class ThreadTest implements Executor{
    public static void main(String[] args) {
        MyLockTest test = new MyLockTest();
        for (int i = 0; i < 10; i++) {
           new Thread(test,"thread-" + i).start();
        }
    }

    private ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void execute(Runnable command) {

    }
}