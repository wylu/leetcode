package coffee.p100to199;

/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 *
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (54.05%)
 * Likes:    951
 * Dislikes: 152
 * Total Accepted:    285.7K
 * Total Submissions: 527.4K
 * Testcase Example:  '"A"'
 *
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "A"
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "AB"
 * Output: 28
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "ZY"
 * Output: 701
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 * 
 * 
 */

/**
 * @File    :   171.excel-sheet-column-number.java
 * @Time    :   2020/06/28 23:00:32
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution171 {
    public int titleToNumber(String s) {
        int res = 0;
        for (char ch : s.toCharArray()) {
            res = res * 26 + (ch - 'A' + 1);
        }
        return res;
    }

    // public static void main(String[] args) {
    //     Solution171 solution = new Solution171();
    //     System.out.println(solution.titleToNumber("A"));
    //     System.out.println(solution.titleToNumber("AA"));
    //     System.out.println(solution.titleToNumber("FXSHRXW"));
    // }
}
// @lc code=end
