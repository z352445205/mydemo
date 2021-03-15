package com.example.demo.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/5 15:22
 */
public class ReadWriteLockTest {


    public static void main(String[] args) {

        final TestRw testRw = new TestRw();
        int testNum = 100;
       /* final ImmutableList<Object> of = ImmutableList.of("1");
        of.add("2");*/
        for (int i = 0; i < testNum; i++) {
            final int temp = i;
            ThreadPool.threadPool.execute(() -> testRw.write(temp));
        }
        for (int i = 0; i < testNum; i++) {
            final int temp = i;
            ThreadPool.threadPool.execute(() -> testRw.read(temp));
        }
    }
}

class TestRw {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    final ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public void read(int i) {

        readLock.lock();
        try {
            System.err.println("读取开始----" + i);
            concurrentHashMap.get(i);
            System.err.println("Read----" + i);
        } finally {
            readLock.unlock();
        }
    }

    public void write(int i) {
        writeLock.lock();
        try {
            System.err.println("写入开始====" + i);
            concurrentHashMap.put(i, i);
            System.err.println("write====" + i);
        } finally {
            writeLock.unlock();
        }
    }
}
