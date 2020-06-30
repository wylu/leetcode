package coffee.p400to499;

import coffee.common.TreeNode;

/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (50.45%)
 * Likes:    986
 * Dislikes: 111
 * Total Accepted:    163.8K
 * Total Submissions: 324.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
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
 * @File    :   404.sum-of-left-leaves.java
 * @Time    :   2020/04/27 22:21:33
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution404 {
    public int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return res;
        }
        sumOfLeftLeaves(root, true);
        return res;
    }

    private void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            res += root.val;
            return;
        }
        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
    }
}
// @lc code=end

