package lc;

/**
 * @Desc
 * 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示
 * @Author zh wu
 * @Date 2020/5/22
 */
public class N498DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        int x = matrix[0].length;
        int y = matrix.length;
        int[] result = new int[(x + 1) * (y + 1)];

        int m = 0;
        int n = 0;
        for (int i = 0; i < result.length; i++) {
            // 赋值
            result[i] = matrix[m][n];
            // 奇数，往右上遍历
//            if () {
//
//            }
            // 偶数，往左下遍历
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[] result = findDiagonalOrder(matrix);
        System.out.println(result.length);
    }
}
