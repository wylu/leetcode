package p500to599;

import common.TreeNode;

import java.util.LinkedList;

/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (60.58%)
 * Likes:    793
 * Dislikes: 126
 * Total Accepted:    96.6K
 * Total Submissions: 159.3K
 * Testcase Example:  '[2,1,3]'
 *
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree. 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Output:
 * 1
 * 
 * 
 * 
 * ⁠ Example 2: 
 * 
 * Input:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * Output:
 * 7
 * 
 * 
 * 
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
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
 * @File    :   513.find-bottom-left-tree-value.java
 * @Time    :   2020/04/29 22:13:21
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curTail = root, nextTail = null;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                nextTail = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextTail = cur.right;
            }
            if (cur == curTail) {
                curTail = nextTail;
                if (!queue.isEmpty()) {
                    res = queue.peek().val;
                }
            }
        }
        return res;
    }
}
// @lc code=end

