package lc.codingcarl.array;

public class N0059A {
    public static void main(String[] args) {
        generateMatrix(1);
    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int x = -1;
        int y = -1;

        int xMin = 0;
        int xMax = n - 1;
        int yMin = 0;
        int yMax = n - 1;

        for (int i = 1; i <= n * n;) {
            x = xMin;
            y = yMin;

            while (y < yMax) { arr[x][y++] = i++; }
            while (x < xMax) { arr[x++][y] = i++; }
            while (y > yMin) { arr[x][y--] = i++; }
            while (x > xMin) { arr[x--][y] = i++; }

            if (n % 2 == 1 && yMin == n >> 1) {arr[ n >> 1][ n >> 1] = i++;}

            xMin++;
            xMax--;
            yMin++;
            yMax--;
        }

        return arr;
    }
}
