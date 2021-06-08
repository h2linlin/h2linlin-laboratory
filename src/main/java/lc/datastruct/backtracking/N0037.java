package lc.datastruct.backtracking;

/**
 * @Desc 37. 解数独
 * @Author h2linlin
 */
public class N0037 {

    /**
     * 解法：回溯法
     */
    public void solveSudoku(char[][] board) {
        backtracking(0, board);
    }

    private boolean backtracking(int x, char[][] board) {
        for (int i = x; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // 方格内已经有数字了
                if (board[i][j] != '.') {
                    continue;
                }

                for (char k = '1'; k <= '9'; k++) {
                    if (!isOk(i, j, k, board)) {
                        continue;
                    }

                    board[i][j] = k;
                    if (backtracking(i, board)) return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    // 判断是否可以放到该处
    private boolean isOk(int x, int y, char value, char[][] board) {
        // 1.判断行冲突
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == value) {
                return false;
            }
        }

        // 2.判断列冲突
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == value) {
                return false;
            }
        }

        // 3.判断9宫格冲突
        int startx = (x / 3) * 3;
        int starty = (y / 3) * 3;

        for (int i = startx; i < startx + 3; i++) {
            for (int j = starty; j < starty + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
