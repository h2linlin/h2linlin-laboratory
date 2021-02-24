package lc;

/**
 * @Desc
 * 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 解释:
 *
 *  
 *
 * 说明:
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author zh wu
 * @Date 2020/5/22
 */
public class N498DiagonalTraverse {
    // 解法1：暴力法。直接遍历，共有5种情况：碰到上、下、左、右边，以及正常遍历。
    // 难点是边界的判定，考虑数组是1维数组的情况。
    public static int[] findDiagonalOrder(int[][] mx) {
        if (mx == null || mx.length == 0 || mx[0].length == 0) {
            return new int[0];
        }

        int[] result = new int[mx.length * mx[0].length];

        boolean leftUp = true;
        int x = 0;
        int y = 0;
        for (int i = 0; i < result.length; i++) {
            if (leftUp) {
                // 右上移动
                // 赋值
                result[i] = mx[x][y];

                // 卡在右上角，即右边上边都碰到
                if ((y + 1 > mx[0].length - 1) && (x - 1 < 0)) {
                    x++;
                    leftUp = false;
                    continue;
                }

                // 只碰到右边
                if (y + 1 > mx[0].length - 1) {
                    x++;
                    leftUp = false;
                    continue;
                }

                // 只碰到上边
                if (x - 1 < 0) {
                    y++;
                    leftUp = false;
                    continue;
                }

                // 都没碰到
                y++;
                x--;
            } else {
                // 左下移动
                // 赋值
                result[i] = mx[x][y];

                // 避免卡在左下角，即左边右边都碰到
                if ((y - 1 < 0) && (x + 1 > mx.length - 1)) {
                    y++;
                    leftUp = true;
                    continue;
                }

                // 只碰到左边
                if (y - 1 < 0) {
                    x++;
                    leftUp = true;
                    continue;
                }

                // 只碰到下边
                if (x + 1 > mx.length - 1) {
                    y++;
                    leftUp = true;
                    continue;
                }

                // 都没碰到
                y--;
                x++;
            }
        }

        return result;
    }

    // 解法2：略。思路：按单一方向遍历所有对角线，然后为偶数的对角线结果进行反转拼接即可。

    public static void main(String[] args) {
        // 输入
        int[][] matrix = new int[0][0];
        display(matrix);

        // 计算
        int[] result = findDiagonalOrder(matrix);

        // 输出
        System.out.println();
        display(result);
    }

    // 显示
    private static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 显示
    private static void display(int[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + " ");
        }
    }
}
