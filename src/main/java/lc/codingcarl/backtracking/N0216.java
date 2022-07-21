package lc.codingcarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 216. 组合总和 III
 * @Author h2linlin
 */
public class N0216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(1,n, k);
        return results;
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    // 和为 n 的 k 个数
    private void backtracking(int startIndex, int n, int k) {
        // 剪枝
        if (sum > n) {
            return;
        }

        if (path.size() == k) {
            if (sum == n) {
                results.add(path);
                path = new ArrayList<>(path);
                return;
            }
            return;
        }

        // 水平遍历
        for (int i = startIndex; i <= 9; i ++) {
            // 处理
            path.add(i);
            sum += i;

            // 垂直遍历
            backtracking(i + 1, n, k);

            // 回溯
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
