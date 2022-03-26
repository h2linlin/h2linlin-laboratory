package lc.datastruct.dp;

public class N1035 {
    // 本质上就是求最长公共子序列
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 0.边界条件判断

        // 1.含义：dp[i][j]：从nums1的0-i中选，从nums2的0-j中选，最长的公共子序列长度。

        // 2.公式：
        // if (nums1[i] == nums1[j]) dp[i][j] = dp[i-1][j-1] + 1
        // else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])

        // 3.初始化。在每个字符串头添加一个特殊符号，便于初始化处理。这样初始化就是1。
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];

        // 4.递推
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    // 因为第一个位置已经被手动填充了，所以整体比nums的下标多1
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[len1][len2];
    }
}
