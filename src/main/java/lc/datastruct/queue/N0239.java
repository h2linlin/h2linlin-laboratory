package lc.datastruct.queue;

import lc.DisplayUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 239. 滑动窗口最大值
 * @Author h2linlin
 */
public class N0239 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7,7,6,6};
        int k = 4;
        DisplayUtil.display(nums);

        int[] result = solution(nums, k);

        DisplayUtil.display(result);
    }


    // 解法：单调队列。
    // 只维护有可能成为最大的值。
    // 核心思想：
    //   只关心，老大死的时候要把它从队列中移除，新人一旦入队，如果有资格挑战老大或老二，立马让他坐上位置。其他人全部干掉。
    //   新人坐上位置后，开始培育自己的亲信。至于说之前的元素比自己的亲信强，那么其实自己挂之前，他们都没有机会。
    // pop时，保证如果滑出的是最大值，那么这个最大值要被删掉。
    // push时，保证如果滑入的值可以成为老大或老二，那么让它入队开辟新天地，其他队列中的值全部干掉。在他挂之前，他一直是最大的。挂了之后，它之后的元素也是有序的。
    public static int[] solution(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MyQueue que = new MyQueue();

        for (int i = 0; i < k; i ++) {
            que.push(nums[i]);
        }
        result[0] = que.head();

        for (int i = 0; i < nums.length - k; i++) {
            que.pop(nums[i]);
            que.push(nums[i + k]);
            result[i + 1] = que.head();
        }

        return result;
    }

    private static class MyQueue {
        Deque<Integer> que = new LinkedList<>();

        public void pop(int num) {
            if (que.peekFirst() == num) {
                que.pollFirst();
            }
        }

        public void push(int num) {
            if (que.isEmpty()) {
                que.offerLast(num); // 注意提前判空
                return;
            }

            while (!que.isEmpty() && num > que.peekLast()) {
                que.pollLast();
            }
            que.offerLast(num);
        }

        public int head() {
            return que.peekFirst();
        }
    }
}
