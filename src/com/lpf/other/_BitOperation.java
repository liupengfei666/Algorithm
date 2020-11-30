package com.lpf.other;

/**
 * 位运算
 * https://mp.weixin.qq.com/s?__biz=Mzg2NzA4MTkxNQ==&mid=2247485441&idx=1&sn=2dd6e5e4b34bab5127ef5462bf5a90a6&scene=21#wechat_redirect
 */
public class _BitOperation {

    /**
     * 1、判断奇偶数
     */
    private void judgeOddEvenNumber(int num) {
        //一般
        if (num % 2 == 1) {
            System.out.println("奇数");
        }
        //位运算
        if ((num & 1) == 1) {
            System.out.println("奇数");
        }
    }

    /**
     * 2、交换两个数
     */
    private void swipeNumber(int x, int y) {
        //一般
        int tmp = x;
        x = y;
        y = tmp;
        System.out.println("一般x= " + x + " y= " + y);
        //位运算
        x = x ^ y;   // （1）
        y = x ^ y;   // （2）
        x = x ^ y;   // （3）
        System.out.println("位运算x= " + x + " y= " + y);
    }

    /**
     * 3、找出没有重复的数
     */
    private int findNumber(int[] arr) {
        //一般
        //哈希表存储，然后遍历

        //位运算
        int tmp = arr[0];
        for(int i = 1;i < arr.length; i++){
            tmp = tmp ^ arr[i];
        }
        return tmp;
    }

    /**
     * 4、m的n次方
     */
    private int pow(int m, int n) {
        //一般
//        int tmp = 1;
//        for(int i = 1; i <= n; i++) {
//            tmp = tmp * m;
//        }
//        return tmp;
        //位运算
        int sum = 1;
        int tmp = m;
        while(n != 0){
            if((n & 1) == 1){
                sum *= tmp;
            }
            tmp *= tmp;
            n = n >> 1;
        }

        return sum;
    }

    /**
     * 5、找出不大于N的最大的2的幂指数
     */
    private int findN(int n) {
        //一般
//        int sum = 1;
//        while(true){
//            if(sum * 2 > n){
//                return sum;
//            }
//            sum = sum * 2;
//        }
        //位运算
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8; // 整型一般是 32 位，上面我是假设 8 位。
        return (n + 1) >> 1;
    }
}
