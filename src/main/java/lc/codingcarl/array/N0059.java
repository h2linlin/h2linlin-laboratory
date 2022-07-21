package lc.codingcarl.array;

import lc.DisplayUtil;

/**
 * @Desc
 * @Author h2linlin
 * @Date 2021/4/17
 */
public class N0059 {
    public static void main(String[] args) {
        // 输入
        int n = 5;
        DisplayUtil.display(n);
        DisplayUtil.display("n: " + n);

        // 计算
        int[][] result = solution1(n);

        // 输出
        DisplayUtil.display(result);
    }

    // 解法1：暴力法
    // 关键事要找准循环不变量，并一直坚持
    private static int[][] solution1(int n) {
        int[][] nums = new int[n][n];

        int loop = n / 2;   // 遍历几层，奇数层时，最中间的元素单独处理
        int startx = 0;     // 每层遍历开始位置
        int starty = 0;     // 每层遍历开始位置
        int num = 1;        // 用来赋值
        int length = n - 1; // 每层遍历时，边的长度

        while (loop > 0) {
            int offset = 0; // 每层遍历时，边的元素数量不一样

            // 遍历4个边，注意循环不变量，左闭右开
            for (int y = starty; y < starty + length; y++) {
                nums[startx][y] = num++;
            }

            for (int x = startx; x < startx + length; x++) {
                nums[x][starty + length] = num++;
            }


            for (int y = starty + length; y > starty; y--) {
                nums[startx + length][y] = num++;
            }

            for (int x = startx + length; x > startx; x--) {
                nums[x][starty] = num++;
            }

            loop --;
            startx ++;
            starty ++;
            length -= 2;
        }

        // 如果n为奇数，最后一个数字单独处理
        if (n % 2 == 1) {
            nums[n/2][n/2] = num;
        }

        return nums;
    }
}
