package coffee.learn.queueandstack.exercise;

import java.util.LinkedList;

/**
 * @File    :   Matrix.java
 * @Time    :   2020/05/06 21:07:31
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class Matrix {
    /**
     * 1.For our BFS routine, we keep a queue, q to maintain the queue of cells
     *   to be examined next.
     * 2.We start by adding all the cells with 0s to q.
     * 3.Intially, distance for each 0 cell is 0 and distance for each 1 is INT_MAX,
     *   which is updated during the BFS.
     * 4.Pop the cell from queue, and examine its neighbours. If the new calculated
     *   distance for neighbour {i,j} is smaller, we add {i,j} to q and update dist[i][j].
     *
     * @param matrix a matrix consists of 0 and 1
     * @return distance
     */
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) queue.offer(new int[]{i, j});
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int dx = dir[i][0], dy = dir[i][1];
                int nx = x + dx, ny = y + dy;
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) continue;
                if (dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }
}