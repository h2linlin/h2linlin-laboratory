package lc.codingcarl.dp;

public class N0198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) { return nums[0];}

        // 1.dp[i]：在0-i间选择盗窃，所能获取的最高金额。
        // 2.公式：dp[i] = Math.max((dp[i-2] + nums[i]), dp[i-1])
        // 3.初始化
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 4.遍历
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max((dp[i-2] + nums[i]), dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}
