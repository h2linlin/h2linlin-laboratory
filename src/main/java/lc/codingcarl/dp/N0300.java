package lc.codingcarl.dp;

public class N0300 {
    // 动态规划法
    public int lengthOfLIS(int[] nums) {
        // 1.含义：dp[i]：从0-i个元素中选，包含i的，最长上升子序列长度

        // 2.公式：
        //   if (nums[i] > nums[j]) dp[i] = dp[j] + 1
        //   每一轮j都要对比，所以要再跟上一轮的缓存dp[j]+1对比下（即dp[i]）。所以最终公式为：
        //   if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1)

        // 3.初始化：
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        // 4.递推
        for (int i = 1; i < len; i++) {
            // 从0-j中选出在“nums[j] < nums[i]”的条件下，最大的dp[j]，再加1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 1;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, dp[i]);
        }

        // 5.返回检验

        return result;
    }

    // 二分查找法 待完成
    // tail[i]：长度为i的上升子序列中，最小的tail值。
    // 贪心法，这样就有最大的机会增加数组长度。
    // 算法：每次进行比较，严格大于则放到tail[i]数组最后，否则找到第一个大于的数进行替换（这一步就是贪心法）。最后取tail长度即可。
    // 证明：tail[]是严格递增的，可以用反证法证明。
    public int lengthOfLIS2(int[] nums) {
        return 0;
    }

}
