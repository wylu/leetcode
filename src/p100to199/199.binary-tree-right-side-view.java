package p100to199;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (52.39%)
 * Likes:    1858
 * Dislikes: 107
 * Total Accepted:    254.4K
 * Total Submissions: 485.3K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠   1            <---
 * ⁠ /   \
 * 2     3         <---
 *  ⁠\     \
 * ⁠  5     4       <---
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
 * @File    :   199.binary-tree-right-side-view.java
 * @Time    :   2020/04/25 12:33:16
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution199 {
    public List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        preorder(root, 0);
        return res;
    }

    private void preorder(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(root.val);
        } else {
            res.set(depth, root.val);
        }
        preorder(root.left, depth + 1);
        preorder(root.right, depth + 1);
    }
}
// @lc code=end

