package lc.datastruct.dp;

public class N0213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int a = robSub(nums, 0, nums.length - 2);
        int b = robSub(nums, 1, nums.length - 1);

        return Math.max(a, b);
    }

    // 长度至少为2
    private int robSub(int[] nums, int startIndex, int endIndex) {
        // 1.含义：从0 - i编号随便偷，最大值。

        // 2.公式：dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1])

        // 3.初始化：
        int[] dp = new int[nums.length];
        dp[startIndex] = nums[startIndex];
        dp[startIndex + 1] = Math.max(nums[startIndex], nums[startIndex + 1]);

        // 4.递推
        for (int i = startIndex + 2; i <= endIndex; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        // 5.检查
        return dp[endIndex];
    }
}
