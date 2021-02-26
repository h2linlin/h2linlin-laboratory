package lc.datastruct.array;

import lc.DisplayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: h2linlin
 *
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N0073 {
	public static void main(String[] args) {
		// 输入
		int[][] in = {{1, 4, 5, 2}, {2, 3, 0, 1}};
		int target = 4;
		DisplayUtil.display(in);

		// 计算
		int[][] out = solution1(in);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：暴力法。遍历整个矩阵，取得要置零的x和y坐标，再置零即可。
	// 空间复杂度：O(M + N)。如果需要原地置换，也就是空间复杂度为O(1)，那么需要考虑其他解法。
	public static int[][] solution1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return matrix;
		}

		// 要置零的坐标列表
		TreeSet<Integer> xSet = new TreeSet<>();
		TreeSet<Integer> ySet = new TreeSet<>();

		// 找出所有零的坐标
		int xLength =  matrix.length, yLength = matrix[0].length;
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				if (matrix[x][y] == 0) {
					xSet.add(x);
					ySet.add(y);
				}
			}
		}

		// 置零
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				if (xSet.contains(x)) {
					matrix[x][y] = 0;
					continue;
				}
				if (ySet.contains(y)) {
					matrix[x][y] = 0;
				}
			}
		}

		return matrix;
	}

	// 解法2：暴力法。
	// 第一步：1.遍历整个矩阵，遇到为0的元素，把该元素所在行/列的所有非0元素置为一个特殊数。
	// 第二步：2.遍历矩阵，将所有特殊数置0。
	// 空间复杂度：O(1)。时间复杂度太高：O((M * N) * (M + N))
	public static int[][] solution2(int[][] matrix) {
		// 略
		return null;
	}

	// 解法3：暴力法。
	// 解法2效率不高是因为我们会对每一个格子都重复赋0，其实我们只需要用行列的第一个元素标记，然后延迟赋0即可。
	// 注意cell[0][0]同时标记了第一行和第一列，所以用一个额外的变量表示第一列是否被标记。
	// 空间复杂度：O(1)。
	public static int[][] solution3(int[][] matrix) {
		// 略
		return null;
	}
}


