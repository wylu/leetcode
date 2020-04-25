package p100to199;

import common.TreeNode;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * algorithms
 * Medium (46.08%)
 * Likes:    1089
 * Dislikes: 33
 * Total Accepted:    233.3K
 * Total Submissions: 505.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number
 * 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * 
 * 
 * Input: [4,9,0,5,1]
 * ⁠    4
 * ⁠   / \
 * ⁠  9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * @File    :   129.sum-root-to-leaf-numbers.java
 * @Time    :   2020/04/25 10:08:29
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution129 {
    public int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return res;
        }
        sumNumbers(root, 0);
        return res;
    }

    private void sumNumbers(TreeNode root, int cur) {
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += cur;
            return;
        }
        if (root.left != null) {
            sumNumbers(root.left, cur);
        }
        if (root.right != null) {
            sumNumbers(root.right, cur);
        }
    }
}
// @lc code=end

