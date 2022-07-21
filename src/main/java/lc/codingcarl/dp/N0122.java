package lc.codingcarl.dp;

public class N0122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        // 1.含义：
        // dp[i][0]：第i天不持有股票，手边的最大现金。
        // dp[i][0]：第i天持有股票，手边的最大现金。

        // 2.公式：
        // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
        // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
        // Math.max(dp[i][0], dp[i][1]);

        // 3.初始化
        int[][]  dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0];

        // 4.推导
        for (int i = 1; i < prices.length; i++) {
             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
             dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
