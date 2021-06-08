package lc.datastruct.backtracking;

import java.util.*;

/**
 * @Desc 491. 递增子序列
 * @Author h2linlin
 */
public class N0491 {
    /**
     * 解法：回溯法。
     * 注意到本题是不能对数组进行排序的。但是又需要去重，所以不能用前面的去重思路。
     *
     * 使用一个usedSet来记录本层使用过的元素。
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return results;
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums, int startIndex) {
        // 回收结果
        if (path.size() >= 2) {
            results.add(new ArrayList<>(path));
        }

        // set仅限本层使用
        Set<Integer> usedSet = new HashSet<>(201);

        for (int i = startIndex; i < nums.length; i ++) {
            // 处理
            // 1.需要递增
            if (path.size() >= 1 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            // 2.不能重复
            if (usedSet.contains(nums[i])) {
                continue;
            }
            // 3.动作
            path.add(nums[i]);
            usedSet.add(nums[i]);

            // 递归
            backtracking(nums, i + 1);

            // 回溯
            path.remove(path.size() - 1);
            // usedSet无需回溯，因为仅仅在单层生效。
        }
    }


//    // 性能改进，逻辑一样
//    private void backtracking(int[] nums, int startIndex) {
//        // 回收结果
//        if (path.size() >= 2) {
//            results.add(new ArrayList<>(path));
//        }
//
//        // set仅限本层使用
//        int[] usedArray = new int[201];
//
//        for (int i = startIndex; i < nums.length; i ++) {
//            // 处理
//            // 1.需要递增
//            if (path.size() >= 1 && nums[i] < path.get(path.size() - 1)) {
//                continue;
//            }
//            // 2.不能重复
//            if (usedArray[100 + nums[i]] == 1) {
//                continue;
//            }
//            // 3.动作
//            path.add(nums[i]);
//            usedArray[100 +nums[i]] = 1;
//
//            // 递归
//            backtracking(nums, i + 1);
//
//            // 回溯
//            path.remove(path.size() - 1);
//            // usedSet无需回溯，因为仅仅在单层生效。
//        }
//    }
}
