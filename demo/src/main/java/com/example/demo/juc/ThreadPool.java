package com.example.demo.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/8 9:45
 */
public class ThreadPool {

    /**
     * 获取当前系统的CPU 数目
     */
    static int cpuNums = Runtime.getRuntime().availableProcessors();
    /**
     * 线程池核心池的大小
     */
    private static int corePoolSize = 10;
    /**
     * 线程池的最大线程数
     */
    private static final int MAXIMUM_POOL_SIZE = cpuNums * 2;

    public static ExecutorService threadPool;

    static {
        System.out.println("创建线程数:" + corePoolSize + ",最大线程数:" + MAXIMUM_POOL_SIZE);
        //建立10个核心线程，线程请求个数超过20，则进入队列等待
        ///final ExecutorService executorService = Executors.newFixedThreadPool(10);
        threadPool = new ThreadPoolExecutor(corePoolSize, MAXIMUM_POOL_SIZE, 0L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), new ThreadFactoryBuilder().setNameFormat("PROS-%d").build());
    }
}
