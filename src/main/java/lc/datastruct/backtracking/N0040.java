package lc.datastruct.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc 40. 组合总和 II
 * @Author h2linlin
 */
public class N0040 {

    /**
     * 难点是，candidates有重复的数组，但是结果集中不能有重复的组合。
     * 所以要考虑如何去重。每层往前推进时，已经用过的数字要进行剪枝。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        sum = target;
        used = new boolean[candidates.length];
        Arrays.sort(candidates);    // 排序，后面剪枝时提升效率

        backtracking(candidates, 0, used);

        return results;
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum;
    boolean[] used; // 用于去重。树枝方向不去重，树层方向去重。

    private void backtracking(int[] candidates, int index, boolean[] used) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        // 由于 candidates是有序的，所以可以用剪枝优化，即candidates[i] >= 0
        for (int i = index; i < candidates.length && sum - candidates[i] >= 0; i++) {
            // 去重剪枝
            // 树枝方向，即递归深度方向，使用过元素。
            // 树层方向，即广度方向，回溯返回统一层，元素置为未使用状态。
            // 在candidates[i] == candidates[i - 1]相同的情况下：
            //   used[i - 1] == true，说明本层是candidates[i - 1]传承下来的，candidates[i] 和 candidates[i - 1]位于同一树支，此时可以使用
            //   used[i - 1] == false，说明本层不是candidates[i - 1]传承下来的，candidates[i] 和 candidates[i - 1]位于同一树层，此时不可以使用
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            // 处理
            path.add(candidates[i]);
            sum -= candidates[i];
            used[i] = true;

            // 递归
            backtracking(candidates, i + 1, used);

            // 回溯
            path.remove(path.size() - 1);
            sum += candidates[i];
            used[i] = false;
        }

    }

}
