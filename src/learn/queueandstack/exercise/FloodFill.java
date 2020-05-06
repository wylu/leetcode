package learn.queueandstack.exercise;

/**
 * @File    :   FloodFill.java
 * @Time    :   2020/05/06 20:49:18
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length
                || image[x][y] != color) return;
        image[x][y] = newColor;
        dfs(image, x - 1, y, color, newColor);
        dfs(image, x + 1, y, color, newColor);
        dfs(image, x, y - 1, color, newColor);
        dfs(image, x, y + 1, color, newColor);
    }
}