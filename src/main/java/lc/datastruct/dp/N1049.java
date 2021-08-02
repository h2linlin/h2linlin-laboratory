package lc.datastruct.dp;

/**
 * @Desc 1049. 最后一块石头的重量 II
 *   本质上就是怎样把石头分成相近质量的两堆。和N0416可以说是同一题。
 * @Author h2linlin
 */
public class N1049 {
    public int lastStoneWeightII(int[] stones) {
        // 0.计算目标质量
        int sum = 0;
        int target = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        target = sum / 2;

        // 1.dp数组：能装满容量i的最大值
        int[] dp = new int[target + 1];

        // 2.初始化
        // 全部为0。略。

        // 3.遍历
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] - dp[target];
    }
}
