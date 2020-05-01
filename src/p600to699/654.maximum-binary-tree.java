package p600to699;

import common.TreeNode;

/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 *
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (78.83%)
 * Likes:    1582
 * Dislikes: 219
 * Total Accepted:    121.7K
 * Total Submissions: 154.3K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * The root is the maximum number in the array. 
 * The left subtree is the maximum tree constructed from left part subarray
 * divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number. 
 * 
 * 
 * 
 * 
 * Construct the maximum tree by the given array and output the root node of
 * this tree.
 * 
 * 
 * Example 1:
 * 
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * 
 * ⁠     6
 * ⁠   /   \
 * ⁠  3     5
 * ⁠   \    / 
 * ⁠    2  0   
 * ⁠     \
 * ⁠      1
 * 
 * 
 * 
 * Note:
 * 
 * The size of the given array will be in the range [1,1000].
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
 * @File    :   654.maximum-binary-tree.java
 * @Time    :   2020/05/01 08:56:32
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int idx = start;
        for (int i = start + 1, max = nums[start]; i <= end; i++) {
            if (nums[i] > max) {
                idx = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = build(nums, start, idx - 1);
        root.right = build(nums, idx + 1, end);
        return root;
    }
}
// @lc code=end

