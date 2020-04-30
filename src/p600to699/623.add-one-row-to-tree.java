package p600to699;

import common.TreeNode;

import java.util.LinkedList;

/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
 *
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 *
 * algorithms
 * Medium (48.91%)
 * Likes:    378
 * Dislikes: 119
 * Total Accepted:    34.9K
 * Total Submissions: 71.3K
 * Testcase Example:  '[4,2,6,3,1,5]\n1\n2'
 *
 * Given the root of a binary tree, then value v and depth d, you need to add a
 * row of nodes with value v at the given depth d. The root node is at depth
 * 1. 
 * 
 * The adding rule is: given a positive integer depth d, for each NOT null tree
 * nodes N in depth d-1, create two tree nodes with value v as N's left subtree
 * root and right subtree root. And N's original left subtree should be the
 * left subtree of the new left subtree root, its original right subtree should
 * be the right subtree of the new right subtree root. If depth d is 1 that
 * means there is no depth d-1 at all, then create a tree node with value v as
 * the new root of the whole original tree, and the original tree is the new
 * root's left subtree.
 * 
 * Example 1:
 * 
 * Input: 
 * A binary tree as following:
 * ⁠      4
 * ⁠    /   \
 * ⁠   2     6
 * ⁠  / \   / 
 * ⁠ 3   1 5   
 * 
 * v = 1
 * 
 * d = 2
 * 
 * Output: 
 * ⁠      4
 * ⁠     / \
 * ⁠    1   1
 * ⁠   /     \
 * ⁠  2       6
 * ⁠ / \     / 
 * ⁠3   1   5   
 * 
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * A binary tree as following:
 * ⁠     4
 * ⁠    /   
 * ⁠   2    
 * ⁠  / \   
 * ⁠ 3   1    
 * 
 * v = 1
 * 
 * d = 3
 * 
 * Output: 
 * ⁠      4
 * ⁠     /
 * ⁠    2
 * ⁠   / \
 * ⁠  1   1
 * ⁠ /     \
 * 3       1
 * 
 * 
 * 
 * Note:
 * 
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
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
 * @File    :   623.add-one-row-to-tree.java
 * @Time    :   2020/04/30 23:36:37
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null || d < 1) {
            return null;
        }

        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curTail = root, nextTail = null;
        int depth = 1;
        while (!queue.isEmpty()) {
            if (depth == d - 1) {
                while (!queue.isEmpty()) {
                    TreeNode cur = queue.poll();
                    TreeNode nodeLeft = new TreeNode(v);
                    TreeNode nodeRight = new TreeNode(v);
                    nodeLeft.left = cur.left;
                    nodeRight.right = cur.right;
                    cur.left = nodeLeft;
                    cur.right = nodeRight;
                }
                break;
            }
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nextTail = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextTail = node.right;
            }
            if (node == curTail) {
                curTail = nextTail;
                depth++;
            }
        }
        return root;
    }
}
// @lc code=end

