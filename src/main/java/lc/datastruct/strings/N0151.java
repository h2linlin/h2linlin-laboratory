package lc.datastruct.strings;

import lc.DisplayUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: h2linlin
 *
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 示例 1：
 *
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 *
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 *
 * 进阶：
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class N0151 {
	public static void main(String[] args) {
		// 输入
		String in = "  leetcode is fun  ";
		DisplayUtil.display(in);

		// 计算
		String out = solution3(in);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：使用队列
	public static String solution1(String s) {


		return null;
	}

	// 解法2：原地解法
	// 从两侧向中间，逐一替换
	public static String solution2(String s) {
		 

		return null;
	}

	// 解法3：语言特性
	// split, reverse, join
	public static String solution3(String s) {
		// 去除前后空格
		s = s.trim();

		// 全部翻转
		List<String> strs = Arrays.asList(s.split("\\s+"));
		Collections.reverse(strs);

		// 组装最终结果
		return String.join(" ", strs);
	}
}
