package coffee.learn.arrays101.conclusion;

import java.util.Arrays;

/**
 * @File    :   HeightChecker.java
 * @Time    :   2020/05/19 22:36:47
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] targets = new int[heights.length];
        System.arraycopy(heights, 0, targets, 0, heights.length);
        Arrays.sort(targets);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != targets[i]) cnt++;
        }
        return cnt;
    }
}