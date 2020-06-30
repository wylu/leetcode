package coffee.learn.arrayandstring.twodarray;

import java.util.Arrays;

/**
 * @File    :   DiagonalTraverse.java
 * @Time    :   2020/05/20 21:43:03
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class DiagonalTraverse {
    /**
     * If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
     * if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
     * if out of top border (row < 0) then row = 0; change walk direction.
     * if out of left border (col < 0) then col = 0; change walk direction.
     * Otherwise, just go along with the current direction.
     *
     * @param matrix 2d array
     * @return diagonal traverse result
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0, d = 1;
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row -= d;
            col += d;

            if (row >= m) {row = m - 1; col += 2; d = -d;}
            if (col >= n) {col = n - 1; row += 2; d = -d;}
            if (row < 0) {row = 0; d = -d;}
            if (col < 0) {col = 0; d = -d;}
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        DiagonalTraverse traverse = new DiagonalTraverse();
        int[] res = traverse.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(res));
    }
}