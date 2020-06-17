package p1to99;

/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (44.10%)
 * Likes:    1263
 * Dislikes: 9424
 * Total Accepted:    392.9K
 * Total Submissions: 890.1K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence. You can do so recursively, in other words from the
 * previous member read off the digits, counting the number of digits in groups
 * of the same digit.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * Explanation: This is the base case.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and
 * "1", "2" can be read as "12" which means frequency = 1 and value = 2, the
 * same way "1" is read as "11", so the answer is the concatenation of "12" and
 * "11" which is "1211".
 * 
 * 
 */

/**
 * @File    :   38.count-and-say.java
 * @Time    :   2020/06/17 22:15:41
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution38 {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        char[] chs = countAndSay(n - 1).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chs.length - 1; i >= 0;) {
            int cnt = 1, j = i - 1;
            sb.append(chs[i]);
            while (j >= 0 && chs[j] == chs[i]) {
                j--;
                cnt++;
            }
            sb.append(cnt);
            i = j;
        }
        return sb.reverse().toString();
    }

    // public static void main(String[] args) {
    //     Solution38 solution = new Solution38();
    //     System.out.println(solution.countAndSay(1));
    //     System.out.println(solution.countAndSay(2));
    //     System.out.println(solution.countAndSay(3));
    //     System.out.println(solution.countAndSay(4));
    //     System.out.println(solution.countAndSay(5));
    //     // 13211311123113112211
    //     System.out.println(solution.countAndSay(10));
    // }
}
// @lc code=end
