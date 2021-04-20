package lc.datastruct.hash;

import lc.DisplayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc
 * @Author h2linlin
 */
public class N0018 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        int target = -11;

        List<List<Integer>> result =  solution1(nums, target);

        for (List<Integer> list : result) {
            DisplayUtil.display(list.toArray());
        }
    }


    // 解法1：双指针
    public static List<List<Integer>> solution1(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return results;
        }

        // 排序
        Arrays.sort(nums);

        // 查找
        for (int i = 0; i < nums.length - 3; i++) {
            // 去重，确保移动指针后，数字是改变了的。
            // 注意，这里不能用 nums[i] > target 剪枝，因为target可能小于0。负数+负数，越加越小， -4 + (-3) > -5 不成立。
            if ((i > 0 && nums[i] == nums [i - 1])) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // 去重，确保移动指针后，数字是改变了的。优化。
                if ((j > i + 1 && nums[j] == nums [j - 1])) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left ++;
                    } else if(sum > target) {
                        right --;
                    } else {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        results.add(list);

                        // 去重
                        while (left + 1 < nums.length && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        while (right > 0 && nums[right] == nums[right - 1]) {
                            right --;
                        }

                        left ++;
                        right --;
                    }
                }
            }
        }

        return results;
    }
}
