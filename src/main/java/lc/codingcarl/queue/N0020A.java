package lc.codingcarl.queue;

import java.util.Deque;
import java.util.LinkedList;

public class N0020A {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();

        Deque<Character> que = new LinkedList();
        for (int i = 0; i < ch.length; i++) {
            Character cur = que.peekFirst();

            if (cur == null) { que.addFirst(ch[i]); continue; }

            if (cur == '(' && ch[i] == ')'
                    || cur == '[' && ch[i] == ']'
                    || cur == '{' && ch[i] == '}') {
                que.removeFirst();
                continue;
            }

            que.addFirst(ch[i]);
        }

        return que.peekFirst() == null;
    }
}
