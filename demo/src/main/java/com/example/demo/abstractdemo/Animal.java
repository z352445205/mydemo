package com.example.demo.abstractdemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 20:36
 */
public abstract class Animal {


    void doSome(){
        System.err.println("doSome");
        play();
    };

    abstract void eat();

    abstract void drink();

    abstract void  play();

}
