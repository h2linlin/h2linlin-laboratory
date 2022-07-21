package lc.codingcarl.array;

import lc.DisplayUtil;

/**
 * @Desc
 * @Author h2linlin
 * @Date 2021/4/17
 */
public class N0209 {
    public static void main(String[] args) {
        // 输入
        int[] nums = {1,4,4};
        int target = 4;
        DisplayUtil.display(nums);
        DisplayUtil.display("target: " + target);

        // 计算
        int result = solution3(target, nums);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：暴力法。会超时，不知道正确否。
    // 每个长度都试一遍。
    // 第一层for循环：子数组长度
    // 第二层for循环，子数组起点
    private static int solution1(int target, int[] nums) {
        int n = nums.length;
        int sublen = 0;  // 子序列长度

        // 子序列长度
        for (sublen = 1; sublen <= n; sublen++) {
            // 开始位置
            for (int start = 0; start < n; start++) {
                // 求和
                if (start + sublen > n) {
                    continue;
                }

                int sum = 0;
                for (int j = 0; j < sublen; j++) {
                    sum += nums[start + j];
                }
                if (sum >= target) {
                    return sublen;
                }
            }
        }
        return 0;
    }

    // 解法2：优雅一点的暴力法。
    // 找每个元素做为起点时，它的最小长度。并更新
    // 遍历完所有元素后，就找出了最小长度。
    // 第一层for循环：子数组起点
    // 第二层for循环，子数组终点
    private static int solution2(int target, int[] nums) {
        int result = Integer.MAX_VALUE; // 数组长度
        int n = nums.length;

        // 起点
        for (int start = 0; start < n; start++) {
            // 终点
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];

                if (sum >= target) {
                    int sublen = end - start + 1;

                    result = sublen < result ? sublen : result;
                    break;  // 已找到本元素下的最小长度
                }
            }
        }

        // 看下最大长度有没有被更新
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 解法3：滑动窗口
    private static int solution3(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        int p2 = 0;
        int sum = 0;
        for (int p1 = 0; p1 < n; p1++) {
            // 计算子序列的和
            sum += nums[p1];

            // 窗口内的值符合要求时，移动开始指针
            while (sum >= target) {
                int sublen = p1 - p2 + 1;
                result = sublen < result ? sublen : result;
                sum -= nums[p2];
                p2++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
