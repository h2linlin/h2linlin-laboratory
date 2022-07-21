package lc.codingcarl.queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Desc 347. 前 K 个高频元素
 * @Author h2linlin
 */
public class N0347 {
    /**
     * 解法1：全部排序，按顺序取前k个即可。但此时为O(nLogn)，而题目要求优于此复杂度。
     *
     * 解法2（本方法解法）：
     *   1.统计频次。O(n)
     *   2.排序。O(nlogn)
     *   3.取前K个元素
     *
     *   注意到，排序的时候需要用小顶堆，而不是大顶堆。因为每次需要把最小的堆顶弹出去，最后才剩下最大的k个。
     *   时间复杂度：O(n + nlogk) = O(nlogk)
     *
     * 解法3：排序用桶排序。
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = statistic(nums);

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (map.get(pq.peek()) < map.get(key)){
                pq.poll();
                pq.offer(key);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }


    //  key: 值，value：次数
    private HashMap<Integer, Integer> statistic(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        return map;
    }
}
