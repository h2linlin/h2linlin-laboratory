package lc.datastruct.dp;

import java.util.Arrays;

public class N0279 {
    /**
     *给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     *
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     */
    public int numSquares(int n) {
        // 1.含义：dp[j]：从编号为0-i中选，和为j的，最少完全平方数数量。
        // 2.公式：dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
        // 3.初始化
        int[] dp = new int[n + 1];
        int max = n + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;

        // 4.遍历
        for (int i = 1; i*i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
            }
        }

        return dp[n] == max ? 0 : dp[n];
    }


}
