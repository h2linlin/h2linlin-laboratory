package lc.datastruct.hash;

import lc.DisplayUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Desc 349. 两个数组的交集
 * @Author wuzh
 * @Date 2021/4/20
 */
public class N0349 {
    public static void main(String[] args) {
        // 输入
        int[] nums1 = {2, 1, 3};
        int[] nums2 = {2, 3};

        DisplayUtil.display(nums1);
        DisplayUtil.display(nums2);

        // 计算
        int[] result = solution3(nums1, nums2);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：暴力法
    // 按顺序，在两个数组里一一对比即可
    // 略。
    public static int[] solution1(int[] nums1, int[] nums2) {
        return null;
    }

    // 解法2：哈希表
    public static int[] solution2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2== null || nums2.length == 0) {
            return new int[0];
        }

        // 1.构建表1
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n1 : nums1) {
            set1.add(n1);
        }

        // 2.构建结果集
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n2 : nums2) {
            if (set1.contains(n2)) {
                set2.add(n2);
            }
        }

        // 3.构造结果数组
        int[] resultArr = new int[set2.size()];
        int index = 0;
        for (Integer s2 : set2) {
            resultArr[index++] = s2;
        }

        return resultArr;
    }

    // 解法3：排序 + 双指针
    public static int[] solution3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2== null || nums2.length == 0) {
            return new int[0];
        }

        // 1.排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        // 双指针取公共集
        HashSet<Integer> set = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        // 3.构造结果数组
        int[] resultArr = new int[set.size()];
        int index = 0;
        for (Integer s2 : set) {
            resultArr[index++] = s2;
        }

        return resultArr;
    }
}
