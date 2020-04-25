package p100to199;

import common.TreeNode;

/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (32.70%)
 * Likes:    2887
 * Dislikes: 242
 * Total Accepted:    297.7K
 * Total Submissions: 910.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 *   -10
 *   / \
 *  9  20
 *  /   \
 * 15    7
 * 
 * Output: 42
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
 * @File    :   124.binary-tree-maximum-path-sum.java
 * @Time    :   2020/04/25 09:24:36
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution124 {
    public int res = Integer.MIN_VALUE;

    /**
     * 一个路径从开始到结束，会在树上上升0或更多步，然后下降0或更多步；
     * 一但下降，它就不能再上升。每个路径都有一个最高结点，这也是该路径
     * 上所有其它结点的最低公共祖先。
     *
     * @param root 树的根结点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        maximum(root);
        return res;
    }

    /**
     * 该递归方法计算包含输入结点值的最大路径和，并根据需要更新结果。
     * 返回包含该结点值的一个最大路径，这个路径只上升或只下降，便于
     * 该结点的父结点根据已有的路径和来计算最大路径和。
     *
     * @param root 树的根结点
     * @return root.val + Math.max(maximum(root.left), maximum(root.right))
     *         1.只包含当前的根结点
     *         2.根结点+左子树路径（只上升或只下降）
     *         3.根结点+右子树路径（只上升或只下降）
     */
    private int maximum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maximum(root.left));
        int right = Math.max(0, maximum(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
// @lc code=end

