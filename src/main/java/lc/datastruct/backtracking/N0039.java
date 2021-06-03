package lc.datastruct.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 39. 组合总和
 * @Author h2linlin
 */
public class N0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum = target;

        bachtracking(candidates, 0);

        return results;
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum;


    private void bachtracking(int[] candidates, int startIndex) {
        if (sum < 0) {
            return;
        }
        // 收集结果
        if (sum == 0) {
            results.add(new ArrayList<>(path));
        }

        // 剪枝操作(需要candidates先排序)：可再加入sum - candidates[i] >= 0。即i < candidates.length && sum - candidates[i] >= 0
        for (int i = startIndex; i < candidates.length; i++) {
            // 处理
            sum -= candidates[i];
            path.add(candidates[i]);

            // 递归
            bachtracking(candidates, i);    // 为i，表示可以重复取数

            // 回溯
            sum += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
