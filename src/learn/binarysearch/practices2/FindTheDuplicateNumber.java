package learn.binarysearch.practices2;

/**
 * @File    :   FindTheDuplicateNumber.java
 * @Time    :   2020/05/31 23:38:05
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindTheDuplicateNumber {
    /**
     * Floyd's Tortoise and Hare (Cycle Detection)
     * @param nums An array nums containing n + 1 integers where each integer
     *             is between 1 and n (inclusive),
     * @return Duplicate number
     */
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[nums[0]];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        // Find the "entrance" to the cycle
        tortoise = 0;
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }
}