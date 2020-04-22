package p1to99;

import common.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (27.11%)
 * Likes:    3347
 * Dislikes: 475
 * Total Accepted:    624.9K
 * Total Submissions: 2.3M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Input: [2,1,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠    5
 * ⁠   / \
 * ⁠  1   4
 *  / \
 * 3   6
 * 
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
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
 * @File    :   98.validate-binary-search-tree.java
 * @Time    :   2020/04/22 11:50:30
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return inorder(root, new TreeNode[]{null});
    }

    private boolean inorder(TreeNode root, TreeNode[] last) {
        if (root == null) {
            return true;
        }
        boolean flag = true;
        if (root.left != null) {
            flag = inorder(root.left, last);
        }
        if (!flag || (last[0] != null && root.val <= last[0].val)) {
            return false;
        }
        last[0] = root;
        if (root.right != null) {
            flag = inorder(root.right, last);
        }
        return flag;
    }
}
// @lc code=end

