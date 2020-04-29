package p500to599;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (60.02%)
 * Likes:    734
 * Dislikes: 57
 * Total Accepted:    88.8K
 * Total Submissions: 147.8K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * Output: [1, 3, 9]
 * 
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
 * @File    :   515.find-largest-value-in-each-tree-row.java
 * @Time    :   2020/04/29 22:52:28
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curTail = root, nextTail = null;
        int levelMax = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > levelMax) {
                levelMax = node.val;
            }
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
                res.add(levelMax);
                levelMax = Integer.MIN_VALUE;
            }
        }
        return res;
    }
}
// @lc code=end

