package lc.datastruct.array;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lc.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: h2linlin
 *
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class N0056 {
	public static void main(String[] args) {
		// 输入
		int[][] in = {{1, 4}, {2, 3}};
		int target = 4;
		DisplayUtil.display(in);

		// 计算
		int[][] out = solution1(in);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法一：暴力法。
	// 先将每个点按x坐标升序排列，然后从前往后依次合并即可。
	public static int[][] solution1(int[][] array) {
		if (array.length == 0) {
			return new int[0][2];
		}

		// 排序
		array = sortArray(array);

		// 依次合并
		List<int[]> result = new ArrayList<>();
		for (int i = 1; i < array.length; i++) {
			// 要不要和前一个合并
			if (array[i-1][1] < array[i][0]) {
				// 没有交集，前一个直接返回
				result.add(array[i-1]);
				continue;
			}

			// 合并
			if (array[i-1][0] < array[i][0]) {
				array[i][0] = array[i-1][0];
			}
			if (array[i-1][1] > array[i][1]) {
				array[i][1] = array[i-1][1];
			}
		}

		// 处理最后一个元素
		result.add(array[array.length-1]);

		return result.toArray(new int[result.size()][]);
	}

	// 冒泡排序
	private static int[][] sortArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j][0] <= arr[j+1][0]) {
					continue;
				}

				// 交换
				int temp0 = arr[j][0];
				int temp1 = arr[j][1];
				arr[j][0] = arr[j+1][0];
				arr[j][1] = arr[j+1][1];
				arr[j+1][0] = temp0;
				arr[j+1][1] = temp1;
			}
		}

		return arr;
	}
}
