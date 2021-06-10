package lc.datastruct.dp;

/**
 * @Desc 96. 不同的二叉搜索树
 * @Author h2linlin
 */
public class N0096 {

    /**
     * 解法：动态规划法
     */
    public int numTrees(int n) {
        // 1.dp数组
        int[] dp = new int[n + 1];

        // 3.初始化
        dp[0] = 1;

        // 4.遍历
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 递推公式
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
