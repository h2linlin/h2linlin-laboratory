package lc;

/**
 * @Author: h2linlin
 */
public class DisplayUtil {
	// 打印int
	public static void display(int out) {
		System.out.println(out);
	}

	// 打印String
	public static void display(String out) {
		System.out.println(out);
	}

	// 打印一维数组
	public static void display(int[] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(matrix[i] + "\t");
		}
		System.out.println();
	}

	// 打印一维数组
	public static void display(Object[] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(matrix[i] + "\t");
		}
		System.out.println();
	}

	// 打印二维数组
	public static void display(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
