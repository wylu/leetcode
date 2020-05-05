package learn.queueandstack.exercise;

/**
 * @File    :   TargetSum.java
 * @Time    :   2020/05/05 17:58:25
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        return find(nums, S, 0, 0);
    }

    private int find(int[] nums, int s, int i, int sum) {
        if (i == nums.length) return sum == s ? 1 : 0;
        int plus = find(nums, s, i + 1, sum + nums[i]);
        int minus = find(nums, s, i + 1, sum - nums[i]);
        return plus + minus;
    }
}