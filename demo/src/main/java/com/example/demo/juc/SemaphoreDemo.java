package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/15 17:34
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 12; i++) {
            ThreadPool.threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                worker();
                semaphore.release();

            });
        }
        ThreadPool.threadPool.shutdown();
    }


    public static void worker() {
        final ThreadLocalRandom current = ThreadLocalRandom.current();

        current.nextInt(2000);
        try {
            final long i = new Random().nextInt(2000);
            System.out.println("工人" + Thread.currentThread().getName() + "占用一个机器在生产..."+i);
            TimeUnit.MILLISECONDS.sleep(i);
            System.out.println("工人" + Thread.currentThread().getName() + "释放出机器");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
