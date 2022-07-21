package lc.codingcarl.hash;

import lc.DisplayUtil;

import java.util.HashMap;

/**
 * @Desc 454. 四数相加 II
 * @Author wuzh
 * @Date 2021/4/20
 */
public class N0454 {
    public static void main(String[] args) {
        // 输入
        int[] nums1 = {3, 2, 9};
        int[] nums2 = {14, 3, 9};
        int[] nums3 = {-3, 1, 9};
        int[] nums4 = {-27, 5, -3};

        int target = 12;
        DisplayUtil.display(nums1);
        DisplayUtil.display(nums2);
        DisplayUtil.display(nums3);
        DisplayUtil.display(nums4);

        // 计算
        int result = solution2(nums1, nums2, nums3, nums4);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：暴力法。
    // 代码略。显然代价太高。
    public static int solution1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        return -1;
    }


    // 解法2：分组 + 哈希表
    public static int solution2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 1.构建S1，S2哈希表。 Key：值。Value：出现次数。
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (Integer n1 : nums1) {
            for (Integer n2 : nums2) {
                int sum = n1 + n2;
                if (map1.containsKey(sum)) {
                    map1.put(sum, map1.get(sum)+1);
                } else {
                    map1.put(sum, 1);
                }
            }
        }

        // 2.构建S3, S4哈希表。并统计数值
        int count = 0;
        for (Integer n3 : nums3) {
            for (Integer n4 : nums4) {
                int mus = 0 - (n3 + n4);
                if (map1.containsKey(mus)) {
                    count += map1.get(mus);
                }
            }
        }

        return count;
    }
}
