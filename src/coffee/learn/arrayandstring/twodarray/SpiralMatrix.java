package coffee.learn.arrayandstring.twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @File    :   SpiralMatrix.java
 * @Time    :   2020/05/20 22:47:21
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SpiralMatrix {
    /**
     * 分析循环结束的条件：
     * 假设这个矩阵的行数是 rows，列数是 cols，打印第一圈的左上角的坐标为(0,0)，
     * 第二圈的左上角的坐标是(1,1)，以此类推。
     *
     * 可以发现，左上角的坐标中行标和列标总是相同的，于是在矩阵中选取左上角为
     * (start,start)的一圈作为分析的目标。
     * 对于一个 5x5 的矩阵而言，最后一圈只有一个数字，对应的坐标为(2,2)。可以发现
     * 5>2x2。对于一个 6x6 的矩阵而言，最后一圈有4个数字，其左上角的坐标任然为
     * (2,2)。可以发现 6>2x2 依然成立。
     *
     * 注意退化的矩阵。
     *
     * 情况一：
     * [
     *   [1, 2, 3]
     * ]
     *
     * 情况二：
     * [
     *   [1],
     *   [2],
     *   [3]
     * ]
     *
     * 情况三：
     * [
     *   [1, 2, 3],
     *   [6, 5, 4]
     * ]
     *
     * @param matrix 2d array
     * @return spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length, start = 0;
        while (start * 2 < rows && start * 2 < cols) {
            spiral(matrix, start++, rows, cols, res);
        }
        return res;
    }

    private void spiral(int[][] matrix, int start,
                        int rows, int cols, List<Integer> res) {
        int endX = rows - start - 1, endY = cols - start - 1;

        // 从左到右
        for (int i = start; i <= endY; i++) {
            res.add(matrix[start][i]);
        }

        if (start < endX) {
            // 从上到下
            for (int i = start + 1; i <= endX; i++) {
                res.add(matrix[i][endY]);
            }

            if (start < endY) {
                // 从右到左
                for (int i = endY - 1; i >= start; i--) {
                    res.add(matrix[endX][i]);
                }

                if (start < endX - 1) {
                    // 从下到上
                    for (int i = endX - 1; i > start; i--) {
                        res.add(matrix[i][start]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> res = spiralMatrix.spiralOrder(matrix);
        System.out.println(Arrays.toString(res.toArray()));
    }
}