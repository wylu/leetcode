package coffee.p100to199;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (58.16%)
 * Likes:    3138
 * Dislikes: 218
 * Total Accepted:    643K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */

/**
 * @File    :   169.majority-element.java
 * @Time    :   2020/06/27 23:36:24
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution169 {
    /**
     * 在遍历数组时保存两个值：一个是数组的一个数字；另一个是次数。
     * 当遍历到下一个数字时，如果下一个数字和之前保存的数字相同，则次数加1；
     * 如果下一个数字和之前保存的数字不同，则次数减一。如果次数为0，那么需要
     * 保存下一个数字，并将次数设为1。（由于我们要找的数字出现的次数比其他所
     * 有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时
     * 的数字）
     *
     * @param nums 数组
     * @return 出现次数超过数组长度一半的数字
     */
    public int majorityElement(int[] nums) {
        int cnt = 0, cur = 0;
        for (int num : nums) {
            if (cnt == 0)
                cur = num;
            cnt += (cur == num) ? 1 : -1;
        }
        return cur;
    }
}
// @lc code=end
