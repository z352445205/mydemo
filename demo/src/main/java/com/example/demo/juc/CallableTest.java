package com.example.demo.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/8 9:25
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> aFutureTask = new FutureTask<>(()-> "Call");
        ThreadPool.threadPool.execute(aFutureTask);
        final String name = Thread.currentThread().getName();
        String a1 = aFutureTask.get();
        System.err.println(a1+name);
    }


}

class A  {
    public String call() {
        System.err.println("call打印");
        return "Call";
    }
}