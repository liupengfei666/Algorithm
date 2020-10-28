package com.lpf.basic.class01;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Code01_SelectionSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~N-1
        //1~N-1
        //2~N-1...
        for (int i = 0; i < arr.length; i++) {
            //最小值在哪个位置上
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    //交换
    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    //for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    //for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //Math.random()    [0, 1)
        //Math.random() * N [0, N)
        //(int)Math.random() * N [0, N-1]
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    //for test
    public static int[] copyArr(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArr(arr1);
            selectSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Good" : "Fucking");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }
}
