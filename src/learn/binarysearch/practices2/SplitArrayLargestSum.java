package learn.binarysearch.practices2;

/**
 * @File    :   SplitArrayLargestSum.java
 * @Time    :   2020/06/15 22:31:39
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m < 1) return -1;
        // lo: largest valie in nums; hi: sum of all value in nums
        long lo = nums[0], hi = 0;
        for (int num: nums) {
            lo = Math.max(lo, num);
            hi += num;
        }

        if (m == 1) return (int)hi;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (valid(nums, m, mid)) {
                // if the number of subarrays is not larger than m, mid could be smaller
                hi = mid - 1;
            } else {
                // if the number of subarrays is larger than m, mid should be larger
                lo = mid + 1;
            }
        }
        return (int)lo;
    }

    private boolean valid(int[] nums, int m, long mid) {
        int partCnt = 1;
        long sum = 0;
        // Here it is actually not from left to right, the order doesn't matter,
        // it is easy to prove:
        //
        // If a + b > t, c + d > t, there is no way to put a + b + c + d in
        // one array. That is to say, it could be a + b + c > t, d > t,
        // or a > t, b + c + d > t. It doesn't matter, the number of subarrays
        // is still 2, which is equal to a+b>t, and c+d > t.
        for (int num: nums) {
            sum += num;
            if (sum > mid) {
                // find a way to form subarray, as said before, it doesn't matter
                // how to form the subarray the number matters, which will not
                // change according to the ways to form a subarray.
                sum = num;
                partCnt++;
                if (partCnt > m) {
                    return false;
                }
            }
        }
        return true;
    }
}