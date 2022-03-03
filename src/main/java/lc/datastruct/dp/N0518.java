package lc.datastruct.dp;

public class N0518 {
    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     *
     * 示例 1:
     *
     * 输入: amount = 5, coins = [1, 2, 5] 输出: 4 解释: 有四种方式可以凑成总金额: 5=5 5=2+2+1 5=2+1+1+1 5=1+1+1+1+1
     *
     * 示例 2: 输入: amount = 3, coins = [2] 输出: 0 解释: 只用面额2的硬币不能凑成总金额3。
     *
     * 示例 3: 输入: amount = 10, coins = [10] 输出: 1
     *
     * 注意，你可以假设：
     *
     * 0 <= amount (总金额) <= 5000
     * 1 <= coin (硬币面额) <= 5000
     * 硬币种类不超过 500 种
     * 结果符合 32 位符号整数
     */
    public int change(int amount, int[] coins) {
        // 1.含义：dp[j]，从编号为0-i中的银币中取，刚好能组成j金额的，最多方式数量

        // 2.公式：dp[j] = Math.max(dp[j], dp[j - value[i]] + value[i]);

        // 3.初始化
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 4.遍历
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
