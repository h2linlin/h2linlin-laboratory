package lc.datastruct.array;

/**
 * N48 旋转矩阵
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
 * 方法一、由外到内一圈一圈转。每转一次时，就是将4份边长-1的元素，逐个交换即可。
 * 方法二、水平翻转，再对角线翻转。
 *
 * 重要提醒：二维数组就是一个行列式。mx[x][y]，x代表行数，y代表列数。以此构成一个坐标系，垂直方向是x轴，水平方向是y轴。
 *
 */
public class N0048 {
    // 解法1：暴力法，由外向内，每层旋转。
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

    // 解法1：按 左上-右下 对角线翻转，再按垂直中心线翻转
    private static int[][] rotate2(int[][] matrix) {
//        int a;
//        int n=matrix.length;
//        for (int i = 0; i < n/2 ; i++) {
//            for (int j = i; j <n-i-1; j++) {
//                a=matrix[i][j];
//                matrix[i][j]=matrix[n-j-1][i];
//                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
//                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
//                matrix[j][n-i-1]=a;
//            }
//        }
        return matrix;
    }

    // 解法2：按 左上-右下 对角线翻转，再按垂直中心线翻转
    private static int[][] rotate3(int[][] mx) {
        // 按对角线翻转
        for (int x = 0; x < mx.length; x++) {
            for (int y = 0; y < x; y++) {
                int temp = mx[x][y];
                mx[x][y] = mx[y][x];
                mx[y][x] = temp;
            }
        }

        // 垂直翻转，即按过y轴中点的x轴平行线翻转。
        for (int x = 0; x < mx.length; x++) {
            for (int y = 0; y < mx.length/2; y++) {
                int temp = mx[x][y];
                mx[x][y] = mx[x][mx.length - y - 1];
                mx[x][mx.length - y - 1] = temp;
            }
        }

        return mx;
    }

    public static void main(String[] args) {
        // 输入
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        display(matrix);

        // 计算
        int[][] result = rotate3(matrix);

        // 输出
        System.out.println();
        display(result);
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
