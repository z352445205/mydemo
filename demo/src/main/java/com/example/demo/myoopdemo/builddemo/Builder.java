package com.example.demo.myoopdemo.builddemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 21:24
 */
public abstract class Builder {

    abstract Builder builderA(String msg);

    abstract Builder builderB(String msg);

    abstract Builder builderC(String msg);

    abstract Builder builderD(String msg);

    abstract Produce build();
}
