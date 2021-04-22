package lc.datastruct.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 225. 用队列实现栈
 * @Author h2linlin
 */
public class N0225 {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        ms.top();
        ms.pop();
        ms.empty();
    }

    // q1用来存数据
    // q2是空的，只是做辅助插入
    public static class MyStack {
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();


        /** Initialize your data structure here. */
        public MyStack() {}

        /** Push element x onto stack. */
        public void push(int x) {
            q2.offerLast(x);
            while (!q1.isEmpty()) {
                q2.offerLast(q1.pollFirst());
            }
            Deque<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.pollFirst();
        }

        /** Get the top element. */
        public int top() {
            return q1.peekFirst();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
