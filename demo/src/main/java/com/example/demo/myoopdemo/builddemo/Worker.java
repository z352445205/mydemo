package com.example.demo.myoopdemo.builddemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 21:27
 */
public class Worker extends Builder{

    private final Produce produce;

    public Worker() {
        this.produce = new Produce();
    }

    @Override
    Builder builderA(String msg) {
        produce.setA(msg);
        return this;
    }

    @Override
    Builder builderB(String msg) {
        produce.setB(msg);
        return this;
    }

    @Override
    Builder builderC(String msg) {
        produce.setC(msg);
        return this;
    }

    @Override
    Builder builderD(String msg) {
        produce.setD(msg);
        return this;
    }


    @Override
    Produce build() {
        return produce;
    }
}
