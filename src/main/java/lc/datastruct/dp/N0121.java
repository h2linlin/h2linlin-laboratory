package lc.datastruct.dp;

public class N0121 {
    public int maxProfit(int[] prices) {
        // 1.含义：dp[i][1] 表示第i天持有股票所得最多现金
        // 2.公式：
        //  不持有股票：dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
        //  持有股票：dp[i][1] = Math.max(dp[i-1][1], -prices[i])
        //  Math.max(dp[i][0], dp[i][1]);

        // 3.初始化
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0];

        // 4.递推
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[prices.length - 1][0];    // 最后卖掉股票才有钱
    }

    // 思路2：动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
}
