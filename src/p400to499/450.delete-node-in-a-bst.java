package p400to499;

import common.TreeNode;

/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (42.15%)
 * Likes:    1498
 * Dislikes: 77
 * Total Accepted:    100.4K
 * Total Submissions: 237.8K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * 
 * 
 * Note: Time complexity should be O(height of tree).
 * 
 * Example:
 * 
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 * ⁠    5
 * ⁠   / \
 * ⁠  3   6
 * ⁠ / \   \
 * 2   4   7
 * 
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * 
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * 
 * ⁠    5
 * ⁠   / \
 * ⁠  4   6
 *  ⁠/     \
 * 2       7
 * 
 * Another valid answer is [5,2,6,null,4,null,7].
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
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
 * @File    :   450.delete-node-in-a-bst.java
 * @Time    :   2020/04/28 23:17:26
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode pre = null, cur = root;
        while (cur != null && cur.val != key) {
            pre = cur;
            cur = cur.val > key ? cur.left : cur.right;
        }
        if (pre == null) {
            return deleteNode(root);
        }
        if (pre.left == cur) {
            pre.left = deleteNode(cur);
        } else {
            pre.right = deleteNode(cur);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode pre = null, next = root.right;
        while (next.left != null) {
            pre = next;
            next = next.left;
        }
        next.left = root.left;
        if (root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }
}
// @lc code=end

