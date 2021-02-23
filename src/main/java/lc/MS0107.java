package lc;

/**
 * 面试题01.07 旋转矩阵
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 题解：
 * 方法一、水平翻转，再对角线翻转
 * 方法二、相当于是坐标系翻转，找变化前后坐标对应的变化规律即可。
 *
 */
public class MS0107 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        display(matrix);

        int[][] result = rotate2(matrix);

        System.out.println();

        display(result);
    }

    private static int[][] rotate(int[][] matrix) {
        // 一圈一圈移动

        // 用于临时存放
        int temp;
        // 需要转圈的层数。总长度为奇数的层数等效于总长度小于1的偶数层数。
        int level = matrix.length / 2;


        // 一圈一圈转，每次转圈的起始位置为matrix[i][i]
        for (int i = 0; i < level; i++) {
            // 每增加一层，步长少二。初始步长为总长度- 1
            // 所以：转圈的步长 = 总长度- 1 - 当前层数序号*2
            int step = matrix.length - 1 - i * 2;
            temp = matrix[i][i];
            for (int j = 0; j < step; j++) {

            }
        }

        return matrix;
    }

    private static int[][] rotate2(int[][] matrix) {
        int a;
        int n=matrix.length;
        for (int i = 0; i <n/2 ; i++) {
            for (int j = i; j <n-i-1; j++) {
                a=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=a;
            }
        }
        return matrix;
    }

    // 显示
    private static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
