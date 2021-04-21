package lc.datastruct.strings;

import lc.DisplayUtil;

/**
 * @Desc 剑指 Offer 58 - II. 左旋转字符串
 * @Author h2linlin
 */
public class JZ58B {
    public static void main(String[] args) {
        // 输入
        String s = "leetcodeIsFun";
        int n = 2;
        DisplayUtil.display(s);

        // 计算
        String result = solution3(s, n);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：直接新建数组装就行。
    // 时间复杂度O(M)，空间复杂度O(M)。代码略。
    public static String solution1(String s, int n) {
        return s;
    }

    // 解法2：原地交换。
    // 假设字符串长度为M，左子串长度为N。每移动一个子串字符，需要执行M - N次。总体时间复杂度 O(MN)
    // 时间复杂度O(MN)，空间复杂度O(1)。代码略。
    public static String solution2(String s, int n) {
        return s;
    }


    // 解法3：双指针 + 三次翻转。先翻转左子串，再翻转右子串，最后总体翻转。
    // 时间复杂度O(M)，空间复杂度O(1)。
    public static String solution3(String s, int n) {
        char[] chars = s.toCharArray();

        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    private static void reverse(char[] cs, int begin, int end) {
        int p1 = begin;
        int p2 = end;

        while (p1 < p2) {
            cs[p1] ^= cs[p2];
            cs[p2] ^= cs[p1];
            cs[p1] ^= cs[p2];

            p1 ++;
            p2 --;
        }
    }
}