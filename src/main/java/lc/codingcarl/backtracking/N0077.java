package lc.codingcarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 组合
 * @Author h2linlin
 */
public class N0077 {
    /**
     * 解法：回溯法
     * 注意到做了剪枝优化
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return results;
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    private void backtracking(int startIndex, int n, int k) {
        if (result.size() == k) {
            results.add(result);
            result = new ArrayList<>(result);
            return;
        }

        // i < XX 后面进行了剪枝优化
        for (int i = startIndex; i <= n - (k - result.size()) + 1; i ++) {
            // 纵向递归
            result.add(i);
            backtracking(i + 1, n, k);
            result.remove(result.size() - 1);
        }
    }
}
