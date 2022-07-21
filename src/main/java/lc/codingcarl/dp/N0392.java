package lc.codingcarl.dp;

public class N0392 {
    // 双指针法
    public boolean isSubsequence(String s, String t) {
        // 0.边界判断
        if (s == null || t == null) { return false; }
        if ("".equals(s)) { return true; }

        // 双指针
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (i == s.length() - 1) {
                    return true;
                }
                i++;
            }
        }

        return false;
    }

    // 动态规划法
    public boolean isSubsequence2(String s, String t) {
        // 0.边界判断
        if (s == null || t == null) { return false; }
        if ("".equals(s)) { return true; }

        // 判断s是否为t的子序列
        // s的长度为i-1。t的长度为j-1。手动在最前面加一个相等的字符，便于初始化。s的编号为1~(i-1)，t的编号为1~(j-1)
        // 1.含义：dp[i][j]：从s的0~i中选，从t的0~j中选，相等的字符串长度。

        // 2.公式：两种情况：末尾字符相同或不相同。下标为了方便初始化做了加1处理，所以要减1。
        // if (charS[i-1] == charT[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        // else if (charS[i-1] != charT[j-1]) dp[i][j] = dp[i][j-1];

        // 3.初始化：直接在最前面多定义一个字符。默认为不相同，即0。
        int sLen = s.length() + 1; // s的长度为i-1。下标为 1 - i-1
        int tLen = t.length() + 1; // t的长度为j-1。下标为 1 - j-1
        int[][] dp = new int[sLen][tLen];

        // 4.递推
        for (int i = 1; i < sLen; i++) {
            for (int j = 1; j < tLen; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }


        // 5.验证
        return dp[sLen-1][tLen-1] == s.length();
    }

    // 动态规划法: 复习
    // s：总序列。t：子序列。
    // TODO to be continue
    public boolean isSubsequence3(String s, String t) {
        // 1.dp[i][j]：s从0~i中选，t从0~j范围内选，两个相同的子序列的长度。

        // 2.公式
        //

        // 3.初始化

        // 4.递推

        return false;
    }
}
