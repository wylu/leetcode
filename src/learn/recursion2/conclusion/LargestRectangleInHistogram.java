package learn.recursion2.conclusion;

/**
 * @File    :   LargestRectangleInHistogram.java
 * @Time    :   2020/05/14 22:45:24
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] lefts = new int[heights.length];
        lefts[0] = -1;
        for (int i = 1, idx; i < heights.length; i++) {
            idx = i - 1;
            while (idx >= 0 && heights[idx] >= heights[i]) {
                idx = lefts[idx];
            }
            lefts[i] = idx;
        }

        int[] rights = new int[heights.length];
        rights[heights.length - 1] = heights.length;
        for (int i = heights.length - 2, idx; i >= 0; i--) {
            idx = i + 1;
            while (idx < heights.length && heights[idx] >= heights[i]) {
                idx = rights[idx];
            }
            rights[i] = idx;
        }

        int maxRect = 0;
        for (int i = 0; i < heights.length; i++) {
            maxRect = Math.max(maxRect, heights[i] * (rights[i] - lefts[i] - 1));
        }
        return maxRect;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }
}