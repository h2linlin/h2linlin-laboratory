package lc.codingcarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 78. 子集
 * @Author h2linlin
 */
public class N0078 {
    /**
     * 解法：回溯法。与前面组合等问题的一点点区别是，需要收集每一个节点，而不是叶子节点。
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return restults;
        }
        backTracking(nums, 0);
        return restults;
    }

    List<List<Integer>> restults = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backTracking(int[] nums, int startIndex) {
        restults.add(new ArrayList<>(path));
        // 回收结果
        if (startIndex > nums.length - 1) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 处理
            path.add(nums[i]);

            // 递归
            backTracking(nums, i + 1);

            // 回溯
            path.remove(path.size() - 1);
        }
    }

}
