package p600to699;

import common.TreeNode;

import java.util.HashSet;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (54.63%)
 * Likes:    1297
 * Dislikes: 133
 * Total Accepted:    129.7K
 * Total Submissions: 237.2K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * ⁠    5
 * ⁠   / \
 * ⁠  3   6
 *  ⁠/ \   \
 * 2   4   7
 * 
 * Target = 9
 * 
 * Output: True
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * ⁠    5
 * ⁠   / \
 * ⁠  3   6
 * ⁠ / \   \
 * 2   4   7
 * 
 * Target = 28
 * 
 * Output: False
 * 
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
 * @File    :   653.two-sum-iv-input-is-a-bst.java
 * @Time    :   2020/05/01 08:40:23
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return preorder(root, k, set);
    }

    private boolean preorder(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        int rest = k - root.val;
        if (set.contains(rest)) {
            return true;
        }
        set.add(root.val);
        return preorder(root.left, k, set) || preorder(root.right, k, set);
    }
}
// @lc code=end

