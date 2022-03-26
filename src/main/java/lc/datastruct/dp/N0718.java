package lc.datastruct.dp;

public class N0718 {
    // 代码随想录讲的不是太清楚。
    // 之所以取dp[i-1][j-1]+1，是因为bi
    public int findLength(int[] nums1, int[] nums2) {
        // 0.边界判断

        // 1.含义：dp[i][j]：从nums1的0-i中选，nums2的0-j中选，最大的公共子数组长度。

        // 2.公式：dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])

        // 3.初始化：
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1][len2];

        int result = 0;
        for (int j = 0; j < len2; j++) {
            if (nums1[0] == nums2[j]) { dp[0][j] = 1; result = 1;}
        }

        for (int i = 0; i < len1; i++) {
            if (nums2[0] == nums1[i]) { dp[i][0] = 1; result = 1;}
        }

        // 4.递推
        for (int i = 1; i < len1; i++) {
           for (int j = 1; j < len2; j++) {
               if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
               }
               result = Math.max(result, dp[i][j]);
           }
        }

        return result;
    }
}
