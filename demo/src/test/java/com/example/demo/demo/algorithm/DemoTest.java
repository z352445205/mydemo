package com.example.demo.demo.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/29 17:06
 */
public class DemoTest {

    @Test
    void test1() {
        long startTime = System.currentTimeMillis();
        int[] ints = IntStream.range(1, 1001).toArray();

        int i, j;//定义i,j
        for (i = 0, j = 1; i < ints.length; ) {//i控制行,j控制列,省略表达式3;
            System.err.print(j + "*" + ints[i] + "=" + ints[i] * j + "\t");//先打印
            j++;
            if (j > ints[i]) {//当j>i的时候,说明改换行了,i++,并且j也应该重置
                System.err.println("\n");
                i = ints[i];
                j = 1;
            }
        }
        long endTime = System.currentTimeMillis();
        System.err.println("一次运行时间" + (endTime - startTime));
    }

    @Test
    void test2() {
        long startTime = System.currentTimeMillis();
        int[] ints = IntStream.range(1, 1001).toArray();
        for (int i = 0; i < ints.length; i = ints[i]) {
            for (int j = 1; j <= ints[i]; j++) {
                System.out.print(j + "*" + ints[i] + "=" + ints[i] * j + "\t");
            }
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        System.err.println("二次运行时间" + (endTime - startTime));
    }


    @Test
    public void test3() {
         int[] array = IntStream.of(2,1,3,4,5,6,7,8).toArray();
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                    flag = true;
                }
                count++;
            }
            if (!flag) {
                break;
            }

        }
        System.err.println(Arrays.toString(array));
        final List collect = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.err.println(collect);
        System.err.println(count);
    }


    @Test
    public void test4() {
        int[] array = IntStream.of(2,1,3,4,5,6,7,8).toArray();
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                }
                count++;
            }
        }
        System.err.println(Arrays.toString(array));
        final List collect = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.err.println(collect);
        System.err.println(count);
    }

    @Test
    public  void test5(){
        int[] array = IntStream.of(2,1,3,4,5,6,7,8).toArray();
        int temp;
        int count =0;
        int tempIndex=0;//标记位置
        int sortBorder = array.length-1;
        for (int i = 0; i < array.length-1; i++) {
            boolean flag = true;
            //执行的每一趟，内存循环都要将相邻的元素进行比较。但是许多后边的元素可以第一次已经有序了
            for (int j = 0; j < sortBorder; j++) {
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=false;
                    tempIndex=j;
                }
                count++;
            }
            sortBorder=tempIndex;
            if(flag){
                break;
            }

        }
        System.out.println(Arrays.toString(array));
        System.err.println(count);
    }

    @Test
    public void test(){
        byte a = '1';
        System.err.println(a);
    }

}
