package coffee.learn.binarysearch.practices2;

import java.util.Arrays;

/**
 * @File    :   FindKthSmallestPairDistance.java
 * @Time    :   2020/06/14 23:38:23
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindKthSmallestPairDistance {
    /**
     * We will use a sliding window approach to count the number of pairs
     * with distance <= guess.
     *
     * For every possible right, we maintain the loop invariant: left is the
     * smallest value such that nums[right] - nums[left] <= guess. Then, the
     * number of pairs with right as it's right-most endpoint is right - left,
     * and we add all of these up.
     *
     * @param nums an integer array
     * @param k k-th smallest
     * @return k-th smallest distance
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0;
            for (int left = 0, right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}