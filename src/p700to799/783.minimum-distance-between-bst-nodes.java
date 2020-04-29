package p700to799;

import common.TreeNode;

/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 *
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 *
 * algorithms
 * Easy (51.83%)
 * Likes:    578
 * Dislikes: 167
 * Total Accepted:    55.1K
 * Total Submissions: 106.1K
 * Testcase Example:  '[4,2,6,1,3,null,null]'
 *
 * Given a Binary Search Tree (BST) with the root node root, return the minimum
 * difference between the values of any two different nodes in the tree.
 * 
 * Example :
 * 
 * 
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * 
 * The given tree [4,2,6,1,3,null,null] is represented by the following
 * diagram:
 * 
 * ⁠         4
 * ⁠       /   \
 * ⁠     2      6
 * ⁠    / \    
 * ⁠   1   3  
 * 
 * while the minimum difference in this tree is 1, it occurs between node 1 and
 * node 2, also between node 3 and node 2.
 * 
 * 
 * Note:
 * 
 * 
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's
 * value is different.
 * This question is the same as 530:
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * @File    :   783.minimum-distance-between-bst-nodes.java
 * @Time    :   2020/04/29 23:19:12
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution783 {
    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - pre.val));
        }
        pre = root;
        inorder(root.right);
    }
}
// @lc code=end

