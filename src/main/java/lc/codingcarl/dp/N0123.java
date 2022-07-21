package lc.codingcarl.dp;

public class N0123 {
    // 最多操作两次
    public int maxProfit(int[] prices) {
        /**
         *  1.含义：
         * 没有操作：   dp[i][0]
         * 第一次买入后：dp[i][1]
         * 第一次卖出后：dp[i][2]
         * 第二次买入后：dp[i][3]
         * 第二次卖出后：dp[i][4]
         */

        /**
         * 2.公式
         * dp[i][0] = dp[i - 1][0]
         * dp[i][1] = Math.max(dp[i-1][1], -prices[i])
         * dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i])
         * dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i])
         * dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i])
         * Math.max(dp[i][0], dp[i][1], dp[i][2], dp[i][3], dp[i][4])
         */

        /**
         * 3.初始化
         */
        int length = prices.length;
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];  // 注意，这里也是卖出的情况。
        dp[0][4] = 0;

        /**
         * 4.递推
         */
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);   // 这里- prices[i] 是个人理解。可能跟题解不太一样
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }

        int max = 0;
        for (int i = 0; i < 5; i++) {
            max = Math.max(max, dp[length - 1][i]);
        }

        return max;
    }
}