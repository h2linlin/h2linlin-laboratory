package lc.codingcarl.array;

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
		int out = solution3(in, target);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：暴力法
	private static int solution1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			// 处理四种情况：
			// 	1.在数组最前面
			//  2.在数组某个位置
			//  3.在数组中间

			if (target <= nums[i]) {
				return i;
			}
		}

		// 4.在数组最后面
		return nums.length;
	}

	// 解法2：二分查找，写法一
	private static int solution2(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n;	// 假设target值在[left, right)里

		while (left < right) {
			int middle = left + (right - left) / 2;	// 防止溢出

			if(target < nums[middle]) {
				right = middle;
			} else if (target > nums[middle]) {
				left = middle + 1;
			} else {
				return middle;
			}
		}

		// 分别处理如下四种情况
		// 目标值在数组所有元素之前 [0,0)
		// 目标值等于数组中某一个元素 return middle
		// 目标值插入数组中的位置 [left, right) ，return right 即可
		// 目标值在数组所有元素之后的情况 [left, right)，return right 即可
		return right;
	}

	// 解法2：二分查找，写法二
	private static int solution3(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int middle = left + ((right - left) >> 1);	// 防止溢出

			if (target < nums[middle]) {
				right = middle - 1;
			} else if (target > nums[middle]) {
				left = middle + 1;
			} else {
				return middle;
			}
		}

		return left;
	}

	// 解法3：二分查找，写法三
	private static int solution4(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int middle = left + ((right - left) >> 1);	// 防止溢出

			if (target > nums[middle]) {
				left = middle + 1;
			} else if (target < nums[middle]) {
				right = middle - 1;
			} else {
				return middle;
			}
		}

		// 分别处理如下四种情况
		// 目标值在数组所有元素之前  [0, -1]
		// 目标值等于数组中某一个元素  return middle;
		// 目标值插入数组中的位置 [left, right]，return  right + 1
		// 目标值在数组所有元素之后的情况 [left, right]， return right + 1

		return right + 1;	// return left也行
	}
}
