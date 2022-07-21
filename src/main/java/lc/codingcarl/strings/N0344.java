package lc.codingcarl.strings;

import lc.DisplayUtil;

/**
 * @Desc 344. 反转字符串
 * @Author h2linlin
 */
public class N0344 {
    public static void main(String[] args) {
        // 输入
        String in = "leetcode is fun";
        char[] s = in.toCharArray();
        DisplayUtil.display(in);

        // 计算
        solution1(s);

        // 输出
        DisplayUtil.display(new String(s));
    }

    // 解法1：双指针
    public static void solution1(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }

        int p1 = 0;
        int p2 = s.length - 1;

        char temp;
        while (p1 < p2) {
           /* temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;*/

            // 用位运算交换两个数值，更优雅
            s[p1] ^= s[p2];
            s[p2] ^= s[p1];
            s[p1] ^= s[p2];

            p1++;
            p2--;
        }
    }
}
