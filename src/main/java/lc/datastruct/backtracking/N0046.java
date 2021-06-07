package lc.datastruct.backtracking;

import java.util.*;

/**
 * @Desc 46. 全排列
 * @Author h2linlin
 */
public class N0046 {
    /**
     * 解法：回溯法。
     * 需要一个used数组，标记哪些元素已使用。
     * 每层都从第1个元素开始遍历
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return results;
        }

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
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;

            // 递归
            backtracking(nums, used);

            // 回溯
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
