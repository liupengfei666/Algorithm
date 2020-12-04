package com.lpf.other;

/**
 * 动态规划练习
 * https://mp.weixin.qq.com/s/jp88-0B50T8Zph6UohCkTA
 */
public class DynamicPlanning {

    /**
     * 打家劫舍
     */
    public static int rob(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int[] dp = new int[num.length];
        dp[0] = num[0];
        //每次做数组判定时都需要做数组边界判定，防止越界
        if (num.length < 2) {
            return num[0];
        }
        dp[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < num.length; i++) {
            dp[i] = Math.max(num[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[num.length - 1];
    }

    /**
     * 最大子段和
     */
    public static int maxSubArray(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int[] dp = new int[num.length];
        dp[0] = num[0];
        int max = dp[0];
        for (int i = 1; i < num.length; i++) {
            dp[i] = Math.max(num[i] + dp[i - 1], num[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 找零钱
     */
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            if (coins[i] == amount) {
                return 1;
            } else {
                dp[coins[i]] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
