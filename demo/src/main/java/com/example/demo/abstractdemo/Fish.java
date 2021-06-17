package com.example.demo.abstractdemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 21:06
 */
public class Fish implements AnimalInterFace{
    @Override
    public void doSome() {
        System.err.println("fish do");
    }

    @Override
    public void a() {
        AnimalInterFace.super.a();
        System.err.println("fish a");
    }
}
