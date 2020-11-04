package com.lpf.basic.class02;

/**
 * 求数组中的最大值，直接遍历复杂度为O(n)
 * 采用二分法递归则会降到O(log n)
 */
public class Code08_GetMax {

    //求arr中的最大值
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) { //如果l..r的范围上只有一个数，直接返回 base case
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int lMax = process(arr, l, mid);
        int rMax = process(arr, mid + 1, r);
        return Math.max(lMax, rMax);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(getMax(arr));
    }
}
