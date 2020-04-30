package p600to699;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (61.92%)
 * Likes:    1119
 * Dislikes: 148
 * Total Accepted:    113.7K
 * Total Submissions: 183.5K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 * 
 * Example 1:
 * 
 * Input:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on
 * level 2 is 11. Hence return [3, 14.5, 11].
 * 
 * 
 * 
 * Note:
 * 
 * The range of node's value is in the range of 32-bit signed integer.
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
 * @File    :   637.average-of-levels-in-binary-tree.java
 * @Time    :   2020/04/30 23:56:46
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curTail = root, nextTail = null;
        double sum = 0, count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count += 1;
            sum += node.val;
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
                res.add(sum / count);
                sum = 0;
                count = 0;
            }
        }
        return res;
    }
}
// @lc code=end

