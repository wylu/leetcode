package coffee.p100to199;

import coffee.common.TreeNode;

import java.util.HashMap;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (43.86%)
 * Likes:    1383
 * Dislikes: 29
 * Total Accepted:    201.6K
 * Total Submissions: 459.5K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
 * @File    :   106.construct-binary-tree-from-inorder-and-postorder-traversal.java
 * @Time    :   2020/04/23 23:28:53
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode build(int si, int[] post, int sp, int ep, HashMap<Integer, Integer> map) {
        if (sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(post[ep]);
        int idx = map.get(root.val);
        int leftLen = idx - si;
        root.left = build(si, post, sp, sp + leftLen - 1, map);
        root.right = build(idx + 1, post, sp + leftLen, ep - 1, map);
        return root;
    }
}
// @lc code=end

