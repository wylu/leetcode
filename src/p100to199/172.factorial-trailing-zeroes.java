package p100to199;

/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (37.73%)
 * Likes:    822
 * Dislikes: 1089
 * Total Accepted:    207K
 * Total Submissions: 548.6K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 */

/**
 * @File    :   172.factorial-trailing-zeroes.java
 * @Time    :   2020/06/29 22:32:38
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
// @lc code=end
