package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/15 17:27
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) throws InterruptedException {

        AtomicInteger a = new AtomicInteger(4);
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.err.println(Thread.currentThread().getName() + "完成");
        });
        for (int i = 0; i < 14; i++) {
            ThreadPool.threadPool.execute(() -> {
                try {
                    writer();
                    barrier.await(2000,TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(Thread.currentThread().getName());
                    barrier.reset();
                }
            });

        }
        TimeUnit.SECONDS.sleep(5);
        System.err.println("======");
        for (int i = 0; i < 6; i++) {
            ThreadPool.threadPool.execute(() -> {
                try {
                    writer();
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }

        ThreadPool.threadPool.shutdown();

    }

    static void writer() {
        final long l = new Random().nextInt(2000);
        System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据..." + l);
        try {
            TimeUnit.MILLISECONDS.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
    }
}
