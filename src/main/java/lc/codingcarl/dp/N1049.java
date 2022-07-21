package lc.codingcarl.dp;

import java.util.Arrays;

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

    // 第2次写。一维数组
    public int lastStoneWeightII2(int[] stones) {
        // 1.含义：dp[j]：当前背包容量，所能达到的最大重量

        // 2.递推公式：dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i])

        // 3.初始化
        // 3.1
        int weightSum = Arrays.stream(stones).sum();
        int target = weightSum >> 1;
        int[] dp = new int[target + 1];

        // 3.2 初始化第一行，这一步可以合并到后面第4步
        for (int j = target; j >= stones[0]; j--) {
            dp[j] = stones[0];
        }

        // 4.递推
        for (int i = 1; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                // 1.可能能放进stone[i]的情况
                dp[j] = Math.max(dp[j], dp[j - stones[i] + stones[i]]);
                // 2.一定不能放进stone[i]的情况，保持原值，不做操作
            }
        }

        // 5.检验结果
        return weightSum - dp[target]*2;
    }
}
