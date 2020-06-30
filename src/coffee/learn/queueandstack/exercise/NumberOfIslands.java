package coffee.learn.queueandstack.exercise;

/**
 * @File    :   NumberOfIslands.java
 * @Time    :   2020/05/04 21:07:42
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class NumberOfIslands {
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != '1') return;
        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}