package lc.datastruct.dp;

public class N0053 {
    public int maxSubArray(int[] nums) {
        // 0.边界判断

        // 1.含义：dp[i]：以nums[i]结尾的，最大连续子数组之和

        // 2.公式：
        // dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);

        // 3.初始化
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // 4.递推
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
