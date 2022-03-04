package lc.datastruct.dp;

public class N0322 {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    public int coinChange(int[] coins, int amount) {
        // 1.含义：dp[j]：可凑成j的，硬币个数。

        // 2.公式：dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1)

        // 3.初始化：
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        // 3.1 其他值初始化为最大值，否则会覆盖处理过的dp[j]。这一步容易漏掉
        for (int i = 0 ; i < dp.length; i ++) {
            dp[i] = max;
        }
        dp[0] = 0;

        // 4.递推
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }

        // 5.检验
        return dp[amount] == max ? -1 : dp[amount];
    }
}
