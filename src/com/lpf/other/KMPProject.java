package com.lpf.other;

/**
 * KMP算法练习
 * https://mp.weixin.qq.com/s/GVrhrgwgtu5Ot8QDpkfXVA
 * date: 2020-12-07
 */
public class KMPProject {

    /**
     * 暴力
     * @param pat 表示模式串，长度为M
     * @param txt 表示文本串，长度为N
     * @return 在txt中查找子串pat，如果存在，返回这个子串的起始索引，否则返回 -1
     */
    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i < N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    break;
                }
            }
            //pat 全都匹配了
            if (j == M) return i;
        }
        return -1;
    }

    public class KMP {
        private int[][] dp;
        private String pat;

        public KMP(String pat) {
            this.pat = pat;
            int M = pat.length();
            // dp[状态][字符] = 下个状态
            dp = new int[M][256];
            // base case
            dp[0][pat.charAt(0)] = 1;
            // 影子状态 X 初始为 0
            int X = 0;
            // 构建状态转移图（稍改的更紧凑了）
            for (int j = 1; j < M; j++) {
                for (int c = 0; c < 256; c++)
                    dp[j][c] = dp[X][c];
                dp[j][pat.charAt(j)] = j + 1;
                // 更新影子状态
                X = dp[X][pat.charAt(j)];
            }
        }

        public int search(String txt) {
            int M = pat.length();
            int N = txt.length();
            // pat 的初始态为 0
            int j = 0;
            for (int i = 0; i < N; i++) {
                // 计算 pat 的下一个状态
                j = dp[j][txt.charAt(i)];
                // 到达终止态，返回结果
                if (j == M) return i - M + 1;
            }
            // 没到达终止态，匹配失败
            return -1;
        }
    }
}
