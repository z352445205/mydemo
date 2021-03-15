package com.example.demo.stream.lambda;

/**
 * @author Zhengyn
 * @description
 * @create 20/12/21 20:13
 */
public class LambdaTest {

    public static void main(String[] args) {

        /*String a= "hello";
        String b= "world";
        String c= "java";

        showLog(12,()-> a+b+c);*/

        new Thread(()->{
            System.err.println(Thread.currentThread().getName());
        }).start();


    }

    public static void showLog(Integer dd,ApendString apendString){
        if (dd==1){
            System.err.println("不成立不打印");
            System.err.println(apendString.doAppend());
        }
    }
}
