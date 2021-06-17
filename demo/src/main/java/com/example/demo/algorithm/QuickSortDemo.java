package com.example.demo.algorithm;

import java.util.Arrays;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/20 15:07
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        final int[] ints = quickSort(new int[]{39, 28, 55, 87, 66, 3, 17, 38});
        System.err.println(Arrays.toString(ints));
    }

    public static int[]  quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);

        return arr;
    }
    public static void quickSort(int[] arr,int left,int right){
        int middle;
        if(left < right){
            middle = partition(arr,left,right);
            quickSort(arr,left,middle-1);
            quickSort(arr,middle+1,right);
        }
    }

    public static int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        while(left < right){
            while(left<right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left]<= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
