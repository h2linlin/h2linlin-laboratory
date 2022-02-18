package lc.datastruct.dp;

/**
 * @Desc 62. 不同路径
 * @Author h2linlin
 */
public class N0062 {
    /**
     * 解法：动态规划法。
     * 回溯法，即DFS，时间复杂度太高，会超时。
     */
    public int uniquePaths(int m, int n) {
        if (n < 1) {
            return 1;
        }

        // 1.dp数组：从0,0到该点的所有路径数
        int[][] dp = new int[m][n];

        // 3.初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 4.遍历顺序
        for (int i = 1; i < m; i++) {
            // 2.递推公式
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 一维数组写法
     */
    public int uniquePaths2(int m, int n) {
        // 1.dp数组含义：机器人到该点的路径总数

        // 2.递推公式：dp[n] = dp[n-1] + dp[n];

        // 3.初始化
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // 4.遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];

        // 5.举例验证
    }
}
