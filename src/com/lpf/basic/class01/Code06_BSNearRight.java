package com.lpf.basic.class01;

import java.util.Arrays;

/**
 * 在排序数组中，找满足<=value的最右边的值
 */
public class Code06_BSNearRight {

    public static int nearestRight(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
                index = mid;
            }
        }
        return index;
    }

    //for test
    public static int test(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int times = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < times; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (nearestRight(arr, value) != test(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestRight(arr, value));
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Good Work" : "Fucking");
    }
}
