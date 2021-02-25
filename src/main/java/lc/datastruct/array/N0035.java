package lc.datastruct.array;

import lc.DisplayUtil;

/**
 * @Author: h2linlin
 *
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class N0035 {
	public static void main(String[] args) {
		// 输入
		int[] in = {1, 2, 3};
		int target = 4;
		DisplayUtil.display(in);
		DisplayUtil.display("target: " + target);

		// 计算
		int out = solution1(in, target);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：暴力法
	private static int solution1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				return i;
			}
		}

		// 边界判断：最后一位
		return nums.length;
	}

	// 解法2：二分查找
//	private static int solution2(int[] nums, int target) {
//		int left = 0;
//		int right = nums.length;
//
//		while (left < right) {
//			int mid = left + right / 2;
//
//			if (target < nums[mid] ) {
//				right = mid;
//			} else {
//				left = mid;
//			}
//		}
//
//		if (target < nums[left]) {
//			return left;
//		}
//
//		return nums.length;
//	}

//	int left = 0, right = numsSize;
//
//	while (left < right)
//	{
//		int mid = left + (right - left) / 2;
//
//		if (nums[mid] >= target)
//		{
//			right = mid;
//		}
//		else
//		{
//			left = mid + 1;
//		}
//	}
//
//	return left;
}
