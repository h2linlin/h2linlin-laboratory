package lc.codingcarl.dp;

/**
 * @Desc 746. 使用最小花费爬楼梯
 * @Author h2linlin
 */
public class N0746 {
    /**
     * 解法：动态规划法
     * 注意：cost[i]说的是到达i所需要的体力，而不是从i出发所需要的体力。到达顶层可以认为不消耗体力。
     */
    public int minCostClimbingStairs(int[] cost) {
        // 1.dp数组及下标含义：到达第n阶所需最小花费为dp[n]
        int[] dp = new int[cost.length];

        // 3.初始化
        dp[0] = cost[0];
        dp[1] = cost[1];

        // 4.遍历顺序：由前往后
        for (int i = 2; i < dp.length; i++) {
            // 2.递推公式
            dp[i] = Math.min(dp[i - 1] , dp[i - 2]) + cost[i];
        }

        return Math.min(dp[dp.length - 2], dp[dp.length - 1]);
        // 5.举例验证
    }
}
