package lc.codingcarl.array;

import lc.DisplayUtil;

/**
 * @Desc
 * @Author h2linlin
 * @Date 2021/4/17
 */
public class N0027 {
    public static void main(String[] args) {
        // 输入
        int[] nums = {1, 2, 3};
        int val = 1;
        DisplayUtil.display(nums);
        DisplayUtil.display("val: " + val);

        // 计算
        int result = solution2(nums, val);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：暴力法。两个for循环，第一个遍历数组。第二个更新数组。
    private static int solution1(int[] nums, int val) {
        int n = nums.length;
        int trashLength = 0;
        // 遍历数组
        for (int i = 0; i < n - trashLength; i++) {
            if (nums[i] != val) {
                continue;
            }
            // 将需要删除的元素移动到最后面。垃圾区长度+1
            for (int j = i; j < n - 1; j++) {
                int k = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = k;
            }
            trashLength ++;
            i--;
        }
        return n - trashLength;
    }

    // 解法1：暴力法。
    // 两个for循环，第一个遍历数组。第二个更新数组。
    // 更优雅的代码，和solution1是一模一样的算法。
    private static int solution2(int[] nums, int val) {
        int n = nums.length;
        // 遍历数组
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                continue;
            }
            // 将需要删除的元素移动到最后面。垃圾区长度+1
            for (int j = i; j < n - 1; j++) {
                int k = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = k;
            }
            n--;
            i--;
        }
        return n;
    }

    // 解法2：快慢指针。将 n^2 降到 n
    // 相当于是先假设所有数据都是垃圾。然后p1先跑去前面，把不是垃圾的数据交给p2存起来。
    // p2表示垃圾区的开始
    private static int solution3(int[] nums, int val) {
        int p2 = 0;

        for (int p1 = 0; p1 < nums.length; p1++) {
            // 不匹配
            if (nums[p1] != val) {
                nums[p2] =  nums[p1];
                p2++;
            }
        }

        return p2;
    }
}
