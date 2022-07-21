package lc.codingcarl.strings;

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
 * 方法一（暴力解法：中心扩散）：
 * 方法二（动态规划）：
 * 方法三（Manacher 算法）：
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

	// 解法1：暴力法（中心扩散）
	// 列举所有的回文中心，逐一验证。验证方法：逐一进行中心扩散。
	public static String solution1(String s) {
		// 1.边界判断
		if (s == null || "".equals(s) || s.length() == 1) {
			return s;
		}

		// 2.中心扩展

		// 2.1 最大回文串起点和终点
		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			// 回文串为奇数的情况
			int len1 = disperse(s, i, i);
			// 回文串为偶数的情况
			int len2 = disperse(s, i, i+1);

			int len = Math.max(len1, len2);
			// 计算回文串在总的字符串中的位置，并进行更新
			if (end - start + 1 < len) {
				start = i - (len - 1)/ 2;
				end = i + len / 2;
			}
		}

		return s.substring(start, end + 1);
	}


	// s：字符串
	// left：中心点第一个回文对的左侧坐标
	// right：中心点第一个回文对的右侧坐标
	// 返回：中心点最大回文字符串长度
	private static int disperse(String s, int left, int right) {
		while((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))) {
			left --;
			right ++;
		}
		return right - left - 1;
	}

}
