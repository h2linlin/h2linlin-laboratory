package lc.datastruct.dp;

/**
 * @Desc 70. 爬楼梯
 * @Author h2linlin
 */
public class N0070 {
    /**
     * 解法1：回溯法。
     * 解法是正确的，但是leetcode在输入到44时会超时。时间复杂度是O(2^n)，太高了。
     */
    public int climbStairs1(int n) {
        allStairs = n;
        currentStairs = 0;
        methods = 0;

        backtracking(n);

        return methods;
    }

    int allStairs;
    int currentStairs;
    int methods;

    private void backtracking(int add) {
        // 收集结果
        if (currentStairs > allStairs) {
            return;
        }
        if (currentStairs == allStairs) {
            methods++;
            return;
        }

        for (int i = 1; i <= 2; i++) {
            // 处理
            currentStairs += i;
            // 递归
            backtracking(i);
            // 回溯
            currentStairs -= i;
        }
    }

    /**
     * 解法2：动态规划法。
     * 回溯是穷举，解法没问题，但时间复杂度为O(2^n)，会超时。
     * 所以要用动态规划法，每一步基于当前情况，推断最优的选择。以下解法时间复杂度为O(n)
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        // 1.确定dp数组，及其下标含义
        // 第n阶楼梯，有stairMethod[n]种解法。
        // dp数组的规模可以做空间复杂度优化。其实存最近的三个台阶的值就够了。这里优化略。
        int[] stairMethod = new int[n + 1];

        // 3.初始化
        stairMethod[1] = 1;
        stairMethod[2] = 2;

        // 4.遍历顺序：由前向后
        for (int i = 3; i <= n; i++) {
            // 2.递推公式
            stairMethod[i] = stairMethod[i - 1] + stairMethod[i - 2];
        }

        return stairMethod[n];
        // 5.举例对比
    }

}
