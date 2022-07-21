package lc.codingcarl.backtracking;

import java.util.*;

/**
 * @Desc 51. N 皇后
 * @Author h2linlin
 */
public class N0051 {
    /**
     * 解法：回溯法
     *
     * 剪枝限制条件：
     * 1.皇后不能位于同一列。
     * 2.不能位于同一行。
     * 3.不能位于同一45度斜线。
     * 4.不能位于同一135度斜线。
     *
     * 收集条件：
     * 到达最后一行。每一行就是一层。
     *
     */
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }

        rowNum = n;
        path = new String[n][n];
        backtracking(0);

        return results;
    }

    int rowNum;
    List<List<String>> results = new ArrayList<>();
    String[][] path;

    private void backtracking(int startX) {
        // 收集结果
        if (startX > rowNum - 1) {
            results.add(getPathList(path));
            return;
        }

        for (int y = 0; y < rowNum; y ++) {
            // 处理
            if (isConflict(startX, y)) {
                continue;
            }

            path[startX][y] = "Q";
            backtracking(startX + 1);
            path[startX][y] = ".";
        }
    }

    // 获取路径
    private List<String> getPathList(String[][] path) {
        List<String> pathList = new ArrayList<>(path.length);

        for (int x = 0; x < path.length; x++) {
            StringBuffer rowStr = new StringBuffer();
            for (int y = 0; y < path[0].length; y ++) {
                if ("Q".equals(path[x][y])) {
                    rowStr.append("Q");
                } else {
                    rowStr.append(".");
                }

            }
            pathList.add(new String(rowStr));
        }

        return pathList;
    }

    // 判断皇后位置是否冲突
    private boolean isConflict(int x, int y) {
        // 1.同行冲突：无需判断，每层只会放一个皇后。

        // 2.同列冲突
        for (int i = 0; i < rowNum; i ++) {
            if ("Q".equals(path[i][y])) {
                return true;
            }
        }

        // 3.45度斜线冲突。遍历检查点之前的点即可，无需遍历检查点之后的点。
        for (int i = x - 1, j = y + 1; i >= 0 && j <= rowNum - 1; i--, j++) {
            if ("Q".equals(path[i][j])) {
                return true;
            }
        }

        // 4.135度斜线冲突。遍历检查点之前的点即可，无需遍历检查点之后的点。
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(path[i][j])) {
                return true;
            }
        }
        return false;
    }
}
