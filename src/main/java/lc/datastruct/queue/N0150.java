package lc.datastruct.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 150. 逆波兰表达式求值
 * @Author h2linlin
 */
public class N0150 {

    // 解法1：用栈
    public int solution1(String[] tokens) {
        Deque<Integer> st = new LinkedList<>();

        for (String str : tokens) {
            if (match(str)) {
                int s2 = st.pop();
                int s1 = st.pop();
                st.push(count(s1, s2, str));
            } else {
                st.push(Integer.valueOf(str));
            }
        }

        return st.pop();
    }

    private boolean match(String str) {
        return "+".equals(str) || "-".equals(str) ||"*".equals(str) ||"/".equals(str);
    }

    private int count(int s1, int s2, String str) {
        if ("+".equals(str)) {
            return s1 + s2;
        }
        if ("-".equals(str)) {
            return s1 - s2;
        }
        if ("*".equals(str)) {
            return s1 * s2;
        }
        if ("/".equals(str)) {
            return s1 / s2;
        }

        throw new RuntimeException("bad param");
    }
}
