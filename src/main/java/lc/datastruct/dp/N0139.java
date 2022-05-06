package lc.datastruct.dp;

import java.util.List;

public class N0139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 1.dp[j]：使用前i个字符串，可以拼出dp[j]。或者说，dp[j]可拆为n个编号为前i的字符。

        // 2.公式：dp[i]为true && dp[i ~ n]在words中，则dp[i+n] = true。i为s的第i个字符。

        // 3.初始化
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;   // 便于遍历

        // 4.递推
        // 外层：字符集
        A: for (int i = 1; i <= s.length(); i++) {
            if (!dp[i-1]) { continue A; }

            // 内层：匹配单词
            B: for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                // 已匹配字符集 + 当前单词长度 > 字符集总长度
                if (i-1 + word.length() > s.length()) { continue B;}
                // 开始匹配
                for (int k = 0; k < word.length(); k++) {
                    // 匹配失败
                    if (s.charAt(i-1 + k) != word.charAt(k)) { continue B; }
                }
                dp[i-1 + word.length()] = true;
            }
        }

        return dp[s.length()];
    }
}
