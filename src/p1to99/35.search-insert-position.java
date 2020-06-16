package p1to99;

/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.47%)
 * Likes:    2325
 * Dislikes: 249
 * Total Accepted:    625.4K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 * 
 */

/**
 * @File    :   35.search-insert-position.java
 * @Time    :   2020/06/16 22:54:17
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }

    // public static void main(String[] args) {
    //     Solution35 solution = new Solution35();
    //     System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
    //     System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
    //     System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    //     System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    // }
}
// @lc code=end
