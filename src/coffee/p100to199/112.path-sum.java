package coffee.p100to199;

import coffee.common.TreeNode;

/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 *
 * https://leetcode.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (40.24%)
 * Likes:    1583
 * Dislikes: 452
 * Total Accepted:    434.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠      5
 * ⁠     / \
 * ⁠    4   8
 * ⁠   /   / \
 * ⁠  11  13  4
 * ⁠ /  \      \
 * 7    2      1
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
 * @File    :   112.path-sum.java
 * @Time    :   2020/04/24 21:17:51
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int sum, int cur) {
        cur += root.val;
        if (root.left == null && root.right == null) {
            return sum == cur;
        }
        boolean flag = false;
        if (root.left != null) {
            flag = hasPathSum(root.left, sum, cur);
        }
        if (!flag && root.right != null) {
            flag = hasPathSum(root.right, sum, cur);
        }
        return flag;
    }
}
// @lc code=end

