package lc.datastruct.hash;

import lc.DisplayUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Desc 1. 两数相加
 * @Author wuzh
 * @Date 2021/4/20
 */
public class N0001 {
    public static void main(String[] args) {
        // 输入
        int[] nums1 = {3, 3, 9};
        int target = 6;
        DisplayUtil.display(nums1);

        // 计算
        int[] result = solution2(nums1, target);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：暴力法
    // 代码略。
    public static int[] solution1(int[] nums, int target) {
        return null;
    }

    // 解法2：哈希表
    // 本质上，就是在哈希表里，查询符合 target - num1 的值
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }


}
