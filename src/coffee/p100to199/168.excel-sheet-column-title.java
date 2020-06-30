package coffee.p100to199;

/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 *
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (30.70%)
 * Likes:    1147
 * Dislikes: 240
 * Total Accepted:    216K
 * Total Submissions: 701.7K
 * Testcase Example:  '1'
 *
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "A"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 28
 * Output: "AB"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 701
 * Output: "ZY"
 * 
 */

/**
 * @File    :   168.excel-sheet-column-title.java
 * @Time    :   2020/06/28 23:29:00
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--; // very important, it handles the case n == 26.
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    // public static void main(String[] args) {
    //     Solution168 solution = new Solution168();
    //     System.out.println(solution.convertToTitle(1));
    //     System.out.println(solution.convertToTitle(26));
    //     System.out.println(solution.convertToTitle(27));
    //     System.out.println(solution.convertToTitle(Integer.MAX_VALUE));
    // }
}
// @lc code=end
