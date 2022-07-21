package lc.codingcarl.array;

import lc.DisplayUtil;

/**
 * @Author: h2linlin
 *
 * 724. 寻找数组的中心索引
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 *
 * 注意：中心索引可能出现在数组的两端。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心索引是 3 。
 * 左侧数之和 (1 + 7 + 3 = 11)，
 * 右侧数之和 (5 + 6 = 11) ，二者相等。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 * 示例 3：
 *
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心索引是 0 。
 * 索引 0 左侧不存在元素，视作和为 0 ；
 * 右侧数之和为 1 + (-1) = 0 ，二者相等。
 *  
 *
 * 提示：
 *
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * 相关标签
 * 数组
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 思路：preSum解法：为了节约时间，需要考虑左求和*2+nums[i]=总和
 */
public class N0724 {
	public static void main(String[] args) {
		// 输入
		int[] in = {2, 1, -1};
		DisplayUtil.display(in);

		// 计算
		int out = solution(in);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：暴力法
	public int pivotIndex(int[] nums) {
		// 按照题意，0和nums.length也可以做中心索引
		for (int i = 0; i < nums.length; i++) {
			// 1 计算该索引之前的和
			int m = 0;
			for (int j = 0; j < i; j++) {
				m = m + nums[j];
			}
			// 2 计算该索引之前的和
			int n = 0;
			for (int k = i + 1; k < nums.length; k++) {
				n = n + nums[k];
			}
			// 3 判断是否为中心索引
			if (m == n) {
				return i;
			}
		}
		return -1;
	}


	// 解法2：preSum法，节省时间。左边的数据 * 2 + int[i] == 总和 即满足条件
	public static int solution(int[] in) {
		int sum = 0;
		for (int i = 0; i < in.length; i++) {
			sum += in[i];
		}

		// 查找中心索引
		int preSum = 0;
		for (int i = 0; i < in.length; i++) {
			if (preSum * 2 + in[i] == sum) {
				return i;
			}
			preSum += in[i];
		}

		// 如果数组不存在中心索引，返回 -1
		return -1;
	}
}










