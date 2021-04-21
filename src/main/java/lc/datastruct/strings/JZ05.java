package lc.datastruct.strings;

import lc.DisplayUtil;

/**
 * @Desc 剑指 Offer 05. 替换空格
 * @Author h2linlin
 */
public class JZ05 {
    public static void main(String[] args) {
        // 输入
        String s = "leetcode Is Fun";
        DisplayUtil.display(s);

        // 计算
        String result = solution2(s);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：暴力法。
    // Java中String是不可变类型，所以不能像C++一样，原地扩展String长度。否则扩容后直接由后往前遍历最好。
    // 略。
    public static String solution1(String s){
        return null;
    }

    // 解法2：暴力法，从后往前。
    public static String solution2(String s){
        if (s == null || "".equals(s)) {
            return s;
        }

        // 统计空格数
        int blankNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                blankNum ++;
            }
        }

        // 构建数组
        char[] chars = new char[s.length() + blankNum*2];
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[flag] = '%';
                chars[flag + 1] = '2';
                chars[flag + 2] = '0';

                flag += 3;
            } else {
                chars[flag] = s.charAt(i);
                flag ++;
            }
        }

        return new String(chars);
    }
}
