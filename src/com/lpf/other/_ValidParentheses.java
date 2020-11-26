package com.lpf.other;

import java.util.Stack;

/**
 * 有效括号
 */
public class _ValidParentheses {

    /**
     * 1、给定一个只包括 '('，')'的字符串，判断字符串是否有效。注：空字符串属于有效字符串
     * 用栈实现
     *
     * 示例 1:
     * 输入: "(())"
     * 输出: true
     *
     *  实例 2：
     *  输入: "())("
     * 输出: false
     */
    public static boolean isValid(String s){
        if(s == null || s.length() < 1)
            return true;
        int n = s.length();// 字符串长度
        // 创建一个栈来装字符
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for(int i = 0; i < n; i++){
            // 获取字符串的第 i 个字符
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        // 判断是否为空
        if(stack.isEmpty())
            return true;

        return false;
    }

    /**
     * 优化 不适用额外空间
     */
    public static boolean isValid2(String s){
        if(s == null || s.length() < 1)
            return true;
        int n = s.length();// 字符串长度
        // 用来记录遇到的 "(" 的个数
        int sum = 0;
        // 遍历字符串
        for(int i = 0; i < n; i++){
            // 获取字符串的第 i 个字符
            char c = s.charAt(i);
            if(c == '('){
                sum++;
            }else{
                if(sum == 0)
                    return false;
                else
                    sum--;
            }
        }
        return sum == 0;
    }

    /**
     * 2、 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * 暴力解法，一般想不到别的方法才会用
     *
     * 示例 1:
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     *
     * 示例 2:
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //下标入栈
                stack.push(i);
            } else {
                // 出栈
                stack.pop();
                // 看栈顶是否为空，为空的话就不能作差了
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    // i - 栈顶，获得档期有效括号长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 优化
     */
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, max = 0;
        // 从左到右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        // 从右到左
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }

}
