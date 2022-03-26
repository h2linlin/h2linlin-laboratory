package lc.datastruct.dp;

public class N0674 {
    public int findLengthOfLCIS(int[] nums) {
        // 1.含义：dp[i]：以nums[i]结尾的最长连续递增子序列的长度

        // 2.公式：
        // if (nums[i] > nums[i+1]) dp[i] = dp[i-1] + 1。

        // 3.初始化
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        // 4.递推
        int result = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]) dp[i] = dp[i-1] + 1;
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
