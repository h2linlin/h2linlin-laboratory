package lc.codingcarl.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 1047. 删除字符串中的所有相邻重复项
 * @Author h2linlin
 */
public class N1047 {
    public static void main(String[] args) {
        String S = "abbaca";
        System.out.println(S);

        System.out.println(solution2(S)+"");
    }

    // 解法1：用栈。
    public static String solution1(String S) {
        Deque<Character> st = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (!st.isEmpty() && st.peek() == c) {
                st.pollFirst();
                continue;
            }

            st.offerFirst(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pollLast());
        }
        return sb.toString();
    }


    // 解法2：纯数组解法
    public static String solution2(String S) {
        char[] s1 = S.toCharArray();
        char[] s2 = new char[S.length()];

        int p1 = 0;
        int p2 = -1;

        for (char s : s1) {
            if (p2 < 0 || s2[p2] != s1[p1]) {
                p2 ++;
                s2[p2] = s1[p1];
            } else {
                p2 --;
            }

            p1 ++;
        }

        return new String(s2, 0, p2 + 1);
    }
}
