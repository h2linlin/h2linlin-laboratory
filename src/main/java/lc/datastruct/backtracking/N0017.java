package lc.datastruct.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc 17. 电话号码的字母组合
 * @Author h2linlin
 */
public class N0017 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }

        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        bachtracking(digits, 0);
        return results;
    }

    Map<String, String> map = new HashMap<>();
    List<String> results = new ArrayList<>();
    StringBuffer path = new StringBuffer();

    // index：遍历到第几个数字了
    private void bachtracking(String digits, int index) {
        if (path.length() == digits.length()) {
            String result = new String(path);
            results.add(result);
            return;
        }

        String numStr = map.get(digits.charAt(index) + "");

        for (int i = 0; i < numStr.length(); i++) {
            // 处理
            path.append(numStr.charAt(i));
            // 递归
            bachtracking(digits, index + 1);
            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
    }
}
