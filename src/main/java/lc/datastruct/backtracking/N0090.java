package lc.datastruct.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc 90. 子集 II
 * @Author h2linlin
 */
public class N0090 {
    /**
     * 解法：递归法。
     * 树枝方向可以重复，树层方向不能重复。
     * 所以需要一个used[]数组来记录使用状态，是递归前深入树枝的状态，还是回溯后在树层的状态。
     *
     * 关键点：
     * 1.数组排序
     * 2.used数组来判断是递归的树枝方向，还是回溯后的树层方向。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, used, 0);

        return results;
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    private void backtracking(int[] nums, boolean[] used, int startindex) {
        // 回收结果
        results.add(new ArrayList<>(path));
        if (startindex > nums.length - 1) {
            return;
        }

        for (int i = startindex; i < nums.length; i++) {
            // 处理
            if (i > 0 && nums[i] == nums[i- 1] && used[i - 1] == false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;

            // 递归
            backtracking(nums, used, i + 1);

            // 回溯
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
