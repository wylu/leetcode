package coffee.learn.recursion2.conclusion;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @File    :   TheSkylineProblem.java
 * @Time    :   2020/05/15 22:32:29
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class TheSkylineProblem {
    /**
     * https://www.youtube.com/watch?v=GSBLe8cKu0s
     *
     * @param buildings [[2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8]]
     * @return [[2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0]]
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skylines = new ArrayList<>();
        // height list to store all buildings' heights
        List<int[]> height = new ArrayList<>();
        for (int[] b: buildings) {
            // start of a building, height stored as negtive
            height.add(new int[]{b[0], -b[2]});
            // end of a building, height stored as positive
            height.add(new int[]{b[1], b[2]});
        }
        // sort the height list
        height.sort((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        // a pq that stores all the encountered buildings' heights in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap.offer(0);
        int preMax = 0;
        for (int[] h: height) {
            if (h[1] < 0) {
                // h[1] < 0, that means it meets a new building, so add it to pq
                maxHeap.offer(-h[1]);
            } else {
                // h[1] >=0, that means it has reached the end of the building,
                // so remove it from pq
                maxHeap.remove(h[1]);
            }

            // the current max height in all encountered buildings
            int curMax = maxHeap.peek();
            if (curMax != preMax) {
                // if the max height is different from the previous one, that means
                // a critical point is met, add to result list
                List<Integer> point = new ArrayList<>();
                point.add(h[0]);
                point.add(curMax);
                skylines.add(point);
                preMax = curMax;
            }
        }
        return skylines;
    }
}