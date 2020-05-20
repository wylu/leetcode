package learn.arrayandstring;

/**
 * @File    :   LargestNumberAtLeastTwiceOfOthers.java
 * @Time    :   2020/05/20 21:08:36
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        for (int num : nums) if (num != max && num * 2 > max) return -1;
        return idx;
    }
}