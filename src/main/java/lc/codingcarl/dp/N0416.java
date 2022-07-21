package lc.codingcarl.dp;

/**
 * @Desc 416. 分割等和子集
 *   部分元素的值等于总和的一半时，即满足题解。
 * @Author h2linlin
 */
public class N0416 {
    public boolean canPartition(int[] nums) {
        // 0.计算目标值
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target % 2 != 0) {
            return false;
        }
        target = target / 2;

        // 1.dp数组：dp[j]，最接近j的元素和
        int[] dp = new int[target + 1];

        // 2.初始化
        // 全部初始化为0，省略。

        // 3.遍历
        // 必须是物品在外层，容量在内层。因为用滚动数组压缩了数组维度，dp数组本身就是代表容量，容量在外层则复用不到历史容量，相当于每个容量每次都只能放入1个物品。
        for (int i = 0; i < nums.length; i ++) {
            // 倒序遍历，否则会重复放入物品
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }
}
