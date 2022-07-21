package lc.codingcarl.dp;

public class N1143 {
    public static void main(String[] args) {
        System.out.println(new N1143().longestCommonSubsequence("xaxx","a"));
    }
    // 解法1。写得有点啰嗦。
    public int longestCommonSubsequence(String text1, String text2) {
        // 0.边界条件判断。略。
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        // 1.含义：dp[i][j]：从0-i的txt1中选，0-j的txt2中选，所能达到的最大公共子序列长度

        // 2.公式：if (txt1[i] == txt2[j]) {dp[i][j] = dp[i-1][j-1]+1; } else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);

        // 3.初始化
        int len1 = c1.length;
        int len2 = c2.length;
        int[][] dp = new int[len1][len2];
        int result = 0;

        for (int j = 0; j < len2; j++) {if (c1[0] == c2[j]) {dp[0][j] = 1; result = 1;} else if (j > 0) dp[0][j] =  dp[0][j - 1];}
        for (int i = 0; i < len1; i++) {if (c1[i] == c2[0]) {dp[i][0] = 1; result = 1;} else if (i > 0) dp[i][0] =  dp[i - 1][0];}

        // 4.递推
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        // 5.返回
        return result;
    }

    // 解法2。稍微优化了解法1的写法。逻辑是一样的。定义字符串为0 ~ i-1的长度
    // 把1当作0开始遍历，定义字符串长度为i-1，相当于统一在字符串前面加了个都不相等的字符。从而省去了初始化过程。
    public int longestCommonSubsequence2(String text1, String text2) {
        // 0.边界条件判断。略。
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        // 1.含义：dp[i][j]：从0-i的txt1中选，0-j的txt2中选，所能达到的最大公共子序列长度

        // 2.公式：if (txt1[i] == txt2[j]) {dp[i][j] = dp[i-1][j-1]+1; } else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);

        // 3.初始化
        int len1 = c1.length;
        int len2 = c2.length;
        int[][] dp = new int[len1+1][len2+1];

        // 4.递推
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        // 5.返回
        return dp[len1][len2];
    }

}
