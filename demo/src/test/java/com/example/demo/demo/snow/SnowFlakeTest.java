package com.example.demo.demo.snow;

import com.example.demo.juc.ThreadPool;
import com.example.demo.snow.SnowFlake;
import net.sf.jsqlparser.statement.select.KSQLWindow;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zhengyn
 * @description
 * @create 21/1/19 21:42
 */
class SnowFlakeTest {

    static volatile HashSet<Long> longs = new HashSet<>();

    static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final AtomicStampedReference<Integer> integerAtomicReference = new AtomicStampedReference<>(1,1);
        final CountDownLatch countDownLatch = new CountDownLatch(4);

        for (int i = 0; i < 8; i++) {
            ThreadPool.threadPool.execute(() -> {
                addId();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.err.println("集合数量："+longs.size());
        TimeUnit.MILLISECONDS.sleep(1000);
        System.err.println("集合数量："+longs.size());
        ThreadPool.threadPool.shutdown();
    }

    private static synchronized void addId() {
        for (int i = 0; i < 100; i++) {
            final long l = SnowFlake.nextId();
            if (longs.contains(l)) {
                System.err.println(l);
            }
            //System.err.println(++count);
            longs.add(l);
        }
    }

}
