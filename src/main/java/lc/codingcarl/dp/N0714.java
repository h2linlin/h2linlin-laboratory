package lc.codingcarl.dp;

public class N0714 {
    // 卖的时候收手续费
    public int maxProfit(int[] prices, int fee) {
        /**
         * 代码随想录是持有股票、不持有股票两个状态。
         * 这里两个状态再细分下，用4个状态试一下。
         *
         * 1.含义
         *  dp[i][0]：不持有股票，且昨天也不持有
         *  dp[i][1]：不持有股票，今天刚卖的
         *  dp[i][2]：持有股票，且昨天也持有
         *  dp[i][3]：持有股票，且今天刚买的
         *
         * 2.公式
         *  疑问：fee时买的时候扣减还是卖的时候扣减？这里是按卖的时候交手续费来结算
         *  dp[i][0] = dp[i-1][0];
         *  dp[i][1] = Math.max(dp[i-1][2], dp[i-1][3]) + prices[i] - fee;
         *  dp[i][2] = dp[i-1][2];
         *  dp[i][3] = Math.max(dp[i-1][0], dp[i-1][1]) - prices[i];
         *  最终取上述4个最大值
         *
         * 3.初始化
         */
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = -prices[0];

        // 4.递推
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][2], dp[i-1][3]) + prices[i] - fee;
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][3]);
            dp[i][3] = Math.max(dp[i-1][0], dp[i-1][1]) - prices[i];
        }

        // 5.验证
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

    // 买的时候收手续费
    public int maxProfit2(int[] prices, int fee) {
        /**
         * 代码随想录是持有股票、不持有股票两个状态。
         * 这里两个状态再细分下，用4个状态试一下。
         *
         * 1.含义
         *  dp[i][0]：不持有股票，且昨天也不持有
         *  dp[i][1]：不持有股票，今天刚卖的
         *  dp[i][2]：持有股票，且昨天也持有
         *  dp[i][3]：持有股票，且今天刚买的
         *
         * 2.公式
         *  疑问：fee时买的时候扣减还是卖的时候扣减？这里是按卖的时候交手续费来结算
         *  dp[i][0] = dp[i-1][0];
         *  dp[i][1] = Math.max(dp[i-1][2], dp[i-1][3]) + prices[i];
         *  dp[i][2] = dp[i-1][2];
         *  dp[i][3] = Math.max(dp[i-1][0], dp[i-1][1]) - prices[i] - fee;
         *  最终取上述4个最大值
         *
         * 3.初始化
         */
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0] - fee;;
        dp[0][3] = -prices[0] - fee;;

        // 4.递推
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][2], dp[i-1][3]) + prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][3]);
            dp[i][3] = Math.max(dp[i-1][0], dp[i-1][1]) - prices[i] - fee;
        }

        // 5.验证
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

}
