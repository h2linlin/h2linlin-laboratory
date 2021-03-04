package lc.datastruct.strings;

import lc.DisplayUtil;

/**
 * @Author: h2linlin
 *
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 方法一（暴力解法）：
 * 方法二（中心扩散）：
 * 方法三（动态规划）：
 * 方法四（Manacher 算法）：
 *
 */
public class N0005 {
	public static void main(String[] args) {
		// 输入
		String in = "fhjhjjhjjjf";
		DisplayUtil.display(in);

		// 计算
		String out = solution1(in);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：暴力法
	public static String solution1(String s) {

		return null;
	}


}
