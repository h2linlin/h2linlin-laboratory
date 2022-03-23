package lc.datastruct.dp;

public class N0309 {
    // 代码随想录的解法不好理解。参考了评论里的另一个题解。
    // 只关注卖出状态。
    public int maxProfit(int[] prices) {
        /**
         * 1.含义
         * dp[i][0]：不持股，且不是今天卖的
         * dp[i][1]：不持股，且是今天卖的
         * dp[i][2]：持股，且是今天买的
         * dp[i][3]：持股，且不是今天买的
         *
         * 2.公式
         * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
         * dp[i][1] = Math.max(dp[i-1][2], dp[i-1][3]) + prices[i];
         * dp[i][2] = dp[i-1][0] - prices[i];
         * dp[i][3] = Math.max(dp[i-1][2], dp[i-1][3])
         * 最终结果，取以上四个最大者
         *
         * 3.初始化
         */
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][2], dp[i-1][3]) + prices[i];
            dp[i][2] = dp[i-1][0] - prices[i];
            dp[i][3] = Math.max(dp[i-1][2], dp[i-1][3]);
        }

        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
}
