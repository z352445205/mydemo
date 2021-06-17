package com.example.demo.abstractdemo;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/25 20:42
 */
public class DemoTest {
    public static void main(String[] args) {
        //new Dog().doSome();

        new Cat() {
            @Override
            void play() {

            }
        }.play();


      AnimalInterFace cat = ()-> System.err.println("kkkkk");
      cat.a();
        System.err.println("===========");
        final Fish fish = new Fish();
        fish.doSome();
        fish.a();
        fish.b();
    }

}
