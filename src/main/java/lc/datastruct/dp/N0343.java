package lc.datastruct.dp;

/**
 * @Desc 343. 整数拆分
 * @Author h2linlin
 */
public class N0343 {
    /**
     * 解法：动态规划法
     * 令dp[i]表示整数i对应的最大乘积，那么dp[i]的值应是dp[j]*(i-j)的最大值（j属于[1,i-1]）。
     * 同时注意dp[j]对应的值是拆分了的，也就是说dp[i]至少是三个数的乘积。
     * 所以还应判断dp[i]是两个数拆分的情况，即j*(i-j)的值。
     * 取两种情况的最大值即可。
     */
    public int integerBreak(int n) {
        // 1.dp数组
        int[] dp = new int[n + 1];

        // 3.初始化
        dp[1] = 1;

        // 4.遍历
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }

        return dp[n];
    }

    /**
     * 解法2：贪心法。
     * 任何数，全部拆为3或4的乘积最大。
     */
    public int integerBreak2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

        int result = 1;

        while (n > 4) {
            n -= 3;
            result *= 3;
        }

        result *= n;

        return result;

    }

}
