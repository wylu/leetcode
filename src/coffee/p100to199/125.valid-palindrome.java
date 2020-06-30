package coffee.p100to199;

/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (35.45%)
 * Likes:    1156
 * Dislikes: 2836
 * Total Accepted:    570.8K
 * Total Submissions: 1.6M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */

/**
 * @File    :   125.valid-palindrome.java
 * @Time    :   2020/06/18 23:30:49
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }

    // public static void main(String[] args) {
    //     Solution125 solution = new Solution125();
    //     System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    //     System.out.println(solution.isPalindrome("8A man, a plan, a canal: Panama8"));
    //     System.out.println(solution.isPalindrome("race a car"));
    // }
}
// @lc code=end
