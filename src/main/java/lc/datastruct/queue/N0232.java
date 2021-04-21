package lc.datastruct.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 232. 用栈实现队列
 * @Author h2linlin
 */
public class N0232 {
    // 解法1：两个栈，一个输入栈，一个输出栈。
    // 输入时：把输出栈的数据全部导入输入栈，再把输入压入输入栈，再把数据全部导到输出栈。
    // 输出时：直接输出
    // 判空：判断输出栈是否为空就行。
    // 代码略去，每次操作时间复杂度：O(N)
    //
    // 解法2：解法1的优化。两个栈，一个输入栈，一个输出栈。
    // 输入时：直接压入输入栈。
    // 输出时：若输出栈不为空，直接输出。若为空，则从输入栈导入数据，再输出。
    // 判空：判断输出栈和输入栈是否都为空就行。
    // 代码略去，每次操作时间复杂度：平均复杂度O(1), 最坏情况O(N)
    class MyQueue {
        Deque<Integer> in;
        Deque<Integer> out;

        /** Initialize your data structure here. */
        public MyQueue() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!out.isEmpty()) {
                return out.pop();
            } else {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
                return out.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            if (!out.isEmpty()) {
                return out.peek();
            } else {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
                return out.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
