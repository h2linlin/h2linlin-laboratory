package lc.codingcarl.strings;

import lc.DisplayUtil;

import java.util.*;

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
		String in = "the sky is blue";
		DisplayUtil.display(in);

		// 计算
		String out = solution2(in);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：使用栈
	public static String solution1(String s) {
		Stack<String> stack = new Stack<>();

		s = s.trim();

		List<String> strs = Arrays.asList(s.split("\\s+"));
		strs.forEach(
				w -> {
					stack.push(w);
				}
		);

		StringBuffer sb = new StringBuffer(stack.pop());
		while (!stack.empty()) {
			sb.append(" " + stack.pop());
		}

		return sb.toString();
	}


	// 解法2：原地解法
	// 1.双指针去除多余空格
	// 2.双指针翻转所有字符串
	// 3.双指针翻转每个单词
	public static String solution2(String s) {
		char[] chars = s.toCharArray();
		// 1.双指针去除空格
		// 去除头尾空格
		int head = 0;
		while (chars[head] == ' ') {
			head ++;
		}
		int tail = chars.length - 1;
		while (chars[tail] == ' ') {
			tail --;
		}

		// 去除中间空格
		int p1 = head;
		int p2 = head + 1;
		while (p2 <= tail) {
			if (chars[p2 -1] == ' ' && chars[p2] == ' ') {
				p2 ++;
				continue;
			}
			chars[p1 + 1] = chars[p2];
			p1 ++;
			p2 ++;
		}

		tail = p1;

		// 2.双指针翻转整个字符串
		chars = reverse(chars, head, tail);

		// 3.双指针翻转每个单词
		p1 = head;
		p2 = head;

		for (int i = head; i <= tail;) {
			int add = 0;
			while (i + add <= tail && chars[i + add] != ' ') {
				add ++;
			}

			if (i + add != tail) {
				reverse(chars, i, i + add - 1);
				i += add + 1;
			} else {
				reverse(chars, i, tail);
				i = tail + 1;
			}
		}

		return new String(chars, head, tail - head + 1);
	}

	// 翻转下标begin到end字符
	static char[] reverse(char[] chars, int begin, int end) {
		int p1 = begin;
		int p2 = end;

		while (p1 < p2) {
			chars[p1] ^= chars[p2];
			chars[p2] ^= chars[p1];
			chars[p1] ^= chars[p2];

			p1 ++;
			p2 --;
		}
		return chars;
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
