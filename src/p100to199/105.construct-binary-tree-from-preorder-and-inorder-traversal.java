package p100to199;

import common.TreeNode;

import java.util.HashMap;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (46.68%)
 * Likes:    2857
 * Dislikes: 83
 * Total Accepted:    324.4K
 * Total Submissions: 694.9K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
 * @File    :   105.construct-binary-tree-from-preorder-and-inorder-traversal.java
 * @Time    :   2020/04/23 23:19:26
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, preorder, 0, preorder.length - 1, map);
    }

    private TreeNode build(int si, int[] pre, int sp, int ep,
                           HashMap<Integer, Integer> map) {
        if (sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(pre[sp]);
        int idx = map.get(root.val);
        int leftLen = idx - si;
        root.left = build(si, pre, sp + 1, sp + leftLen, map);
        root.right = build(idx + 1, pre, sp + leftLen + 1, ep, map);
        return root;
    }
}
// @lc code=end

