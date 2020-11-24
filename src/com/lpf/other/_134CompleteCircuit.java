package com.lpf.other;

/**
 * 加油站
 */
public class _134CompleteCircuit {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //暴力
//        int len = gas.length;
//        for(int i = 0; i < len; i++) {
//            int cur = gas[i];
//            int step = i;
//            while(cur - cost[step] >= 0) {
//                cur = cur - cost[step] + gas[(step + 1) % len];
//                step = (step + 1) % len;
//                if(step == i) {
//                    return i;
//                }
//            }
//        }
//        return -1;

        //优化
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
