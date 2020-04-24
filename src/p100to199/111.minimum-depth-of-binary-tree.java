package p100to199;

import common.TreeNode;

/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (36.84%)
 * Likes:    1169
 * Dislikes: 630
 * Total Accepted:    385.7K
 * Total Submissions: 1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its minimum depth = 2.
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
 * @File    :   111.minimum-depth-of-binary-tree.java
 * @Time    :   2020/04/24 21:04:41
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution111 {
    public int res = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minimum(root, 0);
        return res;
    }

    private void minimum(TreeNode root, int curDepth) {
        if (curDepth >= res) {
            return;
        }
        if (root.left == null && root.right == null) {
            res = Math.min(res, curDepth + 1);
            return;
        }
        if (root.left != null) {
            minimum(root.left, curDepth + 1);
        }
        if (root.right != null) {
            minimum(root.right, curDepth + 1);
        }
    }
}
// @lc code=end

