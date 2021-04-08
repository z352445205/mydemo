package com.example.demo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/19 14:40
 */
public class CompletableFutureDemo {


    /*public static void main(String[] args) throws ExecutionException, InterruptedException {

        final CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(Thread.currentThread().getName() + "无返回值");
        },ThreadPool.threadPool);

        System.err.println("主线程执行");
        runAsync.get();
        ThreadPool.threadPool.shutdown();
    }*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.err.println(Thread.currentThread().getName() + "异步执行");
            final int i = 10 / 0;
            return 1024;
        });
        TimeUnit.SECONDS.sleep(2);
        System.err.println("main");
        System.out.println(supplyAsync.whenComplete((t, u) -> {
            System.err.println(Thread.currentThread().getName()+"=======");
            System.err.println("t" + t);
            System.err.println("u" + u);
        }).exceptionally((e) -> {
            System.err.println(e.getMessage());
            return 2;
        }).get());
    }
}
