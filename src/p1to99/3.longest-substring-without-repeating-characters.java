package p1to99;

import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms Medium (29.59%) Likes: 7855 Dislikes: 470 Total Accepted: 1.3M Total Submissions: 4.5M
 * Testcase Example: '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. ⁠ Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            } else {
                ans = Math.max(ans, right - left + 1);
            }
            map.put(ch, right);
        }
        return ans;
    }

    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null) {
    //         return -1;
    //     }
    //     int[] index = new int[128];
    //     int ans = 0;
    //     for (int left = 0, right = 0; right < s.length(); right++) {
    //         left = Math.max(index[s.charAt(right)], left);
    //         ans = Math.max(ans, right - left + 1);
    //         index[s.charAt(right)] = right + 1;
    //     }
    //     return ans;
    // }

    // public static void main(String[] args) {
    //     Solution3 solution = new Solution3();
    //     System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    //     System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    //     System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    //     System.out.println(solution.lengthOfLongestSubstring(" "));
    // }
}
// @lc code=end
