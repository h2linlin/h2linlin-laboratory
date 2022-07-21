package lc.codingcarl.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 20. 有效的括号
 * @Author h2linlin
 */
public class N0020 {
    public static void main(String[] args) {
        String s = ")";
        System.out.println(s);

        System.out.println(solution1(s)+"");
    }


    // 解法1：直接用栈。
    // 遇到左括号入栈，遇到右括号出栈。栈不为空则匹配失败。
    public static boolean solution1(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i) || '[' == s.charAt(i) || '{' == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if (')' == s.charAt(i) && !stack.isEmpty() && stack.peekFirst() == '(') {
                stack.pop();
            } else if (']' == s.charAt(i) && !stack.isEmpty() && stack.peekFirst() == '[') {
                stack.pop();
            } else if ('}' == s.charAt(i) && !stack.isEmpty() && stack.peekFirst() == '{') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    // 解法2：直接用栈。更优雅一点的写法。
    // 把左括号的信息直接映射到右括号。
    public static boolean solution2(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(')');
            } else if ('[' == s.charAt(i)) {
                stack.push(']');
            } else if ('{' == s.charAt(i)) {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                // 字符匹配失败，两种情况：没有匹配的，或者匹配失败。
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
