package lc.datastruct.dp;

/**
 * @Desc 509. 斐波那契数
 * @Author h2linlin
 */
public class N0509 {

    /**
     * 解法：dp，迭代法。
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }

        // 1.dp数组及下标含义
        int[] dp = new int[n + 1];

        // 3.初始化
        dp[0] = 0;
        dp[1] = 1;

        // 4.遍历顺序
        for (int i = 2; i <= n; i++) {
            // 2.递推公式
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 5.举例说明
        return dp[n];
    }

    /**
     * 解法2：dp，递归法。
     */
    public int fib(int n) {
        // 1.dp数组及下标含义
        if (n < 2) {
            return n;
        }
        // 3.初始化
        // 4.遍历顺序
        return fib(n - 2) + fib(n - 1);

        // 5.举例说明
    }
}
