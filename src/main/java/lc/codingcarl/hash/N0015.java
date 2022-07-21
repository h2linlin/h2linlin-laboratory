package lc.codingcarl.hash;

import lc.DisplayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc 15. 三数之和
 * @Author h2linlin
 */
public class N0015 {
    public static void main(String[] args) {
        int[] nums = new int[]{19, 2, 3, 4, -8, 5, 9, -5, -22};

        List<List<Integer>> result =  solution2(nums);

        for (List<Integer> list : result) {
            DisplayUtil.display(list.toArray());
        }
    }


    // 解法1：哈希表
    // 由于题目规定了三元组不可重复，所以哈希表用下来会很复杂。
    // 后续有精力再实现
    public static List<List<Integer>> solution1(int[] nums) {
        return null;
    }

    // 解法2：双指针
    public static List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        // 1.数组排序
        Arrays.sort(nums);

        // 2.构建结果
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;

            // 优化
            if (nums[i] > 0) {
                continue;
            }

            // 去重。注意不能验证 i 和 i+1，因为此时 i+1 还没有验证过，会漏掉 -1，-1，2 这种情况
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right --;
                } else if (sum < 0) {
                    left ++;
                } else {
                    // 找到一个结果
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    // left去重。同样的，要放到最后面。放前面会漏掉还没有验证的元素，如0，0，0。
                    while (left < (len - 2) && nums[left] == nums[left + 1]) {
                        left ++;
                    }

                    // right去重。同样的，要放到最后面。放前面会漏掉还没有验证的元素，如0，0，0。
                    while (right > (i + 1) && nums[right] == nums[right - 1]) {
                        right --;
                    }

                    // 继续找下面的结果
                    left ++;
                }
            }
        }

        return result;
    }
}
