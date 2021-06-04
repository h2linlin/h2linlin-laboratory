package lc.datastruct.backtracking;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 131. 分割回文串
 * @Author h2linlin
 */
public class N0131 {
    /**
     * 解法：回溯法
     * 注意string.substring(startIndex, endindex)是截取startindex 到 endIndex-1 的字符串。
     * string -> char[]：如果String不熟悉，可以转换为Array来执行
     *     str.toCharArray();
     */
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return results;
    }

    List<List<String>> results = new ArrayList<>();
    List<String> path = new ArrayList<>();

    private void backtracking(String s, int startIndex) {
        // 收集
        if (startIndex > s.length() - 1) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 处理
            String subStr = s.substring(startIndex, i + 1);
            if (isRe(subStr)) {
                path.add(subStr);
            } else {
                continue;
            }
            // 递归
            backtracking(s, i + 1);
            // 回溯
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断是否是回文串
     */
    private static boolean isRe(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }
}
