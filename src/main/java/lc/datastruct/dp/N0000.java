package lc.datastruct.dp;

import lc.DisplayUtil;

/**
 * @Desc 背包问题示例
 * @Author h2linlin
 */
public class N0000 {
    /**
     * 二维数组方式：
     * dp[i][j]：
     *  i：在编号为0-i的物品里面选
     *  j：背包容量
     *  dp[i][j]：此时的最大价值
     *
     *  递推到物品i时，分两种情况：
     *      1.不装物品i。（1）有足够的空间，但是性价比不高，不装。（2）没有足够的空间，也不装，因为i性价比不高。
     *      2.装物品i。  （1）有足够的空间，i性价比也高，装入。（2）没有足够的空间，但是i性价比高。那么置换腾出i的位置来，装入。
     *
     *  不管是4种情况的那种，最终就是两种情况，装和不装。
     *      1.装：需要给i留出空间，所以：当前最大价值 = 给i留空间后剩余空间的最大价值 + i的价值。dp[i][j] = dp[i-1][j-weight[i]] + value[i]
     *      2.不装：不需要给i留空间，也不需要增加i的价值。dp[i][j] = dp[i-1][j]
     *      3.以上两种取最大值即可。即 dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])
     */
    private static void test2WeiBagProblem() {
        // 物品重量
        int[] weight = {1, 3, 4};
        // 物品价值
        int[] value = {15, 20, 30};
        // 背包容量
        int bagWeight = 4;

        // 1.dp二维数组
        int[][] dp = new int[weight.length][bagWeight + 1];

        // 2.初始化
        // 2.1 背包容量为0时，总价值全部为0。无需初始化。
        // 2.2 只提供0号物品选择时。能装下时，总价值就是物品0的价值。不能装下时，总价值就是0。
        // 注意到初始化顺序是倒序，因为不能由前面的结果影响到后面的结果。
        for (int j = bagWeight; j >= weight[0]; j--) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        // 3.遍历。先容量方向，后物品方向
        for (int i = 1; i < weight.length; i++) {   // 物品
            for (int j = 1; j <= bagWeight; j++) {  // 背包容量
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 4.输出结果
        DisplayUtil.display(dp);
    }

    /**
     * 一维滚动数组方式，是对上述二维数组方式的简化。相当于把上一层的数据直接copy到本层，复用了空间，所以减少了一个维度。
     */
    private static void test1WeiBagProblem() {
        // 物品重量
        int[] weight = {1, 3, 4};
        // 物品价值
        int[] value = {15, 20, 30};
        // 背包容量
        int bagWeight = 4;

        // 1.dp数组
        int[] dp = new int[bagWeight + 1];

        // 2.初始化
        // 2.1 物品纬度方向初始化
        for (int j = 0; j < dp.length; j++) {
            dp[j] = 0;
        }
        // 2.2 容量纬度方向初始化，无需

        // 3.递推遍历
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight [i]] + value[i]);
            }
        }

        // 4.输出结果
        DisplayUtil.display(dp);
    }

    public static void main(String[] args) {
        test1WeiBagProblem();
    }

}
