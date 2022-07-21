package lc.codingcarl.backtracking;

import java.util.*;

/**
 * @Desc 47. 全排列 II
 * @Author h2linlin
 */
public class N0047 {
    /**
     * 解法：回溯法
     *
     * 需要去重。
     * 1.排序
     * 2.使用used[]去重。标记是在回溯前用过还是回溯后用过。树层方向是回溯前，used == false。树枝方向是回溯后，used == true。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, used);

        return results;
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    private void backtracking(int[] nums, boolean[] used) {
        // 收集结果
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            // 处理
            // 1.树层方向剪枝
            if (used[i]) {
                continue;
            }

            // 2.去重
            if (i > 0
                    && nums[i] == nums[i - 1]
                    && used[i - 1] == false) {
                continue;
            }

            // 3.操作
            path.add(nums[i]);
            used[i] = true;

            backtracking(nums, used);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
