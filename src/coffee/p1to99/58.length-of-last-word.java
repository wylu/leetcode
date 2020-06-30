package coffee.p1to99;

/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.51%)
 * Likes:    632
 * Dislikes: 2366
 * Total Accepted:    369.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word (last word means the last
 * appearing word if we loop from left to right) in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a maximal substring consisting of non-space
 * characters only.
 * 
 * Example:
 * 
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 * 
 * 
 */

/**
 * @File    :   58.length-of-last-word.java
 * @Time    :   2020/06/17 23:01:03
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = 0, tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ')
            tail--;
        while (tail >= 0 && s.charAt(tail) != ' ') {
            tail--;
            len++;
        }
        return len;
    }

    //  public static void main(String[] args) {
    //      Solution58 solution = new Solution58();
    //      System.out.println(solution.lengthOfLastWord("Hello World"));
    //      System.out.println(solution.lengthOfLastWord("Hello World   "));
    //      System.out.println(solution.lengthOfLastWord("World   "));
    //      System.out.println(solution.lengthOfLastWord("  World   "));
    //  }
}
// @lc code=end
