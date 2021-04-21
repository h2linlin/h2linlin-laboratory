package lc.datastruct.strings;

import lc.DisplayUtil;

/**
 * @Desc
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * @Author h2linlin
 */
public class N0541 {
    public static void main(String[] args) {
        // 输入
        String s = "leetcodeIsFun";
        int k = 2;
        DisplayUtil.display(s);

        // 计算
        String result = solution2(s, k);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：双指针实现翻转函数。翻转逻辑用for循环控制即可。
    public static String solution1(String s, int k) {

        for (int i = 0; i < s.length(); i += 2*k) {
            // 1.剩余字符大于2k
            // 2.剩余字符大于等于k
            if (s.length() - i >= k) {
                s = reverse(s, i, i + k - 1);
                continue;
            }

            // 3.剩余字符小于k
            s = reverse(s, i, s.length() - 1);
        }

        return s;
    }

    // begin: beginIndex, end: endIndex
    private static String reverse(String s, int begin, int end) {
        char[] chars = s.toCharArray();

        for (int p1 = begin, p2 = end; p1 < p2; p1 ++, p2--) {
            chars[p1] ^= chars[p2];
            chars[p2] ^= chars[p1];
            chars[p1] ^= chars[p2];
        }

        return new String(chars);
    }

    // 解法2：暴力法
    // 解法1：双指针实现翻转函数。翻转逻辑用for循环控制即可。
    public static String solution2(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2*k) {
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);

            // 翻转
            while (start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];

                start ++;
                end --;
            }
        }
        return new String(chars);
    }

}
