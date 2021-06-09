package lc.datastruct.dp;

/**
 * @Desc 63. 不同路径 II
 * @Author h2linlin
 */
public class N0063 {
    /**
     * 解法：动态规划法
     * 注意：初始化时，碰到一个障碍，它后面的路径数是全为0，而不是1。
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 1.dp数组：dp[0][0]到该点的路径数
        int[][] dp = new int[m][n];

        // 3.初始化
        for (int i = 0; i < m; i ++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        // 4.遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
