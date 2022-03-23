package lc.datastruct.dp;

public class N0188 {
    // 最多完成k次交易
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        /**
         * 1.含义：
         * dp[i][k]: 手里最大现金
         *   k等于0：不做操作
         *   k为奇数：第k次买入
         *   k为偶数：第k次卖出
         */

        /**
         * 2.公式：
         * Math.max(dp[i][0] ~ dp[i][2k + 1])
         * 买k次、卖k次，不操作。总共 2k + 1种情况
         */

        /**
         * 3.初始化
         */
        int len = prices.length;
        int kLen = 2*k + 1;
        int[][] dp = new int[len][kLen];
        for (int j = 1; j < kLen; j++) {
            // 奇数买入，偶数卖出。j为0时就是0。
            dp[0][j] = (j % 2 == 0) ? 0 : -prices[0];
        }

        /**
         * 4.递推
         */
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j < kLen; j++) {
                dp[i][j] = Math.max(
                        dp[i-1][j],
                        dp[i-1][j-1] + ((j % 2 == 0) ? prices[i] :  - prices[i]));
            }
        }

        /**
         * 5.返回
         */
        int max = 0;
        for (int j = 0; j < kLen; j++) {
            max = Math.max(max, dp[len-1][j]);
        }

        return max;
    }
}
