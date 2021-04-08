package com.example.demo.juc;

import org.springframework.boot.web.servlet.server.Session;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/4 21:05
 */
public class LockTest {
    Integer num = 0;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();


    public void increase() {
        /*AbstractQueuedSynchronizer*/
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num++;
            System.err.println(Thread.currentThread().getName() + "--->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrease() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.err.println(Thread.currentThread().getName() + "--->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
