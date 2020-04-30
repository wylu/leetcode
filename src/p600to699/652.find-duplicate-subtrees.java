package p600to699;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (49.34%)
 * Likes:    1133
 * Dislikes: 189
 * Total Accepted:    56.8K
 * Total Submissions: 114.9K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1: 
 * 
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * The following are two duplicate subtrees:
 * 
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * and
 * 
 * 
 * ⁠   4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
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
 * @File    :   652.find-duplicate-subtrees.java
 * @Time    :   2020/05/01 00:07:48
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution652 {
    private HashMap<String, Boolean> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private String postorder(TreeNode root, ArrayList<TreeNode> res) {
        if (root == null) return null;
        String left = postorder(root.left, res);
        if (left == null) left = "L";
        String right = postorder(root.right, res);
        if (right == null) right = "R";
        String subTree = left + root.val + right;
        if (map.containsKey(subTree)) {
            if (!map.get(subTree)) {
                res.add(root);
                map.put(subTree, true);
            }
        } else {
            map.put(subTree, false);
        }
        return subTree;
    }
}
// @lc code=end

