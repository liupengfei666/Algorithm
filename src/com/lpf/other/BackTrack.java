package com.lpf.other;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法练习
 * https://mp.weixin.qq.com/s/8vwuEfdPkMfmv8BKc-ZyPw
 * date 2020-12-08
 */
public class BackTrack {

    static List<List<Integer>> res = new LinkedList<>();

    /**
     * 全排列问题
     * 输入一组不重复的数字，返回它们的全排列
     */
    public static List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * @param nums  选择列表：nums 中不存在于 track 的那些元素
     *              结束条件：nums 中的元素全都在 track 中出现
     * @param track 路径：记录在 track 中
     */
    private static void backtrack(int[] nums, LinkedList track) {
        //触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            //排除不合法的选择
            if (track.contains(num)) {
                continue;
            }
            //做选择
            track.add(num);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }

}
