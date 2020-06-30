package coffee.p100to199;

import coffee.common.TreeNode;

/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (47.26%)
 * Likes:    2362
 * Dislikes: 286
 * Total Accepted:    317.4K
 * Total Submissions: 671.1K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠    1
 * ⁠   / \
 * ⁠  2   5
 * ⁠ / \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 *  ⁠\
 * ⁠  2
 * ⁠   \
 * ⁠    3
 * ⁠     \
 * ⁠      4
 * ⁠       \
 * ⁠        5
 * ⁠         \
 * ⁠          6
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
 * @File    :   114.flatten-binary-tree-to-linked-list.java
 * @Time    :   2020/04/24 22:10:35
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flat(root);
    }

    private TreeNode flat(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode lastLeft = null;
        if (root.left != null) {
            lastLeft = flat(root.left);
            lastLeft.right = root.right;
        }
        TreeNode lastRight = null;
        if (root.right != null) {
            lastRight = flat(root.right);
        }
        if (lastLeft != null) {
            root.right = root.left;
            root.left = null;
        }
        return lastRight != null ? lastRight : lastLeft;
    }
}
// @lc code=end

