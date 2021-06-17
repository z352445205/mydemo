package com.example.demo.demo.numeral;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/21 21:49
 */
public class demo {

    public static void main(String[] args) {
        //1、a+=b 和 a=a+b
        short a = 1;
        int b = 54;
        //a = a+b;
        //2、Int 和Integer 比较注意  考虑IntegerCache
        Integer aaa = 127;
        Integer aa = 127;
        System.err.println(aaa.equals(aa));
        System.err.println(aaa == aa);

    }
}
